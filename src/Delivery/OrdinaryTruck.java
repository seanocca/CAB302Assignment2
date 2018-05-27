package Delivery;

import Exceptions.DeliveryException;
import Stock.Stock;

/** 
 * Creates the ordinary truck as an abstract from the class Truck
 * @author Sean O'Connell
 *
 */
public class OrdinaryTruck extends Truck{

	private int maxCapacity = 1000;
	
	/**
	 * Generate Ordinary truck
	 * @param cargo
	 * 
	 */
	public OrdinaryTruck(Stock cargo) {
		super(cargo);
	}

	/** 
	 * Get Cost of the truck
	 * 
	 */
	@Override
	public double GetCost() throws DeliveryException {
		if (GetCargo().GetSize() != 0) {
			double cost = 750 + 0.25 * GetCargo().GetSize();
			return cost;
		}
		return 0;		
	}
	
	/**
	 * Get Max capacity of the truck
	 */
	@Override
	public int GetMaxCapacity() {
		return maxCapacity;
	}
	
	/**
	 * Get the truck type as a string
	 */
	@Override
	public String GetTruckType() {
		return "Ordinary Truck";
	}
}