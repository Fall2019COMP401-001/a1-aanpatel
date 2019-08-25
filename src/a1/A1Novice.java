package a1;

import java.util.Scanner;

public class A1Novice {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		//Read number of customers
		int customerCount = scan.nextInt();
		
		//Create a string array that holds all output lines
		String[] outputs = new String[customerCount];
		
		for(int i=0;i<customerCount;i++) {
			String fname = scan.next();
			String lname = scan.next();
			int itemCount = scan.nextInt();
			double totalCost = 0;
			for(int j=0;j<itemCount;j++) {
				int qty = scan.nextInt();
				String itemName = scan.next();
				double price = scan.nextDouble();
				totalCost += price*qty;
			}
			outputs[i] = fname.charAt(0) + ". "+ lname + ": " + String.format("%.2f", totalCost);
		}
		
		for(int i=0;i<customerCount;i++) {
			System.out.println(outputs[i]);
		}
	}
}
