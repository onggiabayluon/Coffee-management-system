package Dish;

public class Food extends Dish {
	private boolean isVegetarian;
	
	private static int count;

	{
		this.dishID = String.format("F%03d", ++count);
	}

	
	public Food() {
		this.dishType = Category.FOOD;
	}

	public Food(String name, double price, boolean isActive, String sellAt, boolean isVegetarian) {
		super(name, price, isActive, sellAt);
		
		this.dishType = Category.FOOD;
		this.isVegetarian = isVegetarian;
	}

	@Override
	public void input() {
		super.input();
		System.out.print("Is Vegetarian (true/false): ");
		this.isVegetarian = sc.nextBoolean();
	}

	@Override
	public String toString() {
		return String.format("%s %13s",
			super.toString(),
			(this.isVegetarian) ? "Vegetarian" : "Meaty"
		);
	}
}
