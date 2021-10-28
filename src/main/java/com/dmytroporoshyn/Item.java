package com.dmytroporoshyn;

public class Item {
    public enum Type { SECOND, REGULAR, SALE, DISCOUNT }
    private String title;
    private double price;
    private int quantity;
    private Type type;

    public Item(String title, double price, Item.Type type, int quantity){
        this.title = title;
        this.price = price;
        this.type = type;
        this.quantity = quantity;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }
}