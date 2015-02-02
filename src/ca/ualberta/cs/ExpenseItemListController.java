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

public class ExpenseItemListController {
	
	private static ExpenseItemList expenseItemList = null;
	
	static public ExpenseItemList getExpenseItemList() {
		// if it is empty create a new ExpenseItemList
		if (expenseItemList == null) {
			expenseItemList = new ExpenseItemList();
		}
		
		return expenseItemList;
	}
	
	// 
	public ExpenseItem chooseExpenseItem() throws EmptyExpenseItemListException {
		return getExpenseItemList().chooseExpenseItem();
	}
	
	// this adds a ExpenseItem to our ExpenseItem list
	public void addExpenseItem(ExpenseItem item) {
		getExpenseItemList().addExpenseItem(item);
	}

	// this is used to notify our listeners
	public void edittedExpenseItem() {
		getExpenseItemList().edittedExpenseItem();
	}
}
