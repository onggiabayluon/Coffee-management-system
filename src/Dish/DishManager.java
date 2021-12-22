package Dish;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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
            System.out.printf("!! Not found any Dish in the kitchen\n");
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
        Dish Dish = dishes.stream()
                .filter(dish -> (dish.getDishID().equalsIgnoreCase(dishID) &&
                        dish.isActive() == true))
                .findFirst()
                .orElse(null);

        if (Dish == null) {
            System.out.println("!! This Dish is Out of service, Please choose another Dish");
            return null;
        } else
            System.out.println(">> Reserve Dish successfully <<");

        return Dish;
    }

    public Dish findByName(String name) {
        Dish dish = dishes.stream().filter(d -> d.getName().equalsIgnoreCase(name)).findFirst().orElse(null);

        if (dish == null)
            System.out.printf("!! Not found any Dish in the kitchen\n");
        else
            dish.prettyPrint();

        return dish;
    }

    public List<Dish> findByRangeOfPrice(Double fromPrice, Double toPrice) {
        List<Dish> listOfDish = dishes.stream()
                .filter(d -> {
                    Double dishPrice = d.getPrice();
                    return dishPrice >= fromPrice && dishPrice <= toPrice;
                })
                .collect(Collectors.toList());

        if (listOfDish.isEmpty())
            System.out.printf("!! Not found any Dish in the kitchen\n");
        else
            listOfDish.forEach(dish -> dish.prettyPrint());

        return listOfDish;
    }

    public void sortByPrice(int sortKey) {
        this.dishes.sort((d1, d2) -> sortKey * Double.compare(d1.getPrice(), d2.getPrice()));
        System.out.printf(">> Sort Result <<");
        this.list();
    }
}
