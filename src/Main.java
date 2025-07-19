import model.DeliveryPerson;
import model.FoodItem;
import model.Order;
import model.Restaurant;
import service.DeliveryService;
import service.OrderService;
import service.RestaurantService;

import java.util.Arrays;
import java.util.List;
import java.util.Map;


public class Main {
    public static void main(String[] args) {

        initialize();

        Restaurant bestRestaurant = RestaurantService.getInstance().getBestRestaurant();
        bestRestaurant.getMenu();
        RestaurantService.getInstance().placeOrder(bestRestaurant, Map.of("BUG001", 2));
    }

    public static void initialize() {
        FoodItem burger = new FoodItem("BUG001", "Burger", 5.99);
        FoodItem pizza = new FoodItem("PIZ001", "Pizza", 8.99);
        List<FoodItem> menu = Arrays.asList(burger, pizza);

        Restaurant restaurant = new Restaurant("RES001", "Foodies", "Downtown");
        restaurant.addFoodItem(menu);

        RestaurantService.getInstance().addRestaurant(List.of(restaurant));

        DeliveryPerson dp1 = new DeliveryPerson("Mike", "9876543210");
        DeliveryService.getInstance().addDeliveryPerson(dp1);
    }
}