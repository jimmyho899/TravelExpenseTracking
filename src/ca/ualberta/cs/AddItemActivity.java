package ca.ualberta.cs;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class AddItemActivity extends Activity {
	
	public Spinner spinnerCategory;
	public Spinner spinnerCurrency;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		// set up our add_claim ui screen
		setContentView(R.layout.add_item);
		}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		return true;
		}
	
	public void doneItemAction(View v) {
		Toast.makeText(this, "Added Item!", Toast.LENGTH_SHORT).show();
		
		// reference our spinner from our xml
		spinnerCategory = (Spinner)findViewById(R.id.itemCategory);
		spinnerCurrency = (Spinner)findViewById(R.id.itemCurrency);
		
		// get our item from the spinners
		String Category = spinnerCategory.getSelectedItem().toString();
		String Currency = spinnerCurrency.getSelectedItem().toString();
		
	}
}
