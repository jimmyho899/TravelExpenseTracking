package ca.ualberta.cs;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

public class SummaryActivity extends Activity {

	// In this class we want to get our TotalCurrency class and add up the currencies
	// initialize our amounts to be 0 at first
	private float CADamount = 0;
	private float USDamount = 0;
	private float EURamount = 0;
	private float GBPamount = 0;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_summary);
		// we need to call our total currency class and get the list of all the item's cost and currency
		TotalCurrencyList list = TotalCurrencyController.getTotalCurrencyList();
		
		// if there is nothing we will have a message
		if (list.size() == 0)
			Toast.makeText(SummaryActivity.this, "No Items!", Toast.LENGTH_SHORT).show();
		
		for (int i=0; i<list.size(); i++) {
			TotalCurrency item = list.getItem(i);
			float cost = item.getCost();
			String currency = item.getCurrency();
			// now that we extract them we want to add it to the amount depending on what currency it is
			// used http://stackoverflow.com/questions/513832/how-do-i-compare-strings-in-java for clarification
			if (currency.equals("CAD")) 
				CADamount = CADamount + cost;
			else if (currency.equals("USD")) 
				USDamount = USDamount + cost;
			else if (currency.equals("EUR"))
				EURamount = EURamount + cost;
			else 
				GBPamount = GBPamount + cost;
		}
		// now that we have updated the values of our cost for each currency we will now display it on the activity_summary
		// first we have to convert our floats into strings so we can display them
		// reference from http://stackoverflow.com/questions/5402637/displays-float-into-text-view
		String CADstr = Float.toString(CADamount);
		String USDstr = Float.toString(USDamount);
		String EURstr = Float.toString(EURamount);
		String GBPstr = Float.toString(GBPamount);
		
		// now we want to get our R.id of our textView where we will be displaying these and then set them
		// http://stackoverflow.com/questions/4670951/how-call-reference-textviewfindviewbyid-from-another-class
		TextView CADcost = (TextView)findViewById(R.id.costCAD);
		CADcost.setText(CADstr);
		TextView USDcost = (TextView)findViewById(R.id.costUSD);
		USDcost.setText(USDstr);
		TextView EURcost = (TextView)findViewById(R.id.costEUR);
		EURcost.setText(EURstr);
		TextView GBPcost = (TextView)findViewById(R.id.costGBP);
		GBPcost.setText(GBPstr);
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
