package Dish;

import Order.Order;
import utils.Console;

public class DishDetail {
    private String dishID;

    private String orderID;

    private int quantity;

    private double price;

    Console console = new Console();

    public DishDetail(String dishID, String orderID, int quantity, double price) {
        this.dishID = dishID;
        this.orderID = orderID;
        this.quantity = quantity;
        this.price
         = price;
    }
    
    public DishDetail(Dish dish, Order order ,int quantity) {
        this.dishID = dish.getDishID();
        this.orderID = order.getOrderID();
        this.quantity = quantity;
        this.price = dish.getPrice();
    }

    public void prettyPrint() {
        console.printTopDecor();
        console.printColumnOfDishes();
        System.out.println(this);
        console.printBotDecor();
    }

    @Override
    public String toString() {
        return String.format("%8s %8s %8s %12s",
                this.dishID,
                this.orderID,
                this.quantity,
                this.price);
    }

    public String getDishID() {
        return dishID;
    }

    public void setDishID(String dishID) {
        this.dishID = dishID;
    }

    public String getOrderID() {
        return orderID;
    }

    public void setOrderID(String orderID) {
        this.orderID = orderID;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

}
