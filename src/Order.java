import java.text.SimpleDateFormat;
import java.util.Date;

public class Order {

	private static int count;

	public static final SimpleDateFormat F = new SimpleDateFormat("dd/mm/yyyy");

	private String orderID;

	private Date orderDate;

	{
		orderID = String.format("Order%03d", ++count);
		orderDate = new Date();
	}

	@Override
	public String toString() {
		return String.format("Order Date: %s\n",
			F.format(this.orderDate)
        );
	}

}
