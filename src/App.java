import Dish.Dish;
import Dish.DishDetail;
import Dish.DishDetailManager;
import Dish.DishManager;
import Dish.Drink;
import Dish.Food;
import Group.*;
import Order.Order;
import Order.OrderManager;
import Staff.Gender;
import Staff.Staff;
import Staff.StaffManager;
import Table.Table;
import Table.TableDetail;
import Table.TableDetailManager;
import Table.TableManager;
import utils.Console;
import utils.OptionMenu;
import utils.Supporter;

public class App {
    public static void main(String[] args) throws Exception {
        Supporter support = new Supporter();
        int selection;
	    
        /*
        ----------------------------------------------------------------------------------------------------
        ID      Name                         Price      Sell At   Category
        F001 Com suon                     25000.0    Breakfast       Food    Vegetarian
        F002 Com Thit Kho Hot Vit         35000.0        Lunch       Food         Meaty
        D001 Yogurt                       10000.0       Dinner      Drink        No ice
        D002 GongCha                      10000.0       Dinner      Drink       Has ice
        ----------------------------------------------------------------------------------------------------
        */
        Dish d1 = new Food("Com suon", 25000, true, "Breakfast", Dish.VEGETATIAN);
        Dish d2 = new Food("Com Thit Kho Hot Vit", 35000, true, "Lunch", Dish.NONVEGETATIAN);
        Dish d3 = new Drink("Yogurt", 10000, true, "Dinner", Dish.NONICE);
        Dish d4 = new Drink("GongCha", 10000, true, "Dinner", Dish.ICE);


        /*
        ----------------------------------------------
        ID        Capacity     Status        Price
        B001      Group Of 3      Empty     100000.0
        B002      Group Of 5      Empty     200000.0
        B003      Group Of 5     Booked     200000.0
        ----------------------------------------------
        */
        Table tb1 = new Table(3, 100000); // empty Table
        Table tb2 = new Table(5, 200000); // empty Table
        Table tb3 = new Table(5, true, 200000); // Table is booked


        /*
        ------------------------
        ID      Created At
        Or001      21/12/2021
        Or002      21/12/2021
        Or003      11/01/2021
        ------------------------
        */
        Order o1 = new Order();
        Order o2 = new Order();
        Order o3 = new Order(support.getDate("11/1/2021"));
        

        /*
        ----------------------------------------------------------------------------------------------------
        StaffID StaffName                            Address       Gender  BirthDate    StartDate        Group 
        S001 Luong Dc Huy                               TMT         MALE 14/01/2001   23/12/2021         Cook
        S002 Nguyen Ha Truong                           TMT         MALE 14/01/2001   23/12/2021         Runner
        S003 Dang Ng Dang Khoa                          TMT         MALE 14/01/2001   23/12/2021         Runner
        S004 Nguyen Dung Hoa                            TMT         MALE 14/01/2001   23/12/2021         Security
        ----------------------------------------------------------------------------------------------------
        */
        Group cook = new CookGroup();
        Group runner = new RunnerGroup();
        Group security = new SecurityGroup();
        Staff staff1 = new Staff("Luong Duc Huy", Gender.MALE, "TMT", "14/01/2001", "23/12/2021", cook);
        Staff staff2 = new Staff("Nguyen Ha Truong", Gender.MALE, "ACX", "14/02/2001", "23/12/2021", runner);
        Staff staff3 = new Staff("Dang Ng Dang Khoa", Gender.FEMALE, "HMH", "23/02/2001", "23/12/2021", runner);
        Staff staff4 = new Staff("Nguyen Dung Hoa", Gender.OTHER, "TMT", "14/01/2001", "23/12/2021", security);
        

        /*
        -----------------------------------------
        DishID     OrderID  Quantity    Price
        Dish001    Or001        3      25000.0
        Dish003    Or001        5      10000.0
        Dish003    Or003       10      10000.0
        Dish004    Or003       20      10000.0
        -----------------------------------------
        */
        DishDetail dd1 = new DishDetail(d1, o1, 3);
        DishDetail dd2 = new DishDetail(d3, o1, 5);
        DishDetail dd3 = new DishDetail(d3, o3, 10);
        DishDetail dd4 = new DishDetail(d4, o3, 20);

        
        /*
        --------------------------------
        TableID  OrderID    Price
        B001    Or001     100000.0
        B002    Or002     200000.0
        B002    Or003     200000.0
        -------------------------------
        */
        TableDetail tbd1 = new TableDetail(tb1, o1);
        TableDetail tbd2 = new TableDetail(tb2, o2);
        TableDetail tbd3 = new TableDetail(tb2, o3);



        StaffManager staffs = new StaffManager();
        DishManager dishes = new DishManager();
        OrderManager orders = new OrderManager();
        TableManager tables = new TableManager();
        DishDetailManager dishDetails = new DishDetailManager();
        TableDetailManager tableDetails = new TableDetailManager();


        staffs.add(staff1);
        staffs.add(staff2);
        staffs.add(staff3);
        staffs.add(staff4);

        dishes.add(d1);
        dishes.add(d2);
        dishes.add(d3);
        dishes.add(d4);

        tables.add(tb1);
        tables.add(tb2);
        tables.add(tb3);

        orders.add(o1);
        orders.add(o2);
        orders.add(o3);

        dishDetails.add(dd1);
        dishDetails.add(dd2);
        dishDetails.add(dd3);
        dishDetails.add(dd4);

        tableDetails.add(tbd1);
        tableDetails.add(tbd2);
        tableDetails.add(tbd3);

        Console console = new Console();
        OptionMenu optionMenu = new OptionMenu();
       
        do {
            
            selection = console.showMenu();

            switch (selection) {
                case 1:
                    optionMenu.manageStaff(staffs);
                    break;
                case 2:
                    break;
                case 3:
                    optionMenu.manageDish(dishes);
                    break;
                case 4:
                    optionMenu.manageTable(tables, orders, tableDetails);
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
                case 8:
                    optionMenu.ReserveTableAndDish(tables, dishes, orders, tableDetails, dishDetails);
                    break;
                case 9:
                    optionMenu.manageRevenue(orders, tableDetails, dishDetails);
                    break;
                case 10:
                    optionMenu.celerateStaffsBirthDateInMonth(staffs);
                    break;
                case 11:
                    optionMenu.checkoutTable(tables, orders, tableDetails, dishDetails);
                    break;
                default:
                    break;
            }
        } while (selection != 0);

        
    }
}
