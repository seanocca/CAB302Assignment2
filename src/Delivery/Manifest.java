package Delivery;

import java.util.ArrayList;

import Exceptions.DeliveryException;
import Stock.Item;
import Stock.Stock;

public class Manifest {
	
	//Initialize manifest variables
	private ArrayList<Truck> trucks = new ArrayList<Truck>();
	
	/**
	 * Creates the Manifest and it takes a Stock 
	 * Creates an array of Trucks both Refrigerated and Ordinary
	 * @param cargo
	 * @throws StockException
	 * @author Sean O'Connell
	 */
	public Manifest(Stock cargo) throws DeliveryException {
		//Create stock arrays for each fridge and ordinary items
		Stock fridge = new Stock();
		Stock ordinary = new Stock();
		
		boolean truckFull = false;
		
		//Sort the items by temperature
		cargo.sortByTemp(); 
		//Create an Item for every Item that needs to be ordered
			//Eg 100 beans need to be ordered so 100 individuals items of beans are created
		for (Item item: cargo.GetStockArray()) {
			if (item.GetQuantity() <= item.GetReorderPoint()) {
				for (int i = 0; i < item.GetReorderAmount(); i++) {
					if(item.GetTemperature() <= 15) {
						fridge.add(item);	
						fridge.sortByTemp(); 
					} else {
						ordinary.add(item);	
					}
				}
			}
		}
		
		
		//Create a temp stock to use as checker for truck cargo
		Stock temp = new Stock();
		//Creates Refrigerated Truck and populates it only if it has a size of 800 (max capacity)
		for (Item item : fridge.GetStockArray()) {
			temp.add(item);
			if (temp.GetSize() == 800) {
				Truck coldTruck = new RefrigeratedTruck(temp);
				trucks.add(coldTruck);
				temp = new Stock();
			}
		}
		
		//If the stock isn't at max capacity it fills the truck up with ordinary items 
		//otherwise fill up another ordinary truck until the ordinary stock is empty
		if (temp.GetSize() != 800) {
			truckFull = true;
			for (Item item : ordinary.GetStockArray()) {
			
				if (truckFull) {
					temp.add(item);
					if (temp.GetSize() == 800) {
						Truck coldTruck = new RefrigeratedTruck(temp);
						trucks.add(coldTruck);
						temp = new Stock();
						truckFull = false;
					}
				} else {
					temp.add(item);
					if (temp.GetSize() == 1000) {
						Truck ordinaryTruck = new OrdinaryTruck(temp);
						trucks.add(ordinaryTruck);
						temp = new Stock();
					}
				}
			}
		}
		
		//If there is ordinary stock left over just dump it into a ordinary truck
		if (temp.GetSize() != 1000 && temp.GetSize() > 0) {
			Truck ordinaryTruck = new OrdinaryTruck(temp);
			trucks.add(ordinaryTruck);
		}	
	}
	
	/**
	 * Gets the manifest as an array of Trucks 
	 * for all the for each loops in the GUI
	 * @return trucks
	 * @author Sean O'Connell
	 */
	public ArrayList<Truck> GetManifestArray(){
		return this.trucks;
	} 	
	
	/**
	 *  Get the Cost of the Truck and the cost of each Item in the truck
	 *	For each truck in the manifest
	 * @return cost
	 * @throws DeliveryException 
	 * @author Sean O'Connell
	 */
	public double GetManifestCost() throws DeliveryException {
		double cost = 0;
		for (Truck truck: trucks) {
			for (Item item: truck.GetCargo().GetStockArray()) {
				cost += item.GetCost();
			}
			cost += truck.GetCost();
		}	
		return cost;
	}
}
