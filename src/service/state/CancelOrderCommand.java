package service.state;

import enums.OrderStatus;
import model.Order;

public class CancelOrderCommand implements OrderCommand {

    @Override
    public void handleOrder(Order order) {
        System.out.println("Order is cancelled a refund has been initiated");
        order.setStatus(OrderStatus.CANCELLED);
        // Add some logic for refund
    }
}
