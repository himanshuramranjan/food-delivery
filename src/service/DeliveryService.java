package service;

import model.DeliveryPerson;
import java.util.concurrent.ConcurrentLinkedDeque;

public class DeliveryService {
    private final ConcurrentLinkedDeque<DeliveryPerson> deliveryPersons;
    private DeliveryService() {
        this.deliveryPersons = new ConcurrentLinkedDeque<>();
    }

    private static class DeliveryServiceHolder {
        private static final DeliveryService INSTANCE = new DeliveryService();
    }

    public static DeliveryService getInstance() {
        return DeliveryServiceHolder.INSTANCE;
    }

    public void release(DeliveryPerson deliveryPerson) {
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
