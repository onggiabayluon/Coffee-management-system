package main;

import Dish.Dish;
import Dish.DishDetail;
import Dish.DishDetailManager;
import Dish.DishManager;
import Dish.Drink;
import Dish.Food;
import Order.Order;
import Order.OrderManager;
import Table.Table;
import Table.TableDetail;
import Table.TableDetailManager;
import Table.TableManager;
import utils.Console;
import utils.OptionMenu;

public class App {
    public static void main(String[] args) throws Exception {
        int selection;
	    
        Dish d1 = new Food("Com suon", 25000, true, "Breakfast", Dish.VEGETATIAN);
        Dish d2 = new Food("Com Thit Kho Hot Vit", 35000, true, "Lunch", Dish.NONVEGETATIAN);
        Dish d3 = new Drink("Yogurt", 10000, true, "Dinner", Dish.NONICE);
        Dish d4 = new Drink("GongCha", 10000, true, "Dinner", Dish.ICE);

        Table tb1 = new Table(3, 100000);
        Table tb2 = new Table(5, 200000);

        Order o1 = new Order();
        Order o2 = new Order();

        DishDetail dd1 = new DishDetail(d1.getDishID(), o1.getOrderID(), 3, d1.getPrice());
        DishDetail dd2 = new DishDetail(d3.getDishID(), o1.getOrderID(), 5, d3.getPrice());

        TableDetail tbd1 = new TableDetail(tb1.getTableID(), o1.getOrderID(), tb1.getPrice());
        TableDetail tbd2 = new TableDetail(tb2.getTableID(), o1.getOrderID(), tb2.getPrice());

        DishManager dishes = new DishManager();
        OrderManager orders = new OrderManager();
        TableManager tables = new TableManager();
        DishDetailManager dishDetails = new DishDetailManager();
        TableDetailManager tableDetails = new TableDetailManager();

        
        dishes.add(d1);
        dishes.add(d2);
        dishes.add(d3);
        dishes.add(d4);

        tables.add(tb1);
        tables.add(tb2);

        orders.add(o1);
        orders.add(o2);

        dishDetails.add(dd1);
        dishDetails.add(dd2);

        tableDetails.add(tbd1);
        tableDetails.add(tbd2);

        Console console = new Console();
        OptionMenu optionMenu = new OptionMenu();
       
        do {
            
            selection = console.showMenu();

            switch (selection) {
                case 1:
                    break;
                case 2:
                    break;
                case 3:
                    optionMenu.manageDish(dishes);
                    break;
                case 4:
                    optionMenu.manageTable(tables);
                    break;
                case 5:
                    optionMenu.manageOrder(orders);
                    break;
                case 6:
                    optionMenu.manageDishDetail(dishDetails);
                    break;
                case 7:
                    optionMenu.manageTableDetail(tableDetails);
                    break;
                default:
                    break;
            }
        } while (selection != 0);

        
    }
}
