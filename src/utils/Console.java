package utils;

import java.util.Scanner;

public class Console {
    public static final Scanner sc = new Scanner(System.in);
    public static int selection;
    Supporter supporter = new Supporter();

    
    public int showMenu() { 
        /***************************************************/
        System.out.print("+---------------+\n");
        System.out.print("|   MAIN MENU   |\n");
        System.out.print("+---------------+\n");
        
        System.out.println("1 - Show Staff Manager");
        System.out.println("2 - Show Group Manager");
        System.out.println("3 - Show Dish Manager");
        System.out.println("4 - Show Table Manager");
        System.out.println("5 - Show Order Manager");
        System.out.println("6 - Show Dish Detail Manager");
        System.out.println("7 - Show Table Detail Manager");
        System.out.print("+-------------+\n");
        System.out.print("|   Hot Key   |\n");
        System.out.print("+-------------+\n");
        System.out.println("8 - Reserve Table And Dishes");
        System.out.println("9 - Revenue");
        System.out.println("10 - Celebrate Staffs Birthdate together in month");
        System.out.println("11 - Checkout table");
        System.out.println("0 - Quit");
        System.out.print("Your Choice: ");

        return supporter.inputInt();    
    }

    public int showStaffManager() { 
        System.out.print("+----------------+\n");
        System.out.print("|  Staff Manager |\n");
        System.out.print("+----------------+\n");

        System.out.println("1 - Add");
        System.out.println("2 - Remove");
        System.out.println("3 - Find");
        System.out.println("4 - List");
        System.out.println("5 - Find by Name");
        System.out.println("6 - Find by gender");
        System.out.println("7 - Find by address");
        System.out.println("8 - Find by birthday");
        System.out.println("9 - Update");
        System.out.println("0 - Back");
        System.out.print("Your Choice: ");

        return supporter.inputInt();
    }

    public int showGroupManager() {
        System.out.println("showGroupManager");
        
        return supporter.inputInt();
    }

    public int showDishManager() {
        System.out.print("+---------------+\n");
        System.out.print("|  Dish Manager |\n");
        System.out.print("+---------------+\n");

        System.out.println("1 - Add");
        System.out.println("2 - Remove");
        System.out.println("3 - Find");
        System.out.println("4 - List");
        System.out.println("5 - Find By Name");
        System.out.println("6 - Find By Range Of Price");
        System.out.println("7 - Sort By Price");
        System.out.println("0 - Back");
        System.out.print("Your Choice: ");

        return supporter.inputInt();
    }

    public int showTableManager() {
        System.out.print("+---------------+\n");
        System.out.print("| Table Manager |\n");
        System.out.print("+---------------+\n");

        System.out.println("1 - Add");
        System.out.println("2 - Remove");
        System.out.println("3 - Find");
        System.out.println("4 - List");
        System.out.println("5 - List Empty Table");
        System.out.println("6 - Find Table by capacity");
        System.out.println("7 - Reserve Table");
        System.out.println("0 - Back");
        System.out.print("Your Choice: ");

        return supporter.inputInt();
    }

    public int showOrderManager() {
        System.out.print("+---------------+\n");
        System.out.print("| Order Manager |\n");
        System.out.print("+---------------+\n");

        System.out.println("1 - Add");
        System.out.println("2 - Remove");
        System.out.println("3 - Find");
        System.out.println("4 - List");
        System.out.println("0 - Back");
        System.out.print("Your Choice: ");

        return supporter.inputInt();
    
    }
    public int showDishDetailManager() {
        System.out.print("+---------------------+\n");
        System.out.print("| Dish Detail Manager |\n");
        System.out.print("+---------------------+\n");

        // System.out.println("1 - Add");
        System.out.println("2 - Remove");
        System.out.println("3 - Find");
        System.out.println("4 - List");
        System.out.println("5 - Get Total Amount of 1 Order");
        System.out.println("0 - Back");
        System.out.print("Your Choice: ");

        return supporter.inputInt();
    }
    
    public int showTableDetailManager() {
        System.out.print("+----------------------+\n");
        System.out.print("| Table Detail Manager |\n");
        System.out.print("+----------------------+\n");

        // System.out.println("1 - Add");
        System.out.println("2 - Remove");
        System.out.println("3 - Find");
        System.out.println("4 - List");
        System.out.println("5 - Get Total Amount of 1 Order");
        System.out.println("0 - Back");
        System.out.print("Your Choice: ");

        return supporter.inputInt();
    }

    public int showRevenueManager() {
        System.out.print("+-----------------+\n");
        System.out.print("| Revenue Manager |\n");
        System.out.print("+-----------------+\n");

        System.out.println("1 - Total Revenue");
        System.out.println("2 - Revenue by month");
        System.out.println("3 - Revenue by range of date");
        System.out.println("0 - Back");
        System.out.print("Your Choice: ");

        return supporter.inputInt();
    }

    /**
     * SUB MENU
     */

    public int showDishOptions() {
        System.out.print("+----------------+\n");
        System.out.print("|   Choose Type  |\n");
        System.out.print("+----------------+\n");

        System.out.println("1 - Food");
        System.out.println("2 - Drink");
        System.out.println("0 - Back");
        System.out.print("Your Choice: ");

        return supporter.inputInt();
    }

    public String showIDInputScreen(String name) {
        System.out.printf("%s ID: ", name);

        return supporter.inputString();
    }
    
    public String showInputString(String name) {
        System.out.printf("%s: ", name);

        return supporter.inputString();
    }
    
    public Double showInputDouble(String name) {
        System.out.printf("%s: ", name);

        return supporter.inputDouble();
    }

    public int showInputInt(String name) {
        System.out.printf("%s: ", name);

        return supporter.inputInt();
    }

    public String showDoWhileAction(String name) {
        System.out.printf("%s: ", name);

        return supporter.inputString();
    }

    public String showInputName(String name) {
        System.out.printf("%s: ", name);

        return supporter.inputName();
    }
    
    /**
     * SHOW TABLE DECORATION
     */

    public void printColumnOfDishes() {
        System.out.printf("%8s %-25s %10s %12s %10s\n",
			"ID",
			"Name",
			"Price",
			"Sell At",
			"Category"
		);
    }

    public void printColumnOfOrders() {
        System.out.printf("%8s %15s\n",
			"ID",
			"Created At"
		);
    }

    public void printColumnOfTables() {
        System.out.printf("%8s %15s %10s %12s\n",
			"ID",
			"Capacity",
			"Status",
			"Price"
		);
    }
    
    public void printColumnOfDishDetails() {
        System.out.printf("%8s %8s %8s %12s\n",
			"DishID",
			"OrderID",
			"Quantity",
			"Price"
		);
    }
    
    public void printColumnOfTableDetails() {
        System.out.printf("%8s %8s %12s \n",
            "TableID",
			"OrderID",
			"Price"
		);
    }

    public void printColumnOfStaffs() {
        System.out.printf("%8s %-25s %20s %12s %10s %12s %12s \n",
            "StaffID",
			"StaffName",
			"Address",
			"Gender",
			"BirthDate",
			"StartDate",
			"Group"
		);
    }


    /**
     * SHOW LINE DECORATION
     */
    
    public void printTopDecor() {
        System.out.print("\n--------------------------------------------------");
        System.out.print("--------------------------------------------------\n");
    }
    public void printBotDecor() {
        System.out.print("--------------------------------------------------");
        System.out.print("--------------------------------------------------\n\n");
    }
}
