package GUI;

import java.text.NumberFormat;
import java.util.Locale;

import Exceptions.DeliveryException;
import Exceptions.StockException;

/**
 * This instantiates the class Store as a singleton class
 * @author Sean O'Connell
 *
 */
public class Store {
	
	private Store current = null;
	
	private String name;
	private double capital;
	/**
	 * Create the store with a name and a capital
	 * If it doesn't exist yet create else do nothing
	 * @param name
	 * @param capital
	 * 
	 */
	public Store(String name, double capital) {
		if (current == null) {
			this.name = name;
			this.capital = capital;
		}
	}

	/**
	 * Get the name of the store
	 * @return name
	 * 
	 */
	public String GetStoreName() {
		return this.name;
	}
	
	/**
	 * Get the store capital as a double
	 * @return capital
	 * 
	 */
	public double GetStoreCapital() {
		return this.capital;
	}
	
	/**
	 * Gets the capital as a string with store capital header
	 * @return stringCapital
	 * 
	 */
	public String GetCapitalString() {
		String stringCapital = "Store Capital: $" + NumberFormat.getNumberInstance(Locale.US).format(capital);
		return stringCapital;
	}
	
	/**
	 * Used the capital to pay for stock when the item quantity is low
	 * @param d
	 * @throws StockException
	 * 
	 */
	public void PayWithCapital(double d) throws DeliveryException {
		if (capital >= d) {
			this.capital -= d;
		} else {
			throw new DeliveryException();
		}
	}
	
	/**
	 * Sell items and increase the capital
	 * @param sell
	 * 
	 */
	public void SellItemsForCapital(double sell) {
		this.capital += sell;
	}
}

