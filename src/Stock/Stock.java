package Stock;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 * This creates the class Stock to be used as
 * a list of Items 
 * @author Sean O'Connell
 *
 */
public class Stock {
	
	private ArrayList<Item> items = new ArrayList<Item>();

	/**
	 * Initializes the class with nothing in it
	 * 
	 */
	public Stock() {
	}
	
	/**
	 * Returns the Stock as a Item array
	 * @return this list of items
	 * 
	 */
	public ArrayList<Item> GetStockArray(){
		return items;
	}
	
	/**
	 * Returns the size of the Stock
	 * @return this list size
	 * 
	 */
	public int GetSize() {
		return items.size();
	}
	
	/**
	 * Adds an Item to the Stock list
	 * @param item
	 * 
	 */
	public void add(Item item) {
		items.add(item);
	}
	
	/**
	 * Adds all the Items from an array to the Stock
	 * @param items
	 * 
	 */
	public void addAll(ArrayList<Item> items) {
		this.items = items;
	}
	
	/**
	 * Sorts the Stock by temperature of each Item
	 * 
	 */
	public void sortByTemp() {
		if (GetSize() > 0) {
			Collections.sort(GetStockArray(), new Comparator<Item>() {
				@Override
				public int compare(final Item object1, final Item object2) {
					return  Integer.valueOf((int)object1.GetTemperature()).compareTo((int)object2.GetTemperature());
				}
			});
		}	
	}
	
	/**
	 * Returns the number of duplicates of Item in the Stock
	 * @param find
	 * @return count of duplicates in a list
	 * 
	 */
	public int CountDuplicates(Item find){
		//Create an array of Strings of Item names 
		ArrayList<String> list = new ArrayList<String>();
		for (Item item: GetStockArray()) {
			list.add(item.GetName());
		}
		
        int count = 0;
        //Check if the list contains the item name
        if (list.contains(find.GetName())) {
        	//Run through the array if so and count number of times it is present
        	for (Item item: GetStockArray()) {
        		if (item.GetName() == find.GetName()) {
        			count++;
        		}
        	}
        }
        return count;
    }
}
