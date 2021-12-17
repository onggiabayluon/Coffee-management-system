import java.util.ArrayList;
import java.util.List;


public class DishManager {
    Console console = new Console();
    
	private List<Dish> dishes = new ArrayList<>();

    public void add(Dish dish) {
        this.dishes.add(dish);
    }

    public void remove(String id) {
        this.dishes.removeIf(dish -> dish.getDishID().equals(id));
    }

    public Dish find(String id) {
        Dish dish = dishes.stream().filter(d -> d.getDishID().toLowerCase().equals(id.toLowerCase())).findFirst().orElse(null);
        
        if (dish == null)
            System.out.println("!! Not found any Dish in the kitchen");
        else
            dish.prettyPrint();

        return dish;
    }

	public void list() {
        console.printTopDecor();
        console.printTableOfDishes();

        dishes.forEach(dish -> {
            System.out.println(dish);
        });

        console.printBotDecor();
    }
}
