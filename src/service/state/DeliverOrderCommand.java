package service.state;

import enums.OrderStatus;
import model.DeliveryPerson;
import model.Order;
import service.DeliveryService;

public class DeliverOrderCommand implements OrderCommand {

    @Override
    public void handleOrder(Order order) {
        DeliveryPerson deliveryPerson = DeliveryService.getInstance().assignDeliveryPerson();
        order.setDeliveryPerson(deliveryPerson);
        System.out.println("Order  is out for delivery by : " + deliveryPerson.getName());
        order.setStatus(OrderStatus.OUT_FOR_DELIVERY);
    }
}
