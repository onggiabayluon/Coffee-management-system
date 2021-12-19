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
        System.out.println("0 - Quit");
        System.out.print("Your Choice: ");

        return supporter.inputInt();    
    }

    public int showStaffManager() { 

        /***************************************************/

        System.out.println("Choose from these choices");
        System.out.println("-------------------------\n");
        System.out.println("1 - Enter an original number");
        System.out.println("2 - Encrypt a number");
        System.out.println("3 - Decrypt a number");
        System.out.println("5 - Back");
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