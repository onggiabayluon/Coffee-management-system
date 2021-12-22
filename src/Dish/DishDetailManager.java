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
            dish.getDishID().equalsIgnoreCase(dishID) &&
            dish.getOrderID().equalsIgnoreCase(orderID)
        ));
    }

    public DishDetail find(String dishID, String orderID) {
        DishDetail dishDetail = dishDetails
        .stream()
        .filter(d -> (
            d.getDishID().equalsIgnoreCase(dishID) && 
            d.getOrderID().equalsIgnoreCase(orderID)
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


    public double totalAmountByOrderIDs(List<String> orderIDs) {
        // Convert ID List to lowercase
        // orderIDs.stream().map(String::toLowerCase).collect(Collectors.toList());

        // Calculate total amount by comparing to ID List
        double totalAmount = this.dishDetails
        .stream()
        .filter(dd -> orderIDs.contains(dd.getOrderID()))
        .mapToDouble(dd -> dd.getPrice() * dd.getQuantity())
        .sum();

        return totalAmount;
    }

    public double totalAmount() {
        return this.dishDetails
        .stream()
        .mapToDouble(dd -> dd.getPrice() * dd.getQuantity())
        .sum();
    }
}
