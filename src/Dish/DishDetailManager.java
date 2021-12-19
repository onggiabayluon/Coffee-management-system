package Dish;
import java.util.ArrayList;
import java.util.List;

import utils.Console;


public class DishDetailManager {
    private List<DishDetail> dishDetails = new ArrayList<>();

    Console console = new Console();
    
    public void add(DishDetail dishDetail) {
        this.dishDetails.add(dishDetail);
    }

    public void remove(String dishID, String orderID) {
        this.dishDetails.removeIf(dish -> (
            dish.getDishID().equals(dishID) &&
            dish.getOrderID().equals(orderID)
        ));
    }

    public DishDetail find(String dishID, String orderID) {
        DishDetail dishDetail = dishDetails
        .stream()
        .filter(d -> (
            d.getDishID().toLowerCase().equals(dishID.toLowerCase()) && 
            d.getOrderID().toLowerCase().equals(orderID.toLowerCase())
        ))
        .findFirst()
        .orElse(null);
        
        if (dishDetail == null)
            System.out.printf("!! Not found any Dish Detail in the kitchen\n");
        else
            dishDetail.prettyPrint();

        return dishDetail;
    }
    
    public void list() {
        console.printTopDecor();
        console.printColumnOfDishDetails();

        dishDetails.forEach(dishDetail -> System.out.println(dishDetail));

        console.printBotDecor();
    }


    public double totalAmount(String orderID) {

        double totalAmount = this.dishDetails
        .stream()
        .filter(dishDetail -> dishDetail.getOrderID().toLowerCase().equals(orderID.toLowerCase()))
        .mapToDouble(dishDetail -> dishDetail.getPrice() * dishDetail.getQuantity())
        .sum();

        return totalAmount;
    }
}
