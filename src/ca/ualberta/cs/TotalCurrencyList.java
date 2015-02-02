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
