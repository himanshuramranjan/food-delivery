package service;

import model.DeliveryPerson;
import java.util.concurrent.ConcurrentLinkedDeque;

public class DeliveryService {
    private static volatile DeliveryService deliveryService;
    private ConcurrentLinkedDeque<DeliveryPerson> deliveryPersons;
    private DeliveryService() {
        this.deliveryPersons = new ConcurrentLinkedDeque<>();
    }

    public static DeliveryService getInstance() {
        if(deliveryService == null) {
            synchronized (DeliveryService.class) {
                if(deliveryService == null) {
                    deliveryService = new DeliveryService();
                }
            }
        }
        return deliveryService;
    }

    public void addDeliveryPerson(DeliveryPerson deliveryPerson) {
        this.deliveryPersons.add(deliveryPerson);
    }

    public synchronized DeliveryPerson assignDeliveryPerson() {

        // can use some strategies to assign the delivery person
        if(deliveryPersons.isEmpty()) {
            System.out.println("All delivery person are busy right now");
            return null;
        }
        return deliveryPersons.getFirst();
    }
}
