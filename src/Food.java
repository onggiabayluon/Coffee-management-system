public class Food extends Dish {
	private boolean isVegetarian;
	
	public Food() {
		this.dishType = Category.FOOD;
	}

	public Food(String name, double price, boolean isActive, String sellAt, boolean isVegetarian) {
		super(name, price, isActive, sellAt);
		
		this.dishType = Category.FOOD;
		this.isVegetarian = isVegetarian;
	}


	@Override
	public String toString() {
		return String.format("%s %13s",
			super.toString(),
			(this.isVegetarian) ? "Vegetarian" : "Meaty"
		);
	}

	
	
}
