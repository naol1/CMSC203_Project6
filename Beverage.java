/*
 * Class: CMSC203 
 * Instructor: Prof. Ahmed Tarek
 * Description: The BevShop offers 3 types of beverages: Coffee, Alcoholic and Smoothie. Beverages can 
 * 				be ordered in 3 different sizes: Small, medium, and large. All the beverage types have a 
 * 				base price. In addition, there are additional charges depending on the size and specific 
 * 				add-ons for each type of beverage. Create a Program to run the BevShop.
 * Due: 22/04/2024
 * Platform/compiler: Eclipse
 * I pledge that I have completed the programming assignment independently. 
 * I have not copied the code from a student or any source. 
 * I have not given my code to any student.
 * Print your Name here: Naol Gobena
*/

public abstract class Beverage {
	static final double BASE_PRICE = 2;
	static final double SIZE_PRICE = 1;
	
	private String bevName;
	private Type type;
	private	Size size;
	
	
	/**
	 * Creates a beverage object using given values.
	 * @param bevName
	 * @param type
	 * @param size
	 */
	public Beverage(String bevName, Type type, Size size)
	{
		this.bevName = bevName;
		this.size = size;
		this.type = type;
	}
		
	
	/**
	 * Calculates the beverage price
	 * @return - the price of the beverage
	 */
	public abstract double calcPrice();
	
	public double getBasePrice() {
		return BASE_PRICE;
	}

	
	/**
	 * gets Beverage name
	 * @return - Beverage name
	 */
	public String getBevName() {
		return bevName;
	}
	
	
	/**
	 * sets Beverage name
	 * @param bevName
	 */
	public void setBevName(String bevName) {
		this.bevName = bevName;
	}

	/**
	 * gets Beverage type
	 * @return - Beverage type
	 */
	public Type getType() {
		return type;
	}

	/**
	 * Sets Beverage type
	 * @param type
	 */
	public void setType(Type type) {
		this.type = type;
	}

	/**
	 * gets size
	 * @return - size
	 */
	public Size getSize() {
		return size;
	}

	/**
	 * sets size
	 * @param size
	 */
	public void setSize(Size size) {
		this.size = size;
	}
	
	/**
	 * Calculates a new price by adding the size price to the base price. There is no additional cost 
	 * for small size, for medium and large beverages the additional cost of size price is added to 
	 * base price For example if the base price is 2 and SIZE_PRICE is .5 then the cost of small 
	 * beverage is 2, the medium beverage is 2.5 and the large beverage is 3.
	 * @return - Beverage Price
	 */
	public double addSizePrice()
	{
		double sizePrice = BASE_PRICE;
		
		switch(this.size) 
		{
		case MEDIUM:
			sizePrice = BASE_PRICE + SIZE_PRICE;
			return sizePrice;
			
			
		case LARGE:
			sizePrice = BASE_PRICE + SIZE_PRICE + SIZE_PRICE ;
			return sizePrice;
		
			
		default:
			return sizePrice;
		}
				
	}
	
	/**
	 * Checks if this Beverage equals to anotherBev
	 * @return - true if the name, type, size , false otherwise
	 */
	@Override
	public boolean equals(Object anotherBev)
	{
		Beverage test = (Beverage)anotherBev;
		if(this.bevName.equals(test.bevName) && this.size.equals(test.size) && this.type.equals(test.type))
			return true;
		
		return false;
	}

	/**
	 * Represents a Beverage object in String with the format of bevName,size
	 * @return - the String representation of beverage
	 */
	@Override
	public String toString() {
		return this.bevName + ", " + size;
	}
}