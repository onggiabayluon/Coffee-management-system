public class Drink extends Dish {
	private boolean hasIce;
	
	public Drink() {
		this.dishType = Category.drink;
	}
	
	public Drink(String name, double price, boolean isActive, String sellAt, boolean hasIce) {
		super(name, price, isActive, sellAt);
		
		this.dishType = Category.drink;
		this.hasIce = hasIce;
	}

	@Override
	public String toString() {
		return String.format("%s %13s",
			super.toString(),
			(this.hasIce) ? "Has ice": "No ice"
		);
	}
}
