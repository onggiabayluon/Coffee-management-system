package Table;

import Order.Order;
import utils.Console;

public class TableDetail {

	private String orderID;

	private String tableID;

	private double price;

	Console console = new Console();

	public TableDetail(String tableID, String orderID, double price) {
		this.orderID = orderID;
		this.tableID = tableID;
		this.price = price;
	}

	public TableDetail(Table table, Order order) {
		this.orderID = order.getOrderID();
		this.tableID = table.getTableID();
		this.price = table.getPrice();
	}

	public void prettyPrint() {
		console.printTopDecor();
		console.printColumnOfTableDetails();
		System.out.println(this);
		console.printBotDecor();
	}

	@Override
	public String toString() {
		return String.format("%8s %8s %12s",
				this.tableID,
				this.orderID,
				this.price);
	}

	/**
	 * GETTER SETTER
	 */

	public String getOrderID() {
		return orderID;
	}

	public void setOrderID(String orderID) {
		this.orderID = orderID;
	}

	public String getTableID() {
		return tableID;
	}

	public void setTableID(String tableID) {
		this.tableID = tableID;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

}
