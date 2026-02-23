package model;

public abstract class Product {

    protected String name;
    protected double basePrice;
    protected String category;

    public abstract double calculateShipping();
    public abstract String getDescription();
    

    public Product(String name, double basePrice, String category) {
        this.name = name;
        this.basePrice = basePrice;
        this.category = category;
    }

    public String getName() {
        return name;
    }

    public double getBasePrice() {
        return basePrice;
    }

    public String getCategory() {
        return category;
    }
}

