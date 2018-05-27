package Delivery;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import Exceptions.DeliveryException;
import Stock.Item;
import Stock.Stock;

public class OrdinaryTruckTest {

	//List for New Items
	private String[] rice = new String[] {"rice", "2", "3", "225", "300"};
	private String[] pasta = new String[] {"pasta", "3", "4", "125", "250"};
	private String[] biscuits = new String[] {"biscuits", "2", "5", "450", "575"};
	private String[] chocolate = new String[] {"chocolate", "5", "8", "250", "375"};
	
	//New items
	private Item itemOne = new Item(rice);
	private Item itemTwo = new Item(pasta);
	private Item itemThree = new Item(biscuits);
	private Item itemFour = new Item(chocolate);
	
	private ArrayList<Item> arrayCargo = new ArrayList<Item>();
	
	private Stock testCargo;
	
	private Truck testTruck;
	
	/**
	 * 
	 * @throws Exception
	 * @author Sean O'Connell
	 */
	@Before
	public void setUp() throws Exception {
		arrayCargo.add(itemOne);
		arrayCargo.add(itemTwo);
		arrayCargo.add(itemThree);
		arrayCargo.add(itemFour);
		testCargo = new Stock();
		testCargo.addAll(arrayCargo);
		testTruck = new OrdinaryTruck(testCargo);
	}

	/**
	 * 
	 * @throws DeliveryException
	 * @author Sean O'Connell
	 */
	@Test
	public void testGetCost() throws DeliveryException {
		double cost = 750 + 0.25 * testTruck.GetCargo().GetSize();
		assertEquals(testTruck.GetCost(), cost, 0.01);
	}

	/**
	 * @author Sean O'Connell
	 */
	@Test
	public void testGetMaxCapacity() {
		assertEquals(testTruck.GetMaxCapacity(), 1000);
	}
	
	/**
	 * @author Sean O'Connell
	 */
	@Test
	public void GetTruckType() {
		assertEquals(testTruck.GetTruckType(), "Ordinary Truck");
	}
}
