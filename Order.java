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
import java.util.Random;

public class Order implements OrderInterface, Comparable {
	
	private int orderNumber;
	private int orderTime;
	private Day orderDay;
	private Customer cust;
	private ArrayList <Beverage> bevList = new ArrayList <Beverage>();

	/**
	 * Constructor for Order
	 * @param orderTime
	 * @param orderDay
	 * @param cust
	 */
	Order(int orderTime, Day orderDay, Customer cust)
	{
		this.orderTime = orderTime;
		this.orderDay = orderDay;
		this.cust = cust;
		this.orderNumber = generateOrder();
	}

	/**
	 * get order number
	 * @return - order number
	 */
	public int getOrderNumber() {
		return orderNumber;
	}

	/**
	 * set order number
	 * @param orderNumber
	 */
	public void setOrderNumber(int orderNumber) {
		this.orderNumber = orderNumber;
	}

	/**
	 * get time
	 * @return - time
	 */
	public int getOrderTime() {
		return orderTime;
	}

	/**
	 * set time
	 * @param orderTime
	 */
	public void setOrderTime(int orderTime) {
		this.orderTime = orderTime;
	}

	/**
	 * get order day
	 * @return - order day
	 */
	public Day getOrderDay() {
		return orderDay;
	}
	
	/**
	 * get day
	 * @return - day
	 */
	public Day getDay()
	{
		return orderDay;
	}

	/**
	 * set day
	 * @param orderDay
	 */
	public void setOrderDay(Day orderDay) {
		this.orderDay = orderDay;
	}

	/**
	 * get customer
	 * @return - customer
	 */
	public Customer getCustomer() {
		return cust;
	}

	/**
	 * set customer
	 * @param cust
	 */
	public void setCustomer(Customer cust) {
		this.cust = cust;
	}
	
	/**
	 * Automatically generate order number
	 * @return - order number
	 */
	public int generateOrder()
	{
		 Random rand = new Random();
		 
		return rand.nextInt(90000 - 10000 + 1) + 10000;
	}
	
	/**
	 * Compare two orders depending on order number
	 */
	@Override
	public int compareTo(Object o) 
	{
			Order p = (Order) o;
			
			if(this.orderNumber > p.getOrderNumber())
				return 1;
			else if(this.orderNumber == p.getOrderNumber())
				return 0;
			else
				return -1;
	}

	/**
	 * @return true if the day is a weekend day (Saturday or Sunday)
	 */
	@Override
	public boolean isWeekend() 
	{
		if(orderDay.equals(Day.SATURDAY)|| orderDay.equals(Day.SUNDAY))
			return true;
		
		return false;
	}

	/**
	 * returns the beverage listed in the itemNo of the order, for example if
	 * itemNo is 0 this method will return the first beverage in the order
	 * Note: this method returns the shallow copy of the Beverage
	 * 
	 * @return the beverage listed in the itemNo of the order or null if there
	 *         is no item in the order
	 * 
	 */
	@Override
	public Beverage getBeverage(int itemNo) 
	{
		return bevList.get(itemNo);
		 
	}

	/**
	 * adds coffee order to this order
	 * @param bevName beverage name
	 * @param size beverage size of type SIZE
	 * @param extraShot true if the coffee beverage has extra shot , false otherwise
	 * @param extraSyrup true if the coffee beverage has extra syrup , false otherwise
	 */
	@Override
	public void addNewBeverage(String bevName, Size size, boolean extraShot, boolean extraSyrup) 
	{
		Coffee joe = new Coffee(bevName,size,extraShot,extraSyrup);
		bevList.add(joe);
		
	}

	/**
	 * adds alcohol order to this order
	 * @param bevName beverage name
	 * @param size beverage size
	 */ 
	@Override
	public void addNewBeverage(String bevName, Size size) 
	{
		Alcohol alcoDrink = new Alcohol(bevName,size,isWeekend());
		bevList.add(alcoDrink);
		
	}

	/**
	 * Adds the Smoothie beverage to this order
	 * @param bevName beverage name
	 * @param size beverage size
	 * @param numOfFruits number of fruits added 
	 * @param addProtein true if protein is added, false otherwise
	 */
	@Override
	public void addNewBeverage(String bevName, Size size, int numOfFruits, boolean addProtein) 
	{
		Smoothie juice = new Smoothie(bevName,size, numOfFruits,addProtein);
		bevList.add(juice);
		
	}

	/**
	 * Calculates and returns the total amount for this order
	 * @return total amount for this order
	 */
	@Override
	public double calcOrderTotal() 
	{
		double total = 0;
		
		for(int i= 0; i < bevList.size(); i++)
		{
			total += bevList.get(i).calcPrice();
		}
		
		return total;
	}

	/**
	 * returns the number of beverages of same type in an order
	 * @param type the type of the beverage
	 * @return number of beverages of type type in this order
	 */
	@Override
	public int findNumOfBeveType(Type type) 
	{
		int total = 0;
		
		for(int i= 0; i < bevList.size(); i++)
		{
			if( type.equals(bevList.get(i).getType()))
			{
				total++;
			}
		}
		
		return total;
	}
	
	/**
	 * returns the total number of beverages ordered within this order
	 * @return - total number of beverages ordered within this order
	 */
	public int getTotalItems()
	{
		return bevList.size();
	}


	/**
	 * Create a string containing information for order
	 * @return - string containing information for order
	 */
	@Override
	public String toString() 
	{
		String list = "\n ";
		for(int i= 0; i < bevList.size(); i++)
		{
			list += bevList.get(i).toString() + "\n";
		}
		
		
		return "Order Number: " + getOrderNumber() + "\n Order Time: " + getOrderTime() + "\n Order Day: "
				+ getOrderDay() + "\n Customer Name: " + getCustomer().getName() +"\n Customer Age: " + 
				getCustomer().getAge() + list+"\n Order Total()=" + calcOrderTotal();
	}
	
	

}