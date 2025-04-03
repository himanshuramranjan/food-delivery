package service;

import model.Restaurant;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class RestaurantService {
    private static volatile RestaurantService restaurantService;
    private final List<Restaurant> restaurantList;

    private RestaurantService() {this.restaurantList = new ArrayList<>(); }

    public static RestaurantService getInstance() {
        if(restaurantService == null) {
            synchronized (RestaurantService.class) {
                if(restaurantService == null) {
                    restaurantService = new RestaurantService();
                }
            }
        }
        return restaurantService;
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

    public List<Restaurant> getAllResturant() {
        return restaurantList;
    }

}
