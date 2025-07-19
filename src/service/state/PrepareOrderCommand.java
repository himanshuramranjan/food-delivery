package service.state;

import enums.OrderStatus;
import model.Order;

public class PrepareOrderCommand implements OrderCommand {
    @Override
    public void handleOrder(Order order) {
        System.out.println("Order is prepared.");
        order.setStatus(OrderStatus.PREPARED);
    }
}
