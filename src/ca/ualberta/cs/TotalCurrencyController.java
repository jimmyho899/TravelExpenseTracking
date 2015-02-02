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
