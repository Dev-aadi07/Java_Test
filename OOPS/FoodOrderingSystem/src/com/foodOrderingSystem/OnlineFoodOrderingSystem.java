package com.foodOrderingSystem;

import java.util.ArrayList;
import java.util.List;

// ===== Abstract Class (Abstraction) =====
abstract class FoodItem {
    private int id;          // Encapsulation
    private String name;
    private double price;

    // Constructor
    public FoodItem(int id, String name, double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    // Getters & Setters (Encapsulation)
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    // Abstract Method (Abstraction)
    public abstract double calculateDiscount();
}


// ===== Subclass 1 =====
class VegItem extends FoodItem {

    public VegItem(int id, String name, double price) {
        super(id, name, price);
    }

    @Override
    public double calculateDiscount() {
        return getPrice() * 0.10;   // 10% discount
    }
}


// ===== Subclass 2 =====
class NonVegItem extends FoodItem {

    public NonVegItem(int id, String name, double price) {
        super(id, name, price);
    }

    @Override
    public double calculateDiscount() {
        return getPrice() * 0.05;   // 5% discount
    }
}


// ===== Order Class =====
class Order {
    private List<FoodItem> items;

    public Order() {
        items = new ArrayList<>();
    }

    public void addItem(FoodItem item) {
        items.add(item);
    }

    public double calculateTotalBill() {
        double total = 0;

        for (FoodItem item : items) {
            double discount = item.calculateDiscount(); // Polymorphism
            total += (item.getPrice() - discount);
        }

        return total;
    }
}


// ===== Main Class =====
public class OnlineFoodOrderingSystem {

    public static void main(String[] args) {

        Order order = new Order();

        // Polymorphism → Both stored as FoodItem
        FoodItem item1 = new VegItem(1, "Paneer Tikka", 220);
        FoodItem item2 = new NonVegItem(2, "Chicken Biryani", 300);

        order.addItem(item1);
        order.addItem(item2);

        double totalBill = order.calculateTotalBill();

        System.out.println("Total Bill After Discount: " + totalBill);
    }
}
