package service;

import model.Order;
import state.*;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.ReentrantLock;

public class OrderService {

    private final ExecutorService executorService = Executors.newFixedThreadPool(5);
    private final ReentrantLock lock = new ReentrantLock();
    private static volatile OrderService orderService;
    private OrderService() {}

    public static OrderService getInstance() {
        if(orderService == null) {
            synchronized (OrderService.class) {
                if(orderService == null) {
                    orderService = new OrderService();
                }
            }
        }
        return orderService;
    }

    public void processOrder(Order order) {

        executorService.execute(() -> {
            lock.lock();
            try {
                List<OrderCommand> orderCommands = Arrays.asList(
                        new PlaceOrderCommand(order), // Step 1: Verify payment & place order
                        new PrepareOrderCommand(order), // Step 2: Prepare order
                        new DeliverOrderCommand(order), // Step 3: Assign delivery & deliver order
                        new CompleteOrderCommand(order) // Step 4: Free up the delivery person
                );

                for(OrderCommand command : orderCommands) {
                    try {
                        command.handleOrder();
                    } catch (Exception e) {
                        new CancelOrderCommand(order).handleOrder();
                        break;
                    }
                }
            } finally {
                lock.unlock();
            }
        });
    }
}