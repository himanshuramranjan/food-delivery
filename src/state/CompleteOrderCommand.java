package state;

import enums.OrderStatus;
import model.Order;
import service.DeliveryService;

public class CompleteOrderCommand implements OrderCommand {

    private final Order order;

    public CompleteOrderCommand(Order order) {
        this.order = order;
    }

    @Override
    public void handleOrder() {
        System.out.println("Order " + order.getItems().toString() + "is delivered by " + order.getDeliveryPerson().getName());
        System.out.println("Please provide your review");

        // free up the delivery person
        DeliveryService.getInstance().addDeliveryPerson(order.getDeliveryPerson());
        order.setStatus(OrderStatus.DELIVERED);
    }
}
