package service;

import model.Order;
import service.state.*;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.function.Supplier;

public class OrderService {

    private final ExecutorService executorService = Executors.newFixedThreadPool(5);
    private OrderService() {}

    private static class OrderServiceHolder {
        private static final OrderService INSTANCE = new OrderService();
    }

    public static OrderService getInstance() {
        return OrderServiceHolder.INSTANCE;
    }

    private static final List<Supplier<OrderCommand>> commandPipeline = List.of(
            PlaceOrderCommand::new,
            PrepareOrderCommand::new,
            DeliverOrderCommand::new,
            CompleteOrderCommand::new
    );

    public void processOrder(Order order) {

        executorService.submit(() -> {
            for (Supplier<OrderCommand> commandSupplier : commandPipeline) {
                try {
                    OrderCommand command = commandSupplier.get();
                    command.handleOrder(order);
                } catch (Exception e) {
                    System.out.println("Error occurred while processing: " + e);
                    new CancelOrderCommand().handleOrder(order);
                    break; // stop pipeline on failure
                }
            }
        });
    }
}