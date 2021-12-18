import java.util.ArrayList;
import java.util.List;

public class OrderManager {
	private List<Order> orders = new ArrayList<>();

    Console console = new Console();

	public void add(Order order) {
        this.orders.add(order);
    }

    public void remove(String id) {
        this.orders.removeIf(order -> order.getOrderID().equals(id));
    }

	public Order find(String id) {
        Order order = orders.stream().filter(d -> d.getOrderID().toLowerCase().equals(id.toLowerCase())).findFirst().orElse(null);
        
        if (order == null)
            System.out.println("!! Not found any Order in the kitchen");
        else
            order.prettyPrint();

        return order;
    }

	public void list() {
        console.printTopDecor();
        console.printTableOfOrders();

        orders.forEach(order -> {
            System.out.println(order);
        });

        console.printBotDecor();
    }

}
