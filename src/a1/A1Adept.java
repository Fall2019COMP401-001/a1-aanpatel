package a1;

import java.util.Scanner;

public class A1Adept {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);

		//Get the number of items in the stores
		int numItems = scan.nextInt();
		
		String[] itemName = new String[numItems];
		
		double[] itemPrice = new double[numItems]; 

		//Read name and price for each item and store it
		for(int i=0; i<numItems; i++) {
			itemName[i] = scan.next();
			itemPrice[i] = scan.nextDouble();
		}
		
		//Read number of customers
		int numCustomers = scan.nextInt();
		
		//Initialize outcome variables
		double minAmt = Double.MAX_VALUE, maxAmt = Double.MIN_VALUE, avgAmt = 0;
		
		String minAmtName = null, maxAmtName = null, fname = null, lname = null;
		
		for(int i=0;i<numCustomers;i++) {
			
			//Take firstname, lastname and number of items for current customer 
			 fname = scan.next();
			 lname = scan.next();
			 int itemCount = scan.nextInt();
			 
			 //Initialize bill amount for current customer
			 double billAmt = 0;
			 
			 //Code for finding bill amount for current customer
			 for(int j = 0; j < itemCount; j++) {
				 int qty = scan.nextInt();
				 String nameOfItem = scan.next();
				 billAmt += qty*getPrice(itemPrice, itemName, nameOfItem);
			 }
			 
			 //Code for finding the smallest bill amount
			 if(billAmt < minAmt) {
				 minAmt = billAmt;
				 minAmtName = fname + " " + lname;
			 }
			 
			 //Code for finding the biggest bill amount
			 if(billAmt > maxAmt) {
				 maxAmt = billAmt;
				 maxAmtName = fname + " " + lname;
			 }
			 
			 //Average = total/number of instances, so first find total
			 avgAmt += billAmt;
		}
		
		//Display all the outcomes
		
		System.out.println("Biggest: " + maxAmtName + " ("+String.format("%.2f", maxAmt)+")");
		
		System.out.println("Smallest: " + minAmtName + "(" + String.format("%.2f", minAmt) + ")");
		
		avgAmt /= numCustomers;
		
		System.out.println("Average: " + String.format("%.2f", avgAmt));
		// Your code follows here.
	}
	
	//Function to fetch price from item name
	public static double getPrice(double[] prices, String[] names, String name) {
		for(int i=0;i<prices.length;i++) {
			if(names[i].equals(name)) {
				return prices[i];
			}
		}
		return -1;
	}
}