package Delivery;

import Exceptions.DeliveryException;
import Stock.Item;
import Stock.Stock;

public class RefrigeratedTruck extends Truck{	
	
	private int maxCapacity = 800;
	
	/**
	 * 
	 * @param cargo
	 * @author Sean O'Connell
	 */
	public RefrigeratedTruck(Stock cargo) {
		super(cargo);
	}
	
	/**
	 * 
	 * @return
	 * @author Sean O'Connell
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
	  * @author Sean O'Connell
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
		return "Refrigerated Truck";
	}
}