package state;

import enums.OrderStatus;
import model.Order;

public class PrepareOrderCommand implements OrderCommand {

    private final Order order;

    public PrepareOrderCommand(Order order) {
        this.order = order;
    }
    @Override
    public void handleOrder() {
        System.out.println("Order is prepared.");
        order.setStatus(OrderStatus.PREPARED);
    }
}
