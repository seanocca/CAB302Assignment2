package Stock;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import Exceptions.StockException;

/**
 * This class tests the class Item
 * @author Sean O'Connell
 *
 */
public class ItemTest {

	private String[] values = new String[] {"rice", "2", "3", "325", "400", "10"};
	
	private Item item;
	
	/**
	 * Setup an original Item
	 * @throws Exception
	 * 
	 */
	@Before
	public void setUp() throws Exception {
		item = new Item(values);
	}

	/**
	 * Tests the creation of the Item
	 * 
	 */
	@Test
	public void testItem() {
		Item newItem = item;
		assertEquals(newItem, item);
	}

	/**
	 * Tests the function GetName() 
	 * which returns the nameof the Item
	 * 
	 */
	@Test
	public void testGetName() {
		assertEquals(values[0], item.GetName());
	}

	/**
	 * Test the function GetCost() 
	 * which returns the cost of the Item
	 * 
	 */
	@Test
	public void testGetCost() {
		values[1].equals(item.GetCost());
	}

	/**
	 * Tests the function GetPrice() 
	 * which returns the price of the Item
	 * 
	 */
	@Test
	public void testGetPrice() {
		values[2].equals(item.GetPrice());
	}

	/**
	 * Tests the function GetReorderPoint()
	 * which returns the reorder point of the Item
	 * 
	 * @throws StockException 
	 */
	@Test
	public void testGetReorderPoint() throws StockException {
		values[3].equals(item.GetReorderPoint());
	}

	/**
	 * Tests the function GetReorderAmount()
	 * which returns the reorder amount of the Item
	 * 
	 */
	@Test
	public void testGetReorderAmount() {
		values[4].equals(item.GetReorderAmount());
	}

	/** 
	 * Tests the function GetTemperature()
	 * which returns the temperature of the Item
	 * 
	 */
	@Test
	public void testGetTemperature() {
		values[5].equals(item.GetTemperature());
	}

	/**
	 * Tests the function SetQuantity()
	 * which returns the quantity of the Item
	 * 
	 */
	@Test
	public void testSetQuantity() {
		item.SetQuantity(10);
	}

	/**
	 * Test the function SetBuyingQuantity()
	 * which returns the buying quantity of the Item
	 * 
	 */
	@Test
	public void testSetBuyingQuantity() {
		item.SetBuyingQuantity(5);
	}
}
