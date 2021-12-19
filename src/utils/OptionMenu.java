package utils;
import java.util.Scanner;

import Dish.Dish;
import Dish.DishDetailManager;
import Dish.DishManager;
import Dish.Drink;
import Dish.Food;
import Order.Order;
import Order.OrderManager;
import Table.Table;
import Table.TableDetailManager;
import Table.TableManager;

public class OptionMenu {
    public static final Scanner sc = new Scanner(System.in);
    private String id, dishID, orderID, tableID;
    private double totalAmount;
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

    public void manageDishDetail(DishDetailManager dishDetails) {
       
        do {

            selection = console.showDishDetailManager();

            switch (selection) {
                // case 1:
                //     DishDetail dd = new DishDetail();
                //     dishDetails.add(dd);
                //     break;
                case 2:
                    dishID = console.showIDInputScreen("Dish");
                    orderID = console.showIDInputScreen("Order");
                    dishDetails.remove(dishID, orderID);
                    break;
                case 3:
                    dishID = console.showIDInputScreen("Dish");
                    orderID = console.showIDInputScreen("Order");
                    dishDetails.find(dishID, orderID);
                    break;
                case 4:
                    dishDetails.list();
                    break;
                case 5:
                    orderID = console.showIDInputScreen("Order");
                    totalAmount = dishDetails.totalAmount(orderID);
                    System.out.printf("\nTotal Amount of Order(%s): %.0f VND\n\n", orderID, totalAmount);
                    break;
                default:
                    break;
            }

        } while (selection != 0);
    }
    
    public void manageTableDetail(TableDetailManager tableDetails) {
       
        do {

            selection = console.showTableDetailManager();

            switch (selection) {
                // case 1:
                //     Order order = new Order();
                //     orders.add(order);
                //     break;
                case 2:
                    tableID = console.showIDInputScreen("Table");
                    orderID = console.showIDInputScreen("Order");
                    tableDetails.remove(tableID, orderID);
                    break;

                case 3:
                    tableID = console.showIDInputScreen("Table");
                    orderID = console.showIDInputScreen("Order");
                    tableDetails.find(tableID, orderID);
                    break;

                case 4:
                    tableDetails.list();
                    break;

                case 5:
                    orderID = console.showIDInputScreen("Order");
                    totalAmount = tableDetails.totalAmount(orderID);
                    System.out.printf("\nTotal Amount of Order(%s): %.0f VND\n\n", orderID, totalAmount);
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
