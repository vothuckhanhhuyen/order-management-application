package order;

import java.util.ArrayList;
import java.util.Random;

import disc.Media;
import utils.MyDate;

/**
 * @author vothuckhanhhuyen
 *
 */
/**
 * @author vothuckhanhhuyen
 *
 */
public class Order {
	public static final int MAX_LIMITED_ORDERS = 5;
	public static int nbOrders = 0;
	private MyDate dateOrdered = new MyDate();
	public static final int MAX_NUMBERS_ORDERED = 10;
	public ArrayList<Media> itemsOrdered = new ArrayList<Media>();
	
	/**
	 * 
	 */
	public Order() {
		if (nbOrders == MAX_LIMITED_ORDERS) {
			System.out.println("You can't add a order");
		} else {
			nbOrders += 1;
		}
	}
	
	/**
	 * @return the dateOrdered
	 */
	public MyDate getDateOrdered() {
		return dateOrdered;
	}
	/**
	 */
	public void setDateOrdered(MyDate dateOrdered) {
		this.dateOrdered = dateOrdered;
	}
	
	/**
	 * @return
	 */
	public int getNoMedias() {
		return itemsOrdered.size();
	}
	
	/**
	 * @param med
	 */
	public void addMedia(Media med) {
		if (itemsOrdered.size() == MAX_NUMBERS_ORDERED) {
			System.out.println("The order is almost full");
		} else {
			itemsOrdered.add(med);
			System.out.println("The media (" + med.getTitle() + ", "
											+ med.getCategory() + ", "
											+ med.getCost() + ") has been added");
		}
	}
	
	/**
	 * @param medList
	 */
	public void addMedia(Media[] medList) {
		if (itemsOrdered.size() + medList.length > MAX_NUMBERS_ORDERED) {
			System.out.println("The order is almost full if you added");
		} else {
			for (int i = 0; i < medList.length; i++) {
				this.addMedia(medList[i]);
			}
		}
	}
	
	/**
	 * @param med1
	 * @param med2
	 */
	public void addMedia(Media med1, Media med2) {
		if (itemsOrdered.size() + 2 > MAX_NUMBERS_ORDERED) {
			System.out.println("The order is almost full if you added");
		} else {
			this.addMedia(med1);
			this.addMedia(med2);
		}
	}
	
	/**
	 * @param med
	 */
	public void removeMedia(Media med) {
		for (int i = 0; i < itemsOrdered.size(); i++) {
			if (med.getCategory() == itemsOrdered.get(i).getCategory() &&
					med.getTitle() == itemsOrdered.get(i).getTitle() &&
					med.getCost() == itemsOrdered.get(i).getCost()) {
				for (int j = i; j < itemsOrdered.size() - 1; j++) {
					itemsOrdered.get(j).setCategory(itemsOrdered.get(j + 1).getCategory());
					itemsOrdered.get(j).setTitle(itemsOrdered.get(j + 1).getTitle());
					itemsOrdered.get(j).setCost(itemsOrdered.get(j + 1).getCost());
				}
				System.out.println("The media (" + med.getTitle() + ", "
												+ med.getCategory() + ", "
												+ med.getCost() + ") has been removed");
				itemsOrdered.remove(itemsOrdered.size() - 1);
			} else {
				System.out.println("There is no media suited this!");
			}
		}
	}
	
	/**
	 * @param idx
	 */
	public void removeMedia(int idx) {
		System.out.println("The media (" + itemsOrdered.get(idx).getTitle() + ", "
										 + itemsOrdered.get(idx).getCategory() + ", "
				                         + itemsOrdered.get(idx).getCost() + ") has been removed");
		for (int j = idx; j < itemsOrdered.size() - 1; j++) {
			itemsOrdered.get(j).setCategory(itemsOrdered.get(j + 1).getCategory());
			itemsOrdered.get(j).setTitle(itemsOrdered.get(j + 1).getTitle());
			itemsOrdered.get(j).setCost(itemsOrdered.get(j + 1).getCost());
		}
		itemsOrdered.remove(itemsOrdered.size() - 1);
	}
	
	/**
	 * @return
	 */
	public float totalCost() {
		float tCost = 0;
		for (int i = 0; i < itemsOrdered.size(); i++) {
			tCost += itemsOrdered.get(i).getCost();
		}
		return tCost;
	}
	
	/**
	 * 
	 */
	public void printOrder() {
		System.out.println("***********************Order***********************");
		System.out.println("Date: [" + this.dateOrdered.getDay() + " - " + this.dateOrdered.getMonth()+ " - " + this.getDateOrdered().getYear() + "]");
		System.out.println("Ordered Items:");
		for (int i = 0; i < itemsOrdered.size(); i++) {
			System.out.println((i + 1) + ". DVD - [" + itemsOrdered.get(i).getTitle() + "] - ["
													+ itemsOrdered.get(i).getCategory() + "] - ["
													+ itemsOrdered.get(i).getCost() + "] $");
		}
		System.out.println("Total cost: [" + this.totalCost() + "]");
		System.out.println("***************************************************");
	}
	
	/**
	 * 
	 */
	double random = Math.random();
	public int i = (int)( random * itemsOrdered.size() );
	public void getALuckyItem() {

		System.out.println("You get item " + (i + 1) + ". DVD - [" + itemsOrdered.get(i).getTitle() + "] - ["
												+ itemsOrdered.get(i).getCategory() + "] - ["
												+ itemsOrdered.get(i).getCost() + "] $" + " for free!");
		this.itemsOrdered.get(i).setCost(0);
	}
}
