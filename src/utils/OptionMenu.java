package utils;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import Dish.Dish;
import Dish.DishDetail;
import Dish.DishDetailManager;
import Dish.DishManager;
import Dish.Drink;
import Dish.Food;
import Order.Order;
import Order.OrderManager;
import Staff.Staff;
import Staff.StaffManager;
import Table.Table;
import Table.TableDetail;
import Table.TableDetailManager;
import Table.TableManager;

public class OptionMenu {
    public static final Scanner sc = new Scanner(System.in);
    private String id, dishID, orderID, tableID, action, name, gender, birthDate, address;
    private double totalAmount;
    private int selection, dishChoice, quantity, capacity;

    Console console = new Console();
    Supporter support = new Supporter();

    public void manageStaff(StaffManager staffs) {

        do {

            selection = console.showStaffManager();

            switch (selection) {
                case 1:
                    Staff staff = new Staff();
                    staff.input();
                    staffs.add(staff);
                    break;
                case 2:
                    id = console.showIDInputScreen("Staff");
                    staffs.remove(id);
                    break;
                case 3:
                    id = console.showIDInputScreen("Dish");
                    staffs.findStaffByID(id);
                    break;
                case 4:
                    staffs.list();
                    break;
                case 5:
                    name = console.showInputName("Staff Name");
                    staffs.findStaffsByName(name);
                    break;
                case 6:
                    gender = console.showInputString("Staff gender(Male/Female/Other)");
                    staffs.findStaffsByGender(gender);
                    break;
                case 7:
                    address = console.showInputString("Type Address");
                    staffs.findStaffsByAddress(address);
                    break;
                case 8:
                    birthDate = console.showInputString("Type BirthDate");
                    staffs.findStaffsByBirthDate(birthDate);
                    break;
                case 9:
                    id = console.showInputString(">> Type ID");
                    staffs.update(id);
                    System.out.println("Update successfully");
                    break;
                default:
                    break;
            }

        } while (selection != 0);
    }

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

                    dish.input();
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
                case 5:
                    String name = console.showInputName("Type Dish name");
                    dishes.findByName(name);
                    break;
                case 6:
                    Double fromPrice = console.showInputDouble("From price");
                    Double toPrice = console.showInputDouble("To price");
                    dishes.findByRangeOfPrice(fromPrice, toPrice);
                    break;
                case 7:
                    int sortKey = console.showInputInt(">> Type Sort (1/-1) for Ascending or Descending");
                    dishes.sortByPrice(sortKey);
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

    public void manageTable(TableManager tables, OrderManager orders, TableDetailManager tableDetails) {
       
        do {

            selection = console.showTableManager();

            switch (selection) {
                case 1:
                    Table table = new Table();
                    table.input();
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
                case 5:
                    tables.listEmptyTable();
                    break;
                case 6:
                    capacity = console.showInputInt("Capacity");
                    tables.findByCapacity(capacity);
                    break;
                case 7:
                    // 1. Input
                    tableID = console.showIDInputScreen("Table");
                    // 2 reserve Table
                    table = tables.reserveTable(tableID);
                    if (table == null) return;
                    // 3.1 -> Create new Order
                    Order order = new Order();
                    orders.add(order);
                    // 3.2  -> Create new TableDetail
                    TableDetail tableDetail = new TableDetail(table, order);
                    tableDetails.add(tableDetail);
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
                    totalAmount = dishDetails.totalAmountByOrderIDs(Arrays.asList(orderID));
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
                    totalAmount = tableDetails.totalAmountByOrderIDs(Arrays.asList(orderID));
                    System.out.printf("\nTotal Amount of Order(%s): %.0f VND\n\n", orderID, totalAmount);
                    break;

                default:
                    break;
            }

        } while (selection != 0);
    }
    
    public void ReserveTableAndDish(TableManager tables, DishManager dishes ,OrderManager orders, TableDetailManager tableDetails, DishDetailManager dishdetails) {
        // Show list of table and dish
        tables.list();
        dishes.list();
        // Reserve Table
        tableID = console.showIDInputScreen("Table");
        Table table = tables.reserveTable(tableID);
        if (table == null) return;

        // Create new Order
        Order order = new Order();
        orders.add(order);

        // Create new TableDetail
        TableDetail tableDetail = new TableDetail(table, order);
        tableDetails.add(tableDetail);

        // Order Multiple Dishes
        do {
            // Input
            dishID = console.showIDInputScreen("Dish");
            quantity = console.showInputInt("Quantity");

            // Order Dish
            Dish dish = dishes.orderDish(dishID);
            if (dish == null) return;
            
            // 3.2  -> Create new DishDetail
            DishDetail dishDetail = new DishDetail(dish, order, quantity);
            dishdetails.add(dishDetail);
            action = console.showDoWhileAction("Continue Order Dish (y/n)");

        } while (action.equalsIgnoreCase("y") || action.equalsIgnoreCase("yes"));
        
    }

    public void manageRevenue(OrderManager orders, TableDetailManager tableDetails, DishDetailManager dishDetails) {
        do {

            selection = console.showRevenueManager();

            List<String> orderIDs;
            String month, fromDate, toDate; 

            switch (selection) {
                case 1:
                    double revenue = orders.getRevenue(dishDetails, tableDetails);
                    System.out.printf("\n>> Total Revenue: %.0f VND\n\n", revenue);
                    break;
                case 2:
                    orders.list();
                    // Revenue by month -> filter orders by Month
                    month = console.showInputString("Type Month");
                    orderIDs = orders.filterByMonth(month);
                    double revenueByMonth = orders.getRevenueByOrderIDs(dishDetails, tableDetails, orderIDs);
                    
                    System.out.printf("\n>> Month: %s", month);
                    System.out.printf("\n>> Total Revenue: %.0f VND\n\n", revenueByMonth);
                    break;
                case 3:
                    orders.list();
                    // Revenue by Range of Date -> filter orders by Range of Date
                    fromDate = console.showInputString("Type from Date (Ex: 1/01/2021)");
                    toDate = console.showInputString("Type to Date (Ex: 25/12/2021)");
                    orderIDs = orders.filterByDateRange(fromDate, toDate);
                    double revenueByDateRange = orders.getRevenueByOrderIDs(dishDetails, tableDetails, orderIDs);
                    
                    System.out.printf("\n>> From %s -> To %s", fromDate, toDate);
                    System.out.printf("\n>> Total Revenue: %.0f VND\n\n", revenueByDateRange);
                    break;
                default:
                    break;
            }

        } while (selection != 0);
    }

    public void celerateStaffsBirthDateInMonth(StaffManager staffs) {
        staffs.list();
        String month = console.showInputString(">> Type Month");
        staffs.CelebrateStaffsBirthDateInMonth(month);
    }
    
    public void checkoutTable(TableManager tables, OrderManager orders, TableDetailManager tableDetails, DishDetailManager dishDetails) {
        orders.list();
        dishDetails.list();
        tableDetails.list();
        String orderID = console.showInputString(">> Type OrderID");

        double dishAmount = dishDetails.totalAmountByOrderIDs(Arrays.asList(orderID));
        double tableAmount = tableDetails.totalAmountByOrderIDs(Arrays.asList(orderID));

        System.out.printf("\nTotal Amount of Order(%s): %.0f VND\n\n", orderID, dishAmount + tableAmount);
    }
}
