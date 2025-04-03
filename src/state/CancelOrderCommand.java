package state;

import enums.OrderStatus;
import model.Order;

public class CancelOrderCommand implements OrderCommand {

    private Order order;

    public CancelOrderCommand(Order order) {
        this.order = order;
    }

    @Override
    public void handleOrder() {
        System.out.println("Order is cancelled a refund has been initiated");
        order.setStatus(OrderStatus.CANCELLED);
        // Add some logic for refund
    }
}
