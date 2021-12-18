import java.util.ArrayList;
import java.util.List;

public class TableManager {
	private List<Table> tables = new ArrayList<>();

    Console console = new Console();

	public void add(Table order) {
        this.tables.add(order);
    }

    public void remove(String id) {
        this.tables.removeIf(order -> order.getTableID().equals(id));
    }

	public Table find(String id) {
        Table order = tables.stream().filter(d -> d.getTableID().toLowerCase().equals(id.toLowerCase())).findFirst().orElse(null);
        
        if (order == null)
            System.out.println("!! Not found any Table in the kitchen");
        else
            order.prettyPrint();

        return order;
    }

	public void list() {
        console.printTopDecor();
        console.printTableOfTables();

        tables.forEach(order -> {
            System.out.println(order);
        });

        console.printBotDecor();
    }
}
