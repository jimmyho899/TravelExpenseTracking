package ca.ualberta.cs;

public class TotalCurrencyController {
	
	private static TotalCurrencyList totalCurrencyList = null;
	
	static public TotalCurrencyList getTotalCurrencyList() {
		// if there is no total currency list make a new one
		if (totalCurrencyList == null) {
			totalCurrencyList = new TotalCurrencyList();
		}
		return totalCurrencyList;
	}
	
	public TotalCurrency chooseTotalCurrency() throws EmptyTotalCurrencyListException {
		return getTotalCurrencyList().chooseTotalCurrency();
	}
	
	public void addTotalCurrency(TotalCurrency amount) {
		getTotalCurrencyList().addTotalCurrency(amount);
	}
	
	public void removeTotalCurrency(TotalCurrency amount) {
		getTotalCurrencyList().removeTotalCurrency(amount);
	}
	
}
