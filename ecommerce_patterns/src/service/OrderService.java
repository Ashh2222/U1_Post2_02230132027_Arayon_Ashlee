package service;

import model.Product;
import factory.ProductFactory;
import observer.OrderObserver;
import observer.OrderSubject;
import strategy.PricingStrategy;

import java.util.ArrayList;
import java.util.List;

public class OrderService implements OrderSubject {

    private List<OrderObserver> observers = new ArrayList<>();

    private String orderId;
    private Product product;
    private int quantity;
    private String status;

    @Override
    public void subscribe(OrderObserver observer) {
        observers.add(observer);
    }

    @Override
    public void unsubscribe(OrderObserver observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers(String orderId, String oldStatus, String newStatus) {
        for (OrderObserver observer : observers) {
            observer.update(orderId, oldStatus, newStatus);
        }
    }

    public void createOrder(String id, String type, String name, double price, int quantity) {
        this.orderId = id;
        this.product = ProductFactory.createProduct(type, name, price);
        this.quantity = quantity;
        this.status = "CREATED";
    }

    public double calculateTotal(PricingStrategy strategy) {
        double baseTotal = product.getBasePrice() * quantity;
        return strategy.calculateFinalPrice(baseTotal);
    }

    public void changeStatus(String newStatus) {
        String oldStatus = this.status;
        this.status = newStatus;
        notifyObservers(orderId, oldStatus, newStatus);
    }

    public void printSummary(double total) {
        System.out.println("\nResumen del pedido");
        System.out.println("ID: " + orderId);
        System.out.println("Producto: " + product.getName());
        System.out.println("Cantidad: " + quantity);
        System.out.println("Estado: " + status);
        System.out.println("Total: " + total);
    }
}