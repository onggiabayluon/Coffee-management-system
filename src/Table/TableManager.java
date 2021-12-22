package Table;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import utils.Console;

public class TableManager {
    private List<Table> tables = new ArrayList<>();

    Console console = new Console();

    public void add(Table table) {
        this.tables.add(table);
    }

    public void remove(String id) {
        this.tables.removeIf(table -> table.getTableID().equalsIgnoreCase(id));
    }

    public Table find(String id) {
        Table table = tables.stream().filter(d -> d.getTableID().equalsIgnoreCase(id)).findFirst().orElse(null);

        if (table == null)
            System.out.println("!! Not found any Table in the kitchen");
        else
            table.prettyPrint();

        return table;
    }

    public void list() {
        console.printTopDecor();
        console.printColumnOfTables();

        tables.forEach(table -> {
            System.out.println(table);
        });

        console.printBotDecor();
    }

    public void listEmptyTable() {
        List<Table> listOfTable = tables.stream().filter(d -> !d.isOccupy()).collect(Collectors.toList());
        listOfTable.forEach(table -> table.prettyPrint());
    }

    public Table findByCapacity(int capacity) {
        Table table = tables.stream().filter(d -> d.getCapacity() == capacity).findFirst().orElse(null);

        if (table == null)
            System.out.println("!! Not found any Table in the kitchen");
        else
            table.prettyPrint();

        return table;
    }


    public Table findEmptyTableByID(String id) {
        Table table = tables.stream().filter(d -> (
            d.getTableID().equalsIgnoreCase(id) &&
            d.isOccupy() == false
        ))
        .findFirst()
        .orElse(null);

        if (table == null)
            System.out.println("!! Not found any Table in the kitchen");
        else
            table.prettyPrint();

        return table;
    }

    public Table reserveTable(String tableID) {
        Table table = tables.stream().filter(tb -> (
            tb.getTableID().equalsIgnoreCase(tableID) &&
            tb.isOccupy() == false
        ))
        .findFirst()
        .orElse(null);

        if (table == null) {
            System.out.println("!! Table is already booked, Please choose another table");
            return null;
        } else {
            table.setOccupy(true);
            System.out.println(">> Reserve Table successfully <<");
        }
            
        return table;
    }
}
