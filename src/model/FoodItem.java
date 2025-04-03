package model;

public class FoodItem {
    private final String itemId;
    private String name;
    private double price;
    private double avgRating;
    private int ratingCount;

    public FoodItem(String itemId, String name, double price) {
        this.itemId = itemId;
        this.name = name;
        this.price = price;
        this.avgRating = 0.0;
        this.ratingCount = 0;
    }

    public String getItemId() {
        return itemId;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public double getAvgRating() {
        return avgRating;
    }

    public int getRatingCount() {
        return ratingCount;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void addRating(int rating) {
        this.ratingCount += 1;
        this.avgRating = (getAvgRating() + rating) / getRatingCount();
    }

}
