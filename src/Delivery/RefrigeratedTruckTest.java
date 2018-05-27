package Delivery;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import Exceptions.DeliveryException;
import Stock.Item;
import Stock.Stock;

public class RefrigeratedTruckTest {

	//List for New refrigerated Items
	private String[] lettuce = new String[] {"lettuce", "1", "2", "250", "350", "10"};
	
	//Refrigerated items	
	private Item itemOne = new Item(lettuce);
	
	private Stock testCargo;
	
	private Truck testTruck;
	
	/**
	 * 
	 * @throws Exception
	 * @author Sean O'Connell
	 */
	@Before
	public void setUp() throws Exception {
		testCargo = new Stock();
		testCargo.add(itemOne);
		testTruck = new RefrigeratedTruck(testCargo);
	}

	/**
	 * 
	 * @throws DeliveryException
	 * @author Sean O'Connell
	 */
	@Test
	public void testGetCost() throws DeliveryException {
		double cost = 900 + 200 * Math.pow(0.7, ((RefrigeratedTruck) testTruck).GetSafeTemp()/5);
		assertEquals(testTruck.GetCost(), cost, 0.01);
	}
	
	/**
	 * @author Sean O'Connell
	 */
	@Test
	public void testGetMaxCapacity() {
		assertEquals(testTruck.GetMaxCapacity(), 800);
	}
	
	/**
	 * @author Sean O'Connell
	 */
	@Test
	public void GetTruckType() {
		assertEquals(testTruck.GetTruckType(), "Refrigerated Truck");
	}
}
