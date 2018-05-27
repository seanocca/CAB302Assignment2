package Delivery;

import Exceptions.DeliveryException;
import Stock.Item;
import Stock.Stock;

/** 
 * Create the refrigerated truck class
 * @author Sean O'Connell
 *
 */
public class RefrigeratedTruck extends Truck{	
	
	private int maxCapacity = 800;
	
	/**
	 * Creates the Refrigerated Truck
	 * @param cargo
	 * 
	 */
	public RefrigeratedTruck(Stock cargo) {
		super(cargo);
	}
	
	/**
	 * Lowest safe temp of truck
	 * @returns the safe temp of the truck
	 * 
	 */
	 public double GetSafeTemp() {
		double currLow = 10, newTemp;
		if (GetCargo().GetStockArray() != null){	
			for(Item item : GetCargo().GetStockArray()) {
				newTemp = item.GetTemperature();
				if (newTemp < currLow) {
					currLow = newTemp;
				}
			}
		}
		return currLow;
	}
	
	 /**
	  * cost of truck
	  */
	@Override
	public double GetCost() throws DeliveryException {
		if (GetCargo().GetSize() != 0) {
			double cost = 900 + 200 * Math.pow(0.7, GetSafeTemp()/5);
			return cost;
		}
		throw new DeliveryException();
	}
	
	/**
	 * @returns Max capacity
	 */
	@Override
	public int GetMaxCapacity() {
		return maxCapacity;
	}
	
	/**
	 * @returns truck type as string
	 */
	@Override
	public String GetTruckType() {
		return "Refrigerated Truck";
	}
}