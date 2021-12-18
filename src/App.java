public class App {
    public static void main(String[] args) throws Exception {
        int action;
	    
        Dish d1 = new Food("Com suon", 25000, true, "Breakfast", Dish.VEGETATIAN);
        Dish d2 = new Food("Com Thit Kho Hot Vit", 35000, true, "Lunch", Dish.NONVEGETATIAN);
        Dish d3 = new Drink("Yogurt", 10000, true, "Dinner", Dish.NONICE);
        Dish d4 = new Drink("GongCha", 10000, true, "Dinner", Dish.ICE);

        Table t1 = new Table(3, 100000);
        Table t2 = new Table(5, 200000);

        Order o1 = new Order();
        Order o2 = new Order();

        DishManager dishes = new DishManager();
        OrderManager orders = new OrderManager();
        TableManager tables = new TableManager();
        
        dishes.add(d1);
        dishes.add(d2);
        dishes.add(d3);
        dishes.add(d4);

        tables.add(t1);
        tables.add(t2);

        orders.add(o1);
        orders.add(o2);

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
                    controller.manageDish(dishes);
                    break;
                case 4:
                    controller.manageTable(tables);
                    break;
                case 5:
                    controller.manageOrder(orders);
                    break;
                default:
                    break;
            }
        } while (action != 0);

        
    }
}
