import java.util.Scanner;

public class Action {
    public static final Scanner sc = new Scanner(System.in);
    private String id;
    private int selection, dishChoice;

    Console console = new Console();

    public void manageDish(DishManager dishes) {
       
        do {

            selection = console.showDishManager();

            switch (selection) {
                case 1:
                    Dish dish;
                    dishChoice = console.showDishOptions();
                    
                    if (dishChoice == 1) 
                        dish = new Food();
                    else if (dishChoice == 2)
                        dish = new Drink();
                    else 
                        break;

                    dish.create();
                    dishes.add(dish);
                    break;
                case 2:
                    id = console.showIDInputScreen("Dish");
                    dishes.remove(id);
                    break;
                case 3:
                    id = console.showIDInputScreen("Dish");
                    dishes.find(id);
                    break;
                case 4:
                    dishes.list();
                    break;
                default:
                    break;
            }

        } while (selection != 0);
    }
}
