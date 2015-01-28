package ca.ualberta.cs;

import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class ExpenseItem {
	// this is the class for our expense item. each item will have a name, the date it is bought, 
	// a category, a description and how much it cost and in what currency 
	protected String itemName;
	protected Date itemDate = new Date();
	protected String itemCategory;
	protected String itemDescription;
	protected String itemCurrency;
	protected float itemCost;
	SimpleDateFormat fmt = new SimpleDateFormat("dd/mm/yyyy");
	
	public ExpenseItem(String itemName, String itemDate, String itemCategory, 
			String itemDescription, String itemCurrency, float itemCost) {
		this.itemName = itemName;
		try {
			this.itemDate = fmt.parse(itemDate);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.itemCategory = itemCategory;
		this.itemDescription = itemDescription;
		this.itemCurrency = itemCurrency;
		this.itemCost = itemCost;
	}

	public String getItemName() {
		return itemName;
	}

	public Date getItemDate() {
		return itemDate;
	}

	public String getItemCategory() {
		return itemCategory;
	}

	public String getItemDescription() {
		return itemDescription;
	}

	public String getItemCurrency() {
		return itemCurrency;
	}
	
	public float getItemCost() {
		return itemCost;
	}

	// used to get the name of the item
	public String toString() {
		return getItemName();
	}
	
	// used to get the date of purchase of the item
	public Date toDateString() {
		return getItemDate();
	}

	// used to get the details of the item
	public String toDescriptionString() {
		return getItemDescription();
	}
	
	// used to get the category of the item
	public String toCategoryString() {
		return getItemCategory();
	}
	
	// used to get the currency of the item
	public String toCurrencyString() {
		return getItemCurrency();
	}
	
	// used to get the cost of the item
	public float toCostString() {
		return getItemCost();
	}
	
	// allows us to change the name of the item
	public String modifyName(String Name) {
		this.itemName = Name;
		return itemName;
	}
	
	// allows us to change the start date of the item
	public Date modifyStartDate(Date Date) {
		this.itemDate = Date;
		return itemDate;
	}
	
	// allows us to change the details of the item
	public String modifyItemDescription(String Description) {
		this.itemDescription = Description;
		return itemDescription;
	}
	
	// allows us to change the category of the item
	public String modifyItemCategory(String Category) {
		this.itemCategory = Category;
		return itemCategory;
	}
	
	// allows us to change the currency of the item
	public String modifyItemCurrency(String Currency) {
		this.itemCurrency = Currency;
		return itemCurrency;
	}
	
	// allows us to change the cost of the item
	public float modifyItemCost(float Cost) {
		this.itemCost = Cost;
		return itemCost;
	}

}
