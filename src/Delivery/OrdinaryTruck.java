package Delivery;

import Exceptions.DeliveryException;
import Stock.Stock;

public class OrdinaryTruck extends Truck{

	private int maxCapacity = 1000;
	
	/**
	 * 
	 * @param cargo
	 * @author Sean O'Connell
	 */
	public OrdinaryTruck(Stock cargo) {
		super(cargo);
	}

	/**
	 * @author Sean O'Connell
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
	 * @author Sean O'Connell
	 */
	@Override
	public int GetMaxCapacity() {
		return maxCapacity;
	}
	
	/**
	 * @author Sean O'Connell
	 */
	@Override
	public String GetTruckType() {
		return "Ordinary Truck";
	}
}