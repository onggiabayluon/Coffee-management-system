package Dish;
public class Category {
	public static final Category DRINK = new Category("Drink");
	public static final Category FOOD = new Category("Food");

	private String categoryID;

	private static int count;

	private String categoryName;

	{
		categoryID = String.format("Cate%03d", ++count);
	}

	public Category(String categoryName) {
		this.categoryName = categoryName;
	}


	/**
	 * GETTER SETTER
	 */
	public String getCategoryID() {
		return categoryID;
	}

	public void setCategoryID(String categoryID) {
		this.categoryID = categoryID;
	}


	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	
}
