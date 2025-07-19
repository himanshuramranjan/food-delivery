package service.state;

import enums.OrderStatus;
import model.Order;
import service.DeliveryService;

public class CompleteOrderCommand implements OrderCommand {

    @Override
    public void handleOrder(Order order) {
        System.out.println("Order " + order.getItems().toString() + "is delivered by " + order.getDeliveryPerson().getName());
        System.out.println("Please provide your review");

        // free up the delivery person
        DeliveryService.getInstance().release(order.getDeliveryPerson());
        order.setStatus(OrderStatus.DELIVERED);
    }
}
