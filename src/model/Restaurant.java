package model;

import java.util.*;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.stream.Collectors;

public class Restaurant {

    private final ReentrantReadWriteLock lock = new ReentrantReadWriteLock();
    private final String restaurantId;
    private String name;
    private String location;
    private Map<String, FoodItem> menu;
    private double avgRating;
    private int ratingCount;

    public Restaurant(String restaurantId, String name, String location) {
        this.restaurantId = restaurantId;
        this.name = name;
        this.location = location;
        this.menu = new HashMap<>();
        this.avgRating = 0.0;
        this.ratingCount = 0;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getName() {
        return name;
    }

    public String getLocation() {
        return location;
    }

    public Map<String, FoodItem> getMenu() {
        return this.menu;
    }

    public double getAvgRating() {
        return avgRating;
    }

    public int getRatingCount() {
        return ratingCount;
    }

    public void addFoodItem(List<FoodItem> items) {
        items.forEach(item -> menu.put(item.getItemId(), item));
    }

    public void removeFoodItem(FoodItem item) {
        menu.remove(item.getItemId());
    }

    public void addRating(int rating) {
        lock.writeLock().lock();
        try {
            this.ratingCount += 1;
            this.avgRating = (getAvgRating() + rating) / getRatingCount();
        } finally {
            lock.writeLock().unlock();
        }
    }

    public List<FoodItem> getMostLikedDish() {
        return this.menu.values().stream().sorted(Comparator.comparing(FoodItem::getAvgRating)).collect(Collectors.toList());
    }
}
