package logic;
//package logic; 
//Could not find package logic in packaged file

import java.util.Scanner;

public class FoodOrder {

	// Fields: description, price, chicken, vegetable, extraChicken, extraRice
	// START CODE HERE
	private String description;
	private int price;
	private boolean hasChicken;
	private boolean hasVegetable;
	private boolean hasExtraChicken;
	private boolean hasExtraRice;
	// END CODE HERE

	// Constructor
	// START CODE HERE
	public FoodOrder() {
		description = "Hainanese Chicken rice";
		this.hasChicken = true;
		this.hasVegetable = true;
		this.hasExtraChicken = false;
		this.hasExtraRice = false;
		this.price = 40;
	}
	// END CODE HERE

	// Methods
	// START CODE HERE
	public String getDescription() {
		return description;
	}
	public int getPrice(int price) {
		return calculatePrice(hasChicken, hasVegetable, hasExtraChicken, hasExtraRice);
	}
	private int calculatePrice(boolean hasChicken, boolean hasVegetable, boolean hasExtraChicken, boolean hasExtraRice) {
		if (!hasChicken) {
			price -= 10;
		}
		if (hasExtraChicken) {
			price += 10;
		}
		if  (hasExtraRice) {
			price += 5;
		}
		return price;
	}
	public void setHasChicken(boolean hasChicken) {
		this.hasChicken = hasChicken;
	}
	public void setHasVegetable(boolean hasVegetable) {
		this.hasVegetable = hasVegetable;
	}
	public void setHasExtraChicken(boolean hasExtraChicken) {
		this.hasExtraChicken = hasExtraChicken;
	}
	public void setHasExtraRice(boolean setHasExtraRice) {
		this.hasExtraRice = setHasExtraRice;
	}
	// END CODE HERE

	@Override
	public String toString() {
		// START CODE HERE
		return String.format("That would be %d bath. Thanks!\n%s\nChicken:%b\nVedgetable:%b\nExtra Chicken:%b\nExtra Rice:%b", 
		getPrice(price), description, hasChicken, hasVegetable, hasExtraChicken, hasExtraRice);
		// END CODE HERE
	}

	@Override
	public boolean equals(Object other) {
		// START CODE HERE
		FoodOrder o = (FoodOrder) other;
		if (this.price == o.price) {
			return true;
		}
		return false;
	
		// END CODE HERE
	}

	public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in);
		FoodOrder foodOrder = new FoodOrder();
		System.out.println("Hi, Welcome to Kao-Mun-Gai food stall!");
		System.out.println("We only sell " + foodOrder.getDescription());
		System.out.println("Would you like your meal with chicken? (Yes/No)");
		String customerInput = keyboard.next();
		if (customerInput.equals("No")) {
			foodOrder.setHasChicken(false);
			System.out.println("Okay...");
		} else if (customerInput.equals("Yes")) {
			foodOrder.setHasChicken(true);
		}
		System.out.println("Would you like your meal with vegetable? (Yes/No)");
		customerInput = keyboard.next();
		if (customerInput.equals("No")) {
			foodOrder.setHasVegetable(false);
		} else if (customerInput.equals("Yes")) {
			foodOrder.setHasVegetable(true);
		}
		System.out.println("Extra chicken? (Yes/No)");
		customerInput = keyboard.next();
		if (customerInput.equals("Yes")) {
			foodOrder.setHasExtraChicken(true);
			System.out.println("Good Choice!");
		} else if (customerInput.equals("No")) {
			foodOrder.setHasExtraChicken(false);
		}
		System.out.println("Extra Rice? (Yes/No)");
		customerInput = keyboard.next();
		if (customerInput.equals("Yes")) {
			foodOrder.setHasExtraRice(true);
		} else if (customerInput.equals("No")) {
			foodOrder.setHasExtraRice(false);
		}

		System.out.println(foodOrder);

		// Uncomment the following lines to test equals method
		FoodOrder testOrder = new FoodOrder();
		testOrder.setHasChicken(false);
		testOrder.setHasExtraChicken(false);
		testOrder.setHasExtraRice(true);
		FoodOrder testOrder2 = new FoodOrder();
		testOrder2.setHasChicken(false);
		testOrder2.setHasExtraChicken(false);
		testOrder2.setHasExtraRice(true);
		System.out.println("Equal:" + testOrder.equals(testOrder2));
	}
}
