package Stock;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class ItemTest {

	private String[] values = new String[] {"rice", "2", "3", "325", "400", "10"};
	
	private Item item;
	
	/**
	 * Setup an original Item
	 * @throws Exception
	 * @author Sean O'Connell
	 */
	@Before
	public void setUp() throws Exception {
		item = new Item(values);
	}

	/**
	 * Tests the creation of the Item
	 * @author Sean O'Connell
	 */
	@Test
	public void testItem() {
		Item newItem = item;
		assertEquals(newItem, item);
	}

	/**
	 * Tests the function GetName() 
	 * which returns the nameof the Item
	 * @author Sean O'Connell
	 */
	@Test
	public void testGetName() {
		assertEquals(values[0], item.GetName());
	}

	/**
	 * Test the function GetCost() 
	 * which returns the cost of the Item
	 * @author Sean O'Connell
	 */
	@Test
	public void testGetCost() {
		values[1].equals(item.GetCost());
	}

	/**
	 * Tests the function GetPrice() 
	 * which returns the price of the Item
	 * @author Sean O'Connell
	 */
	@Test
	public void testGetPrice() {
		values[2].equals(item.GetPrice());
	}

	/**
	 * Tests the function GetReorderPoint()
	 * which returns the reorder point of the Item
	 * @author Sean O'Connell
	 */
	@Test
	public void testGetReorderPoint() {
		values[3].equals(item.GetReorderPoint());
	}

	/**
	 * Tests the function GetReorderAmount()
	 * which returns the reorder amount of the Item
	 * @author Sean O'Connell
	 */
	@Test
	public void testGetReorderAmount() {
		values[4].equals(item.GetReorderAmount());
	}

	/** 
	 * Tests the function GetTemperature()
	 * which returns the temperature of the Item
	 * @author Sean O'Connell
	 */
	@Test
	public void testGetTemperature() {
		values[5].equals(item.GetTemperature());
	}

	/**
	 * Tests the function SetQuantity()
	 * which returns the quantity of the Item
	 * @author Sean O'Connell
	 */
	@Test
	public void testSetQuantity() {
		item.SetQuantity(10);
	}

	/**
	 * Test the function SetBuyingQuantity()
	 * which returns the buying quantity of the Item
	 * @author Sean O'Connell
	 */
	@Test
	public void testSetBuyingQuantity() {
		item.SetBuyingQuantity(5);
	}
}
