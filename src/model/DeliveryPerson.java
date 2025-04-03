package model;

import java.util.UUID;

public class DeliveryPerson {
    private final String id;
    private final String name;
    private String phone;
    private String location;

    public DeliveryPerson(String name, String phone) {
        this.id = UUID.randomUUID().toString();
        this.name = name;
        this.phone = phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getName() {
        return name;
    }

    public String getPhone() {
        return phone;
    }

    public String getLocation() {
        return location;
    }
}
