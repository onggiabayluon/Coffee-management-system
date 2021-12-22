package Order;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import Dish.DishDetailManager;
import Table.TableDetailManager;
import utils.Console;
import utils.Supporter;

public class OrderManager {
	private List<Order> orders = new ArrayList<>();

    Console console = new Console();
    Supporter support = new Supporter();

	public void add(Order order) {
        this.orders.add(order);
    }

    public void remove(String id) {
        this.orders.removeIf(order -> order.getOrderID().equals(id));
    }

	public Order find(String id) {
        Order order = orders.stream().filter(o -> o.getOrderID().equalsIgnoreCase(id)).findFirst().orElse(null);
        
        if (order == null)
            System.out.println("!! Not found any Order in the kitchen");
        else
            order.prettyPrint();

        return order;
    }

	public void list() {
        console.printTopDecor();
        console.printColumnOfOrders();

        orders.forEach(order -> {
            System.out.println(order);
        });

        console.printBotDecor();
    }

    public double getRevenueByOrderIDs(DishDetailManager dishDetails, TableDetailManager tableDetails, List<String> orderIDs) {
        // Total revenue = DishDetail_total + TableDetail_total
        double totalDishAmount = dishDetails.totalAmountByOrderIDs(orderIDs);
        double totalTableAmount = tableDetails.totalAmountByOrderIDs(orderIDs);

        return totalDishAmount + totalTableAmount;
    }

    public double getRevenue(DishDetailManager dishDetails, TableDetailManager tableDetails) {
        // Total revenue = DishDetail_total + TableDetail_total
        double totalDishAmount = dishDetails.totalAmount();
        double totalTableAmount = tableDetails.totalAmount();

        return totalDishAmount + totalTableAmount;
    }


    /**
     * Filter orderList by month 
     * @param month
     * @return List of ordersID
     */
    public List<String> filterByMonth(String month) {
        return this.orders.stream()
        .filter(o -> support.getMonth(o.getOrderDate()) == support.getMonth(support.toMonthDate(month)))
        .map(o -> o.getOrderID())
        .collect(Collectors.toList());
    }

    /**
     * Filter orderList by range of Date 
     * @param fromDate
     * @param toDate
     * @return List of orderIDs
     */
    public List<String> filterByDateRange(String fromDate, String toDate) {
        Date historyDate = support.getDate(fromDate);
        Date futureDate = support.getDate(toDate);
         
        // In between
        return this.orders.stream()
        .filter(o -> {
            Date todayDate = o.getOrderDate();
            return todayDate.after(historyDate) && todayDate.before(futureDate);
        })
        .map(o -> o.getOrderID())
        .collect(Collectors.toList());
    }

}
