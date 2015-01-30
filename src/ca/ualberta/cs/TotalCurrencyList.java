package ca.ualberta.cs;

import java.util.ArrayList;
import java.util.Collection;

public class TotalCurrencyList {
	
	protected ArrayList<TotalCurrency> TotalCurrencyList = null;
	
	public TotalCurrencyList() {
		TotalCurrencyList = new ArrayList<TotalCurrency>();
	}
	
	public Collection<TotalCurrency> getTotalCurrency() {
		return TotalCurrencyList;
	}
	
	public void addTotalCurrency(TotalCurrency amount) {
		TotalCurrencyList.add(amount);
	}
	
	public void removeTotalCurrency(TotalCurrency amount) {
		TotalCurrencyList.remove(amount);
	}
	
	public TotalCurrency chooseTotalCurrency() throws EmptyTotalCurrencyListException {
		int size = TotalCurrencyList.size();
		if (size <= 0) {
			throw new EmptyTotalCurrencyListException();
		}
		int index = 0;
		return TotalCurrencyList.get(index);
	}

	public int size() {
		return TotalCurrencyList.size();
	}
	
	public TotalCurrency getItem(int i) {
		return TotalCurrencyList.get(i);
	}
	
}
