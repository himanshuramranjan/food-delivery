package model;

import enums.OrderStatus;
import state.OrderCommand;

import java.util.Map;
import java.util.UUID;

public class Order {
    private final String orderId;
    private final Restaurant restaurant;
    private final Map<String, Integer> items;
    private double totalAmount;
    private OrderStatus status;
    private OrderCommand state;
    private DeliveryPerson deliveryPerson;

    public Order(Restaurant restaurant, Map<String, Integer> items) {
        this.orderId = UUID.randomUUID().toString();
        this.restaurant = restaurant;
        this.items = items;
        this.totalAmount = calculateTotalAmount();
        this.status = OrderStatus.PENDING;
    }

    // ideally this method should not be here, can be given this responsibility to some CashService
    private double calculateTotalAmount() {
        double amount = 0.0;
        Map<String, FoodItem> menu = this.restaurant.getMenu();
        for(String itemId : items.keySet()) {
            totalAmount += menu.get(itemId).getPrice() * items.get(itemId);
        }
        return amount;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }

    public void setState(OrderCommand state) {
        this.state = state;
    }

    public Restaurant getRestaurant() {
        return restaurant;
    }

    public Map<String, Integer> getItems() {
        return items;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public OrderCommand getState() {
        return state;
    }

    public DeliveryPerson getDeliveryPerson() {
        return deliveryPerson;
    }

    public void setDeliveryPerson(DeliveryPerson deliveryPerson) {
        this.deliveryPerson = deliveryPerson;
    }
}
