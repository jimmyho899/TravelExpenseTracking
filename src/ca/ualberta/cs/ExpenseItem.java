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
	SimpleDateFormat fmt = new SimpleDateFormat("dd/mm/yyyy");
	
	public ExpenseItem(String itemName, String itemDate, String itemCategory, 
			String itemDescription, String itemCurrency) {
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
	}
	
	public String getName() {
		return this.itemName;
	}
	

}
