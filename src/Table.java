public class Table {

	private String tableId;
	
	private static int count;

	private int capacity;

	private boolean isActive;

	private int Dish;

	private Dish dish;


	{
		tableId = String.format("B%03d", ++count);
	}
}
