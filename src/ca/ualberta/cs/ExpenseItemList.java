package ca.ualberta.cs;

import java.util.ArrayList;
import java.util.Collection;

public class ExpenseItemList {
	
	protected ArrayList<ExpenseItem> ExpenseItemList;
	protected ArrayList<Listener> itemlisteners;
	Collection<Claim> claims = ClaimListController.getClaimList().getClaims();
	ArrayList<Claim> list = new ArrayList<Claim>(claims);
	int setposition = ClaimPosition.getPosition();

	public ExpenseItemList(){	
		// create a new ExpenseItem list 
		//ExpenseItemList = new ArrayList<ExpenseItem>();
		ExpenseItemList = list.get(setposition).toArrayList();
		itemlisteners = new ArrayList<Listener>();
	}
	
	public Collection<ExpenseItem> getExpenseItem() {
		// return the collection of our ExpenseItems
		return list.get(setposition).toArrayList();
	}

	// add a ExpenseItem to our list of ExpenseItems
	public void addExpenseItem(ExpenseItem testExpenseItem) {		
		list.get(setposition).toArrayList().add(testExpenseItem);	
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
