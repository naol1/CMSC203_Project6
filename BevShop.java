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

import java.util.ArrayList;

 

public class BevShop implements BevShopInterface{
	int MIN_AGE_FOR_ALCOHOL = 21;  
	int MAX_ORDER_FOR_ALCOHOL= 3;   
									
	int MIN_TIME= 8;				
	int MAX_TIME= 23;				
	int MAX_FRUIT = 5;
	
	private int numOfAlco;
	private ArrayList <Order> log = new ArrayList <Order>();
	

	/**
	 * Checks if the time is valid (between 8 and 23 )
	 * @return - true if times is within the range of 8 to 23 , false otherwise
	 */
	@Override
	public boolean isValidTime(int time) 
	{
		if(time < MAX_TIME && time > MIN_TIME)
			return true;
		
		return false;
	}

	/**
	 * gets Max number of fruits
	 * @return - Max number of fruits
	 */
	@Override
	public int getMaxNumOfFruits() 
	{
		return MAX_FRUIT;
	}

	/**
	 * gets Min age for Alcohol
	 * @return - min age for alcohol
	 */
	@Override
	public int getMinAgeForAlcohol() 
	{
		return MIN_AGE_FOR_ALCOHOL ;
	}

	/**
	 * returns true if the passed parameter exceeds the Maximum FRUIT allowed
	 * @return - true if the passed parameter exceeds the MAXIUM number 
	 * 			 of fruits allowed for the SMOTHIE drink, false otherwise
	 */
	@Override
	public boolean isMaxFruit(int numOfFruits) 
	{
		if(numOfFruits > MAX_FRUIT )
			return true;
		
		return false;
	}

	/**
	 * gets max order for alcohol 
	 * @return - max order for alcohol 
	 */
	@Override
	public int getMaxOrderForAlcohol() 
	{
		return MAX_ORDER_FOR_ALCOHOL;
	}

	/**
	 * checks if the number of alcohol beverages for the current order has reached the maximum
	 * @return - true if number of alcohol drinks for the current order has reached the maximum , false otherwise
	 */
	@Override
	public boolean isEligibleForMore() 
	{
		int aCount= getNumOfAlcoholDrink();
		
		if(aCount < 3)
			return true;

		return false;
	}

	/**
	 * returns the number of alcohol drinks for the current order
	 * @return - the number of alcohol drinks for the current order
	 */
	@Override
	public int getNumOfAlcoholDrink() 
	{
		return log.get(log.size()-1).findNumOfBeveType(Type.ALCOHOL);
	}

	/**
	 * check the valid age for the alcohol drink
	 * @return - returns true if age is more than minimum eligible age , false otherwise
	 */
	@Override
	public boolean isValidAge(int age) 
	{
		if(age < MIN_AGE_FOR_ALCOHOL )
			return false;
		
		return true;
	}

	/**
	 * Creates a new order , NO BEVERAGE is added to the order yet
	 * @param - time of the order
	 * @param - day of the order of type DAY
	 * @param - customer name
	 * @param - customer age
	 */
	@Override
	public void startNewOrder(int time, Day day, String customerName, int customerAge) 
	{
		Order current = new Order (time,day,new Customer(customerName,customerAge));		
		
		log.add(current);
	}

	/**
	 * process the Coffee order for the current order by adding it to the
	 * current order
	 *
	 * @param bevName
	 *            beverage name
	 * @param size
	 *            beverage size
	 * @param extraShot
	 *            true if the coffee beverage has extra shot , false otherwise
	 * @param extraSyrup
	 *            true if the coffee beverage has extra syrup , false otherwise
	 */
	@Override
	public void processCoffeeOrder(String bevName, Size size, boolean extraShot, boolean extraSyrup) 
	{
		log.get(log.size()-1).addNewBeverage(bevName, size, extraShot, extraSyrup);
	}

	/**
	 * process the Alcohol order for the current order by adding it to the
	 * current order
	 *
	 * @param bevName
	 *            beverage name
	 * @param size
	 *            beverage size
	 */
	@Override
	public void processAlcoholOrder(String bevName, Size size) 
	{
		log.get(log.size()-1).addNewBeverage(bevName, size);
	}

	/**
	 * process the Smoothie order for the current order by adding it to the
	 * current order
	 * @param bevName
	 *            beverage name
	 * @param size
	 *            beverage size
	 * @param numOfFruits
	 *            number of fruits to be added
	 * @param addProtein
	 *            true if protein is added , false otherwise
	 */
	@Override
	public void processSmoothieOrder(String bevName, Size size, int numOfFruits, boolean addProtein) 
	{
		log.get(log.size()-1).addNewBeverage(bevName, size, numOfFruits, addProtein);
	}

	/**
	 * locate an order based on the order number
	  * @param orderNo
	 *            the order number
	 * @return the index of the order in the list of Orders if found or -1 if
	 *         not found
	 */
	@Override
	public int findOrder(int orderNo) 
	{
		int index = 0;
		for(int i= 0; i < log.size(); i++)
		{
			if(orderNo == log.get(i).getOrderNumber())
				index = i;
		}
		
		return index;
	}

	/**
	 * locates an order in the list of orders and returns the total value on the
	 * order.
	 *
	 * @param orderNo
	 *            the order number
	 * @returns the calculated price on this order.
	 */
	@Override
	public double totalOrderPrice(int orderNo) 
	{
		return log.get(findOrder(orderNo)).calcOrderTotal();
	}

	/**
	 * Calculates the total sale of all the orders for this beverage shop
	 * @return the total sale of all the orders
	 */
	@Override
	public double totalMonthlySale() 
	{
		double monthlySales = 0;
		
		for(int i= 0; i < log.size(); i++)
		{
			monthlySales+= log.get(i).calcOrderTotal();
		}
		return monthlySales;
	}

	/**
	 * returns total numbers of orders within the month
	 * @returns total numbers of orders within the month
	 */
	@Override
	public int totalNumOfMonthlyOrders() 
	{
		return log.size();
	}

	/**
	 * returns the current Order located in the index in the list of orders.
	 * Notes: this method returns the shallow copy of the order
	 * @return the current order
	 */
	@Override
	public Order getCurrentOrder() 
	{
		return log.get(log.size()-1);
	}

	/**
	 * returns Order in the list of orders at the index 
	 * Notes: this method returns the shallow copy of the order
	 * @return Order in the list of orders at the index
	 */
	@Override
	public Order getOrderAtIndex(int index) 
	{
		return log.get(index);
	}

	/**
	 * sorts the orders within this bevShop using the Selection sort algorithm
	 */
	@Override
	public void sortOrders() 
	{
		for (int i = 0; i < log.size() - 1; i++) 
		{  
            int indexMin = i;
                 
            for (int j = i + 1; j < log.size(); j++) 
            { 
                if (log.get(j).getOrderNumber() < log.get(indexMin).getOrderNumber()) 
                    indexMin = j; 
            } 
  
            Order temp = log.get(indexMin);
            log.set(i,log.get(indexMin));
            log.set(i,temp);  
        } 
		
	}

}