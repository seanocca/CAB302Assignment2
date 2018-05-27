package Delivery;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import Exceptions.DeliveryException;
import Stock.Stock;

/**
 * Used to test the class Manifest
 * @author Sean O'Connell
 *
 */
public class ManifestTest {

	private Stock cargo = new Stock();
	private Manifest manifest;
	/**
	 * Setup Manifest for testing
	 * @throws Exception
	 * 
	 */
	@Before
	public void setUp() throws Exception {
		manifest = new Manifest(cargo);
	}

	/**
	 * Test the manifest creation
	 * 
	 */
	@Test
	public void testManifest() {
		Manifest newManifest = manifest;
		assertEquals(newManifest, manifest);
	}
	
	/**
	 * Tests the function that returns the manifest of Trucks as an Array
	 * 
	 */
	@Test
	public void testGetManifestArray(){
		Truck truck = new OrdinaryTruck(cargo);
		ArrayList<Truck> truckList = new ArrayList<Truck>();
		truckList.add(truck);
		manifest.GetManifestArray().equals(truckList);
	} 
	
	/**
	 * Tests the function that determines the manifest cost
	 * @throws DeliveryException
	 * 
	 */
	@Test
	public void GetManifestCost() throws DeliveryException {
		Truck truck = new OrdinaryTruck(cargo);
		double cost = truck.GetCost();
		try {
			assertEquals(manifest.GetManifestCost(), cost,  0.01);
		} catch (Exception e) {
		}
	}
}
