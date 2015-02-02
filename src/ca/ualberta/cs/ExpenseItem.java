/*
    Travel Expense App: Keeps track of money spent on trips
    
    Copyright (C) 2015 Jimmy Ho jph@ualberta.ca

    This program is free software: you can redistribute it and/or modify
    it under the terms of the GNU General Public License as published by
    the Free Software Foundation, either version 3 of the License, or
    (at your option) any later version.

    This program is distributed in the hope that it will be useful,
    but WITHOUT ANY WARRANTY; without even the implied warranty of
    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
    GNU General Public License for more details.

    You should have received a copy of the GNU General Public License
    along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

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
	SimpleDateFormat fmt = new SimpleDateFormat("yyyy/mm/dd");
	
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
	public Date modifyDate(Date Date) {
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
