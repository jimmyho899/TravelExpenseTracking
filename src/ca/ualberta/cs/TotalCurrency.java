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

import java.util.List;

public class TotalCurrency {
	// in this class we will have two things we get, cost and currency
	// from those things we will sort them into a list where summary will call it
	
	protected float cost;
	protected String currency;

	public TotalCurrency (float cost, String currency) {
		this.cost = cost;
		this.currency = currency;
	}

	public float getCost() {
		return cost;
	}

	public String getCurrency() {
		return currency;
	}
	
	public float toCostString() {
		return getCost();
	}
	
	public String toCurrencyString() {
		return getCurrency();
	}
	
	public float modifyCost(float amount) {
		this.cost = amount;
		return cost;
	}
	
	public String modifyCurrency(String type) {
		this.currency = type;
		return currency;
	}
	
	
	

}
