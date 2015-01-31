package ca.ualberta.cs;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class AddItemActivity extends Activity {
	
	// call our spinners so we can reference them
	public Spinner spinnerCategory;
	public Spinner spinnerCurrency;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		// set up our add_claim ui screen
		setContentView(R.layout.add_item);
		Button doneButton = (Button) findViewById(R.id.doneItem);
		doneButton.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// Test text "Added Item!"
				Toast.makeText(AddItemActivity.this, "Added Item!", Toast.LENGTH_SHORT).show();
				
				// initialize a ExpenseItemListController where we can then add things 
				ExpenseItemListController eil = new ExpenseItemListController();
				
				// extract our name of the claim from the edit text and add it to our claim list
				EditText nametextView = (EditText) findViewById(R.id.nameOfItem);
				EditText datetextView = (EditText) findViewById(R.id.itemDate);
				EditText costtextView = (EditText) findViewById(R.id.itemCost);
				EditText descriptiontextView = (EditText) findViewById(R.id.itemDescription);
				
				// reference our spinner from our xml
				spinnerCategory = (Spinner)findViewById(R.id.itemCategory);
				spinnerCurrency = (Spinner)findViewById(R.id.itemCurrency);
				
				// get our item from the spinners
				String Category = spinnerCategory.getSelectedItem().toString();
				String Currency = spinnerCurrency.getSelectedItem().toString();
				
				// we also need to convert our cost into a float
				float cost = 0;
				if (costtextView.getText().toString().matches("")) {
					// do nothing 
				} else {
					cost = Float.valueOf(costtextView.getText().toString());
				}
				
				// now we can add a new item into our list
				eil.addExpenseItem(new ExpenseItem(nametextView.getText().toString(), datetextView.getText().toString(), Category, 
						descriptiontextView.getText().toString(), Currency, cost));
				
				// we also want to add a cost and type of currency to our totalcurrency class
				// first we call our TotalCurrencyController
				TotalCurrencyController tcc = new TotalCurrencyController();
				// now we add to it
				tcc.addTotalCurrency(new TotalCurrency(cost, Currency));
			}
		});
		}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		return true;
		}
	
}
