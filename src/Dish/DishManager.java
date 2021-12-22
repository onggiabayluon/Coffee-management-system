package Dish;

import java.util.ArrayList;
import java.util.List;

import utils.Console;


public class DishManager {
    private List<Dish> dishes = new ArrayList<>();
    
    Console console = new Console();

    public void add(Dish dish) {
        this.dishes.add(dish);
    }

    public void remove(String id) {
        this.dishes.removeIf(dish -> dish.getDishID().equals(id));
    }

    public Dish find(String id) {
        Dish dish = dishes.stream().filter(d -> d.getDishID().equalsIgnoreCase(id)).findFirst().orElse(null);
        
        if (dish == null)
            System.out.printf("!! Not found any Dish in the kitchen");
        else
            dish.prettyPrint();

        return dish;
    }

	public void list() {
        console.printTopDecor();
        console.printColumnOfDishes();

        dishes.forEach(dish -> System.out.println(dish));

        console.printBotDecor();
    }

    public Dish orderDish(String dishID) {
        Dish Dish = dishes.stream().filter(dish -> (
            dish.getDishID().equalsIgnoreCase(dishID) &&
            dish.isActive() == true
        ))
        .findFirst()
        .orElse(null);

        if (Dish == null) {
            System.out.println("!! This Dish is Out of service, Please choose another Dish");
            return null;
        } else 
            System.out.println(">> Reserve Dish successfully <<");
            
        return Dish;
    }
}
