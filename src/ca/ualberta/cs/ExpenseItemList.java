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

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

public class ExpenseItemList implements Serializable {
	
	private static final long serialVersionUID = 7151902898107739087L;
	protected ArrayList<ExpenseItem> ExpenseItemList;
	protected ArrayList<Listener> itemlisteners;

	public ExpenseItemList(){	
		// create a new ExpenseItem list 
		//ExpenseItemList = new ArrayList<ExpenseItem>();
		ExpenseItemList = new ArrayList<ExpenseItem>();
		itemlisteners = new ArrayList<Listener>();
	}
	
	public Collection<ExpenseItem> getExpenseItem() {
		// return the collection of our ExpenseItems
		return ExpenseItemList;
	}

	// add a ExpenseItem to our list of ExpenseItems
	public void addExpenseItem(ExpenseItem testExpenseItem) {		
		ExpenseItemList.add(testExpenseItem);	
		// notify to update other things that we have new things
		notifyListeners();
	}

	// delete a ExpenseItem from the ExpenseItem list
	public void deleteExpenseItem(ExpenseItem testExpenseItem) {		
		ExpenseItemList.remove(testExpenseItem);	
		notifyListeners();
	}
	
	// update our listeners whenever we edit our ExpenseItem
	public void edittedExpenseItem() {
		notifyListeners();
	}
	
	// return the size of the ExpenseItem list
	public int size() {	
		return ExpenseItemList.size();		
	}

	// check to see if testExpenseItem is in ExpenseItem list
	public boolean contains(ExpenseItem testExpenseItem) {
		return ExpenseItemList.contains(testExpenseItem);
	}
	
	public ExpenseItem chooseExpenseItem() throws EmptyExpenseItemListException {
		int size = ExpenseItemList.size();
		// if the size is less than 0 then it is empty
		if (size <= 0) {
			throw new EmptyExpenseItemListException();
		}
		// return the item of ExpenseItemList
		int index = 0;
		return ExpenseItemList.get(index);
	}
	
	// code below and on listeners taken from abram hindle tutorial video https://www.youtube.com/watch?v=7zKCuqScaRE
	public void notifyListeners() {
		for (Listener listener: itemlisteners) {
			listener.update();
		}
	}
	
	public void addListener(Listener l) {
		itemlisteners.add(l);
	}
	
	public void removeListener (Listener l) {
		itemlisteners.remove(l);
	}
	
}
