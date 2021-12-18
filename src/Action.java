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

    public void manageOrder(OrderManager orders) {
       
        do {

            selection = console.showOrderManager();

            switch (selection) {
                case 1:
                    Order order = new Order();
                    orders.add(order);
                    break;
                case 2:
                    id = console.showIDInputScreen("Order");
                    orders.remove(id);
                    break;
                case 3:
                    id = console.showIDInputScreen("Order");
                    orders.find(id);
                    break;
                case 4:
                    orders.list();
                    break;
                default:
                    break;
            }

        } while (selection != 0);
    }

    public void manageTable(TableManager tables) {
       
        do {

            selection = console.showTableManager();

            switch (selection) {
                case 1:
                    Table table = new Table();
                    table.create();
                    tables.add(table);
                    break;
                case 2:
                    id = console.showIDInputScreen("Table");
                    tables.remove(id);
                    break;
                case 3:
                    id = console.showIDInputScreen("Table");
                    tables.find(id);
                    break;
                case 4:
                    tables.list();
                    break;
                default:
                    break;
            }

        } while (selection != 0);
    }

    // public void manageOrder(OrderManager orders) {
       
    //     do {

    //         selection = console.showDishManager();

    //         switch (selection) {
    //             case 1:
    //                 Order order = new Order();
    //                 orders.add(order);
    //                 break;
    //             case 2:
    //                 id = console.showIDInputScreen("Order");
    //                 orders.remove(id);
    //                 break;
    //             case 3:
    //                 id = console.showIDInputScreen("Order");
    //                 orders.find(id);
    //                 break;
    //             case 4:
    //                 orders.list();
    //                 break;
    //             default:
    //                 break;
    //         }

    //     } while (selection != 0);
    // }
}
