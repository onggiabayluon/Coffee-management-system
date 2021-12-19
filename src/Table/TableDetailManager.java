package Table;
import java.util.ArrayList;
import java.util.List;

import utils.Console;


public class TableDetailManager {
    private List<TableDetail> tableDetails = new ArrayList<>();

    Console console = new Console();
    
    public void add(TableDetail tableDetail) {
        this.tableDetails.add(tableDetail);
    }

    public void remove(String tableID, String orderID) {
        this.tableDetails.removeIf(dish -> (
            dish.getTableID().equals(tableID) &&
            dish.getOrderID().equals(orderID)
        ));
    }

    public TableDetail find(String tableID, String orderID) {
        TableDetail tableDetail = tableDetails
        .stream()
        .filter(d -> (
            d.getTableID().toLowerCase().equals(tableID.toLowerCase()) && 
            d.getOrderID().toLowerCase().equals(orderID.toLowerCase())
        ))
        .findFirst()
        .orElse(null);
        
        if (tableDetail == null)
            System.out.printf("!! Not found any Table Detail in the kitchen\n");
        else
            tableDetail.prettyPrint();

        return tableDetail;
    }
    
    public void list() {
        console.printTopDecor();
        console.printColumnOfTableDetails();

        tableDetails.forEach(tableDetail -> System.out.println(tableDetail));

        console.printBotDecor();
    }


    public double totalAmount(String orderID) {

        double totalAmount = this.tableDetails
        .stream()
        .filter(tableDetail -> tableDetail.getOrderID().toLowerCase().equals(orderID.toLowerCase()))
        .mapToDouble(tableDetail -> tableDetail.getPrice())
        .sum();

        return totalAmount;
    }
}
