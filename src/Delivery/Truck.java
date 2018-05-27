package Delivery;

import java.util.ArrayList;

import Exceptions.DeliveryException;
import Stock.Item;
import Stock.Stock;

public abstract class Truck {
	
	private Stock cargo;
	
	/**
	 * Creates the Truck wiht a stock of cargo
	 * @param cargo
	 * @author Sean O'Connell
	 */
	public Truck(Stock cargo) {
		this.cargo = cargo;
	}
	
	/**
	 * Returns the current capacity of the cargo
	 * @return
	 * @author Sean O'Connell
	 */
	public int GetCurrentCapacity() {
		return cargo.GetSize();
	}
	
	/**
	 * Returns the contents of the Truck as a Stock
	 * @return
	 * @author Sean O'Connell
 	 */
	public Stock GetCargo() {
		return this.cargo;
	}
	
	/**
	 * Returns the cargo as a list of Strings
	 * Used to create the Manifest file
	 * @return
	 * @author Sean O'Connell
	 */
	public ArrayList<String> GetCargoList() throws DeliveryException{
		ArrayList<String> output = new ArrayList<String>();
		if (cargo.GetSize() != 0) {	
			output.add(">" + GetTruckType());
			for(Item item: cargo.GetStockArray()) {
				if (!output.contains(item.GetName())) {
					output.add(item.GetName() + ", " + cargo.CountDuplicates(item));
				}
			}
		}
		return output;
	}
	
	/**
	 * Abstract Class to get the total cost of the Truck
	 * @return
	 * @throws DeliveryException 
	 * @author Sean O'Connell
	 */
	public abstract double GetCost() throws DeliveryException;
	
	/**
	 * Abstract class to get the max capacity of the Truck
	 * @return
	 * @author Sean O'Connell
	 */
	public abstract int GetMaxCapacity();
	
	/**
	 * Abstract class to get the Truck type as a String
	 * Used to help the creation of the Manifest file
	 * @return
	 * @author Sean O'Connell
	 */
	public abstract String GetTruckType();
} 