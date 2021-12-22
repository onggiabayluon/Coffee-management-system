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
            dish.getTableID().equalsIgnoreCase(tableID) &&
            dish.getOrderID().equalsIgnoreCase(orderID)
        ));
    }

    public TableDetail find(String tableID, String orderID) {
        TableDetail tableDetail = tableDetails
        .stream()
        .filter(td -> (
            td.getTableID().equalsIgnoreCase(tableID) && 
            td.getOrderID().equalsIgnoreCase(orderID)
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


    public double totalAmountByOrderIDs(List<String> orderIDs) {
        // Convert ID List to lowercase
        // orderIDs.stream().map(String::toLowerCase).collect(Collectors.toList());

        // Calculate total amount by comparing to ID List
        double totalAmount = this.tableDetails
        .stream()
        .filter(tbd -> orderIDs.contains(tbd.getOrderID()))
        .mapToDouble(tbd -> tbd.getPrice())
        .sum();

        return totalAmount;
    }

    public double totalAmount() {
        return this.tableDetails
        .stream()
        .mapToDouble(tbd -> tbd.getPrice())
        .sum();
    }
}
