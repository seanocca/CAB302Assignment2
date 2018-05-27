package Delivery;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import Stock.Stock;

/**
 * Used to test the class Truck
 * @author Sean O'Connell
 *
 */
public class TruckTest {
	
	private Truck truck;
	private Stock cargo = new Stock();
	
	
	/**
	 * Sets up the Truck testing class
	 * @throws Exception
	 * 
	 */
	@Before
	public void setUp() throws Exception {
		truck = new OrdinaryTruck(cargo);
	}
	
	/**
	 * Creates a Truck and 
	 * checks it against the original Truck from the setUp function
	 * 
	 */
	@Test
	public void testTruck() {
		Truck newTruck = truck;
		assertEquals(newTruck, truck);
	}

	/**
	 * Tests the current capacity of the truck
	 * 
	 */
	@Test
	public void testGetCurrentCapacity() {
		assertEquals(truck.GetCurrentCapacity(), 0);
	}

	/**
	 * Tests the cargo as a Stock compared
	 * 
	 */
	@Test
	public void testGetCargo() {
		assertEquals(truck.GetCargo(), cargo);
	}
}
