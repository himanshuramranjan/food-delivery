package service;

import model.Order;
import model.Restaurant;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

public class RestaurantService {
    private final List<Restaurant> restaurantList;

    private RestaurantService() {this.restaurantList = new ArrayList<>(); }

    private static class RestaurantServiceHolder {
        private static final RestaurantService INSTANCE = new RestaurantService();
    }

    public static RestaurantService getInstance() {
        return RestaurantServiceHolder.INSTANCE;
    }

    public void addRestaurant(List<Restaurant> restaurants) {
        this.restaurantList.addAll(restaurants);
    }

    public Restaurant getNearestRestaurant() {
        // return some logic to return the nearest restaurant
        return restaurantList.get(0);
    }

    public Restaurant getBestRestaurant() {
        return restaurantList.stream().max(Comparator.comparing(Restaurant::getAvgRating)).orElse(null);
    }

    public void placeOrder(Restaurant restaurant, Map<String, Integer> foodItems) {
        Order order = new Order(restaurant, foodItems);
        OrderService.getInstance().processOrder(order);
    }

    public List<Restaurant> getAllResturant() {
        return restaurantList;
    }

}
