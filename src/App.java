import java.util.Scanner;

import com.google.gson.Gson;

public class App {
    public static void main(String[] args) throws Exception {
        int action;
	    
        Dish d1 = new Food("Com suon", 25000, true, "Breakfast", Dish.isVegetarian);
        Dish d2 = new Food("Com Thit Kho Hot Vit", 35000, true, "Lunch", Dish.isNotVegetarian);
        Dish d3 = new Drink("Yogurt", 10000, true, "Dinner", Dish.hasNoIce);
        Dish d4 = new Drink("GongCha", 10000, true, "Dinner", Dish.hasIce);

        DishManager dishes = new DishManager();
        
        dishes.add(d1);
        dishes.add(d2);
        dishes.add(d3);
        dishes.add(d4);


        Console console = new Console();
        Action controller = new Action();
       
        do {
            
            action = console.showMenu();

            switch (action) {
                case 1:
                    break;
                case 2:
                    break;
                case 3:
                    // userChoice = console.showDishManager();
                    controller.manageDish(dishes);
                    break;
                case 4:
                    break;
                default:
                    break;
            }
        } while (action != 0);

        
    }
}
