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
        this.deliveryPersons.remove(deliveryPerson);
    }

    public void addDeliveryPerson(DeliveryPerson deliveryPerson) { deliveryPersons.add(deliveryPerson); }

    public DeliveryPerson assignDeliveryPerson() {
        return deliveryPersons.pollFirst();
    }

}
