package logic;

import java.util.ArrayList;

public class Order {
	private ArrayList<OrderItem> orderItemList;
	private static int totalOrderCount = 0;
	private int orderNumber;
	
	public Order() {
		orderNumber = totalOrderCount;
		totalOrderCount += 1;
		orderItemList = new ArrayList<OrderItem>();
	}

	public OrderItem addItem(Item item, int amount) {
		// TODO
		// Loop the orderItemList to find if item of any orderItem equals to the given item
		// if there is orderItem with given item, increase that orderItem itemAmount with amount
		// and return that orderItem

		// else create new orderItem with given item and amount, then return the new orderItem
		OrderItem order = new OrderItem(item, amount);
		boolean contain = false;
		for (OrderItem e: orderItemList) {
			if (e.item.equals(item)) {
				e.setItemAmount(e.getItemAmount() + order.getItemAmount());
				contain = true;
				order = new OrderItem(item, e.itemAmount);
				break;
			}
		}

		if (!contain) {
			orderItemList.add(order);
		} 

		return order;
	}

	public int calculateOrderTotalPrice() {
		// TODO
		// Calculate total price of the order by summing total price of each orderItem in orderItemList
		int price = 0;
		for (OrderItem e: orderItemList) {
			price += e.getItem().getPricePerPiece() * e.getItemAmount();
		}
		return price;
	}

	public static int getTotalOrderCount() {
		return totalOrderCount;
	}
	
	public static void resetTotalOrderCount() {
		totalOrderCount = 0;
	}

	public int getOrderNumber() {
		return orderNumber;
	}

	public ArrayList<OrderItem> getOrderItemList() {
		return orderItemList;
	}
	
	
}
