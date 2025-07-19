package service.state;

import enums.OrderStatus;
import exception.DeliveryPersonNotFoundException;
import model.DeliveryPerson;
import model.Order;
import service.DeliveryService;

public class DeliverOrderCommand implements OrderCommand {

    @Override
    public void handleOrder(Order order) throws DeliveryPersonNotFoundException {
        DeliveryPerson deliveryPerson = DeliveryService.getInstance().assignDeliveryPerson();

        if(deliveryPerson == null) throw new DeliveryPersonNotFoundException("No DeliveryPerson available ");

        order.setDeliveryPerson(deliveryPerson);
        System.out.println("Order  is out for delivery by : " + deliveryPerson.getName());
        order.setStatus(OrderStatus.OUT_FOR_DELIVERY);
    }
}
