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
