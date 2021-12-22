package Table;
import java.util.Scanner;

import utils.Console;

public class Table {
	public static final Scanner sc = new Scanner(System.in);
	Console console = new Console();

	private static int count;

	private String tableID;

	private int capacity;

	private boolean isOccupy;

	private double price;

	{
		tableID = String.format("B%03d", ++count);
		isOccupy = false;
	}

	public void input() {
		System.out.print("Capacity: ");
		this.capacity = sc.nextInt();

		System.out.print("Price: ");
		this.price = sc.nextDouble();

		System.out.print("Create successfully\n");
	}

	public void prettyPrint() {
		console.printTopDecor();
		console.printColumnOfTables();
		System.out.println(this);
		console.printBotDecor();
	}

	/**
	 * Constructor
	 */
	public Table() {
	}

	/**
	 * Constructor
	 */
	public Table(int capacity, boolean isOccupy, double price) {
		this.capacity = capacity;
		this.isOccupy = isOccupy;
		this.price = price;
	}

	/**
	 * Constructor
	 */
	public Table(int capacity, double price) {
		this.capacity = capacity;
		this.price = price;
	}

	/**
	 * toString
	 */
	@Override
	public String toString() {
		return String.format("%8s %15s %10s %12s",
				this.tableID,
				"Group Of " + this.capacity,
				(this.isOccupy) ? "Booked" : "Empty",
				this.price);
	}

	/**
	 * GETTER SETTER
	 */
	public String getTableID() {
		return tableID;
	}

	public void setTableID(String tableID) {
		this.tableID = tableID;
	}

	public int getCapacity() {
		return capacity;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}

	public boolean isOccupy() {
		return isOccupy;
	}

	public void setOccupy(boolean isOccupy) {
		this.isOccupy = isOccupy;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}
}
