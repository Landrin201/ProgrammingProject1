/**
 * Represents a product for sale.
 * 
 * @author Lewis and Chase
 * @version 4.0
 */
public class Product implements Comparable<Product>
{
	private String productCode;
	private int sales;
	
	/**
	 * Creates the product with the specified code.
	 * 
	 * @param productCode a unique code for this product
	 */
	public Product(String productCode)
	{
		this.productCode = productCode;
		this.sales = 0;
	}
	
	/**
	 * Returns the product code for this product.
	 * 
	 * @return the product code
	 */
	public String getProductCode()
	{
		return productCode;
	}
	
	/**
	 * Increments the sales of this product.
	 */
	public void incrementSales()
	{
		sales++;
	}

	/**
	 * Compares this product to the specified product based on the product
	 * code.
	 * 
	 * @param other the other product
	 * @return an integer code result
	 */
	public int compareTo(Product obj)
	{
		return productCode.compareTo(obj.getProductCode());
	}
	
	/**
	 * Returns a string representation of this product.
	 * 
	 * @return a string representation of the product
	 */
	public String toString()
	{
		return productCode + "\t(" + sales + ")";
	}
}
