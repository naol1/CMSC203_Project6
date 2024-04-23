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


public class Coffee extends Beverage {
	
	static final double EXTRA_COFFEE = 0.5;
	static final double EXTRA_SYRUP = 0.5;
	
	private boolean extraShot;
	private boolean extraSyrup;
	
	/**
	 * Creates a Coffee object using the given values
	 * @param bevName
	 * @param size
	 * @param extraShot
	 * @param extraSyrup
	 */
	Coffee(String bevName, Size size, boolean extraShot, boolean extraSyrup)
	{
		super(bevName, Type.COFFEE, size);
		this.extraSyrup = extraSyrup;
		this.extraShot = extraShot;
	}

	/**
	 * gets value for extra shot
	 * @return - value for extra shot
	 */
	public boolean getExtraShot() {
		return extraShot;
	}

	/**
	 *sets value for extra shot
	 * @param extraShot
	 */
	public void setExtraShot(boolean extraShot) {
		this.extraShot = extraShot;
	}

	/**
	 * gets value for extra syrup
	 * @return - value for extra syrup
	 */
	public boolean getExtraSyrup() {
		return extraSyrup;
	}

	/**
	 *sets value for extra syrup
	 * @param extraSyrup
	 */
	public void setExtraSyrup(boolean extraSyrup) {
		this.extraSyrup = extraSyrup;
	}

	/**
	 * Calculates the price based on base price, size, extra coffee shot and extra syrup
	 * @return - Price of coffee based on spec
	 */
	@Override
	public double calcPrice() 
	{
		double price = 0;
		
		if(this.extraShot && this.extraSyrup)
		{
			price = (super.addSizePrice()+ EXTRA_COFFEE + EXTRA_SYRUP);
		}
		else if(this.extraShot)
		{
			price = (super.addSizePrice()+ EXTRA_COFFEE);
		}
		else if(this.extraSyrup)
		{
			price = (super.addSizePrice()+ EXTRA_SYRUP);
		}
		else
		{
			price = super.addSizePrice();
		}		
		
		return price;
	}
	
	/**
	 * Checks if this Beverage equals to anotherBev
	 * @return - true if the name, type, size and base price and whether 
	 * 			 or not it contains extra shot and extra syrup false otherwise
	 */
	@Override
	public boolean equals(Object anotherBev)
	{
		Beverage test = (Beverage)anotherBev;
		if(super.getBevName().equals(test.getBevName()) && super.getSize().equals(test.getSize()) 
				&& super.getType().equals(test.getType()))
		{
			Coffee test2 = (Coffee)anotherBev;
			if(this.extraShot == test2.extraShot && this.extraSyrup == test2.extraSyrup )
				return true;
		}
					
		return false;
	}

	/**
	 * Represents a Coffee beverage in the following String format: 
	 * name,size, whether it contains extra shot, extra syrup and the price
	 * @return - String representation of a Coffee
	 */
	@Override
	public String toString() 
	{
		if(this.extraShot && this.extraSyrup)
		{
			return super.toString()+ "\n Extra shot of Coffee and Syrup added" +"\n Price: "+ calcPrice();
		}
		else if(this.extraSyrup)
		{
			return super.toString()+ "\n Extra shot of Syrup added" +"\n Price: "+ calcPrice();
		}
		else if(this.extraShot)
		{
			return super.toString()+ "\n Extra shot of Coffee added" +"\n Price: "+ calcPrice();
		}
		else
		{
			return super.toString()+"\n Price: "+ calcPrice() ;
		}
			
	}
		

}