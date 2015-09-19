import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.util.TreeMap;

/**
 * Demonstrates the use of a TreeMap to store a sorted group of Product
 * objects.
 * 
 * @author Lewis and Chase
 * @version 4.0
 */
public class ProductSales
{
	/**
	 * Processes product sales data and prints a summary sorted by
	 * product code.
	 */
	public static void main(String[] args) throws IOException
	{
		TreeMap<String, Product> sales = new TreeMap<String, Product>();
		
		Scanner scan = new Scanner(new File("salesData.txt"));
		
		String code;
		Product product;
		while (scan.hasNext())
		{
			code = scan.nextLine();
			product = sales.get(code);
			if (product == null)
				sales.put(code, new Product(code));
			else
				product.incrementSales();
		}
		
		System.out.println("Products sold this period:");
		for (Product prod : sales.values())
			System.out.println(prod);
	}
}
