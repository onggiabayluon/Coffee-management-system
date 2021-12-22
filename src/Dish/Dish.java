package Dish;
import java.util.Scanner;

import utils.Console;

public abstract class Dish {
	protected static final Scanner sc = new Scanner(System.in);
	public static final boolean VEGETATIAN = true;
	public static final boolean NONVEGETATIAN = false;
	public static final boolean ICE = true;
	public static final boolean NONICE = false;
	

	protected String dishID;

	private String name;

	private double price;

	private boolean isActive = true;

	private String sellAt;

	protected Category dishType;

	Console console = new Console();

	

	public Dish() {

	}

	public Dish(String name, double price, boolean isActive, String sellAt) {
		this.name = name;
		this.price = price;
		this.isActive = isActive;
		this.sellAt = sellAt;
	}

	public void input() {
		System.out.print("Name: ");
		this.name = sc.nextLine();

		System.out.print("Price: ");
		this.price = sc.nextDouble();

		sc.nextLine();

		System.out.print("Is Active (true/false): ");
		this.isActive = sc.nextBoolean();

		sc.nextLine();

		System.out.print("Time Of Sell (Breakfast/Lunch/Dinner): ");
		this.sellAt = sc.nextLine();
		System.out.print("Create successfully\n");
	}

	public void prettyPrint() {
		console.printTopDecor();
		console.printColumnOfDishes();
		System.out.println(this);
		console.printBotDecor();
	}

	@Override
	public String toString() {
		return String.format("%8s %-25s %10s %12s %10s",
				this.dishID,
				this.name,
				this.price,
				this.sellAt,
				this.dishType.getCategoryName()
		);
	}

	/**
	 * GETTER SETTER
	 */
	public String getDishID() {
		return dishID;
	}

	public void setDishID(String dishID) {
		this.dishID = dishID;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public boolean isActive() {
		return isActive;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}

	public String getSellAt() {
		return sellAt;
	}

	public void setSellAt(String sellAt) {
		this.sellAt = sellAt;
	}

	public Category getDishType() {
		return dishType;
	}

	public void setDishType(Category dishType) {
		this.dishType = dishType;
	}

}
