package a1;

import java.util.Scanner;

public class A1Jedi {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);

		//Get the number of items in the stores
		int numItems = scan.nextInt();
		
		String[] itemNameList = new String[numItems];
		
		double[] itemPriceList = new double[numItems];
		
		int[] purchaseList = new int[numItems];
		
		int[] buyerCountList = new int[numItems];

		//Read name and price for each item and store it
		for(int i=0; i<numItems; i++) {
			itemNameList[i] = scan.next();
			itemPriceList[i] = scan.nextDouble();
		}
		
		//Read number of customers
		int numCustomers = scan.nextInt();
		
		//Initialize strings for first name and last name
		String fname = null, lname = null;
		
		for(int i=0;i<numCustomers;i++) {
			
			//Take firstname, lastname and number of items for current customer 
			 fname = scan.next();
			 lname = scan.next();
			 int itemCount = scan.nextInt();
			 int[] countedItem = new int[numItems];
			 //Take the items and their quantities bought by the customer. Also update the purchaseList and buyerCountList accordingly
			 for(int j = 0; j < itemCount; j++) {
				 int qty = scan.nextInt();
				 String nameOfItem = scan.next();
				 if(qty>0) {
					 int index = getItemIndex(itemNameList, nameOfItem);
					 purchaseList[index] += qty;
					 if(countedItem[index] == 0) {
						 countedItem[index] = 1;
						 buyerCountList[getItemIndex(itemNameList, nameOfItem)] += 1;
					 }
				 }
			 }
		}
		//Display all the outcomes
		for(int i = 0; i < numItems; i++) {
			if(buyerCountList[i] == 0) {
				System.out.println("No customers bought "+itemNameList[i]);
			}
			else {
				System.out.println(buyerCountList[i] + " customers bought " + purchaseList[i] + " " + itemNameList[i]);
			}
		}
	}
	
	//Function to fetch item number (index) from item name
	public static int getItemIndex(String[] names, String name) {
		for(int i=0;i<names.length;i++) {
			if(names[i].equals(name)) {
				return i;
			}
		}
		return -1;
	}
}