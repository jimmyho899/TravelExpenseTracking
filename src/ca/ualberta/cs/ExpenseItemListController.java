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
