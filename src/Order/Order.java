package Order;

import java.text.SimpleDateFormat;
import java.util.Date;

import utils.Console;

public class Order {
	Console console = new Console();

	// public static final SimpleDateFormat F = new SimpleDateFormat("dd/mm/yyyy
	// HH:mm:ss");
	public static final SimpleDateFormat F = new SimpleDateFormat("dd/MM/yyyy");

	private static int count;

	private String orderID;

	private Date orderDate;

	{
		orderID = String.format("Or%03d", ++count);
		orderDate = new Date();
	}

	public void prettyPrint() {
		console.printTopDecor();
		console.printColumnOfDishes();
		System.out.println(this);
		console.printBotDecor();
	}

	/**
	 * Constructor
	 */
	public Order() {
	}

	public Order(Date orderDate) {
		this.orderDate = orderDate;
	}

	/**
	 * toString
	 */
	@Override
	public String toString() {
		// F.applyPattern("dd");
		// F.applyPattern("mm");
		return String.format("%8s %15s",
				this.orderID,
				F.format(this.orderDate));
	}

	/**
	 * GETTER SETTER
	 */
	public static int getCount() {
		return count;
	}

	public static void setCount(int count) {
		Order.count = count;
	}

	public String getOrderID() {
		return orderID;
	}

	public void setOrderID(String orderID) {
		this.orderID = orderID;
	}

	public Date getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}

}
