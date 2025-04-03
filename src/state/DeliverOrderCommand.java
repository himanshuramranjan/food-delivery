package state;

import enums.OrderStatus;
import model.DeliveryPerson;
import model.Order;
import service.DeliveryService;

public class DeliverOrderCommand implements OrderCommand {

    private final Order order;

    public DeliverOrderCommand(Order order) {
        this.order = order;
    }

    @Override
    public void handleOrder() {
        DeliveryPerson deliveryPerson = DeliveryService.getInstance().assignDeliveryPerson();
        order.setDeliveryPerson(deliveryPerson);
        System.out.println("Order  is out for delivery by : " + deliveryPerson.getName());
        order.setStatus(OrderStatus.OUT_FOR_DELIVERY);
    }
}
