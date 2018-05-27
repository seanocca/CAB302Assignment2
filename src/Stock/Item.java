package Stock;

public class Item {
	
	public String itemName;
	public double itemCost, itemPrice, itemOrderPoint, itemOrderAmount, itemQuantity, buyingQuantity, itemSafeTemp;

	/**
	 * Initialize the attributes of the created Item 
	 * @param attributes
	 * @author Sean O'Connell
	 */
	public Item(String[] attributes) {
		this.itemName = attributes[0];
		if (attributes.length > 2) {
			this.itemCost = Double.parseDouble(attributes[1]);		
			this.itemPrice = Double.parseDouble(attributes[2]);
			this.itemOrderPoint = Double.parseDouble(attributes[3]);
			this.itemOrderAmount = Double.parseDouble(attributes[4]);
			if (attributes.length > 5) {
				if (Double.parseDouble(attributes[5]) <= 20) {
					this.itemSafeTemp = Double.parseDouble(attributes[5]);
				} else {
					this.itemSafeTemp = 30;
				}
			}
			this.itemQuantity = 0;
		}
		
				
	}
	
	/**
	 * Return the name of the Item
	 * @return
	 * @author Sean O'Connell
	 */
	public String GetName() {
		return this.itemName;
	}

	/**
	 * Return the manufacturing cost of the Item
	 * @return
	 * @author Sean O'Connell
	 */
	public double GetCost() {
		return this.itemCost;
	}

	/**
	 * Return the sale price of the Item
	 * @return
	 * @author Sean O'Connell
	 */
	public double GetPrice() {
		return this.itemPrice;
	}

	/**
	 * Return the reorder point of the Item
	 * @return
	 * @author Sean O'Connell
	 */
	public double GetReorderPoint() {
		return this.itemOrderPoint;
	}

	/**
	 * Return the reorder amount
	 * @return
	 * @author Sean O'Connell
	 */
	public double GetReorderAmount() {
		return this.itemOrderAmount;
	}

	/**
	 * Return the temperature of the Item
	 * @return
	 * @author Sean O'Connell
	 */
	public double GetTemperature() {
		return this.itemSafeTemp;
	}

	/**
	 * Set the quantity of the Item in the store
	 * @param newQuantity
	 * @author Sean O'Connell
	 */
	public void SetQuantity(double newQuantity) {
		this.itemQuantity += newQuantity;
	}
	
	/**
	 * Return the quantity of the Item in the store
	 * @return
	 * @author Sean O'Connell
	 */
	public double GetQuantity() {
		return this.itemQuantity;
	}
	
	/**
	 * Return the quantity being bought
	 * @return
	 * @author Sean O'Connell
	 */
	public double GetBuyingQuantity() {
		return this.buyingQuantity;
	}
	
	/**
	 * Set the quantity being bought
	 * @param quantity
	 * @author Sean O'Connell
	 */
	public void SetBuyingQuantity(double quantity) {
		this.buyingQuantity = quantity;
	}
	
}
