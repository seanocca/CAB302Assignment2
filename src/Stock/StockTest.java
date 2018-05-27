package Stock;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

public class StockTest {

	public Stock inventory;
	
	/**
	 * Setup Manifest for testing
	 * @throws Exception
	 * @author Sean O'Connell
	 */
	@Before
	public void setUp() throws Exception {
		inventory = new Stock(); 
	}

	/**
	 * Test the creation of Stock
	 * @author Sean O'Connell
	 */
	@Test
	public void testStock() {
		Stock newInventory = inventory;
		assertEquals(newInventory, inventory);
	}

	/**
	 * Tests the returned array from teh function GetStockArray()
	 * @author Sean O'Connell
	 */
	@Test
	public void testGetStockArray() {
		ArrayList<Item> list = new ArrayList<Item>();
		assertEquals(inventory.GetStockArray(), list);
	}

	/**
	 * Tests the GetSize() function to find the size of the stock
	 * @author Sean O'Connell
	 */
	@Test
	public void testGetSize() {
		assertEquals(inventory.GetSize(), 0);
	}
}
