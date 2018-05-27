package Stock;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

/**
 * Tests the functions of the Stock class
 * @author Sean O'Connell
 *
 */
public class StockTest {

	public Stock inventory;
	
	/**
	 * Setup Manifest for testing
	 * @throws Exception
	 * 
	 */
	@Before
	public void setUp() throws Exception {
		inventory = new Stock(); 
	}

	/**
	 * Test the creation of Stock
	 * 
	 */
	@Test
	public void testStock() {
		Stock newInventory = inventory;
		assertEquals(newInventory, inventory);
	}

	/**
	 * Tests the returned array from the function GetStockArray()
	 * 
	 */
	@Test
	public void testGetStockArray() {
		ArrayList<Item> list = new ArrayList<Item>();
		assertEquals(inventory.GetStockArray(), list);
	}

	/**
	 * Tests the GetSize() function to find the size of the stock
	 * 
	 */
	@Test
	public void testGetSize() {
		assertEquals(inventory.GetSize(), 0);
	}
}
