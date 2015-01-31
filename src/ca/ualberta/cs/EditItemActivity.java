package ca.ualberta.cs;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class EditItemActivity extends Activity {

	public Spinner spinnerCategory;
	public Spinner spinnerCurrency;
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super .onCreate(savedInstanceState);
		// set up our layout to be edit_item
		setContentView(R.layout.edit_item);
		
		// call our ExpenseItem list of ExpenseItems with items and list
        int position = ClaimPosition.getPosition();
        Collection<Claim> claims = ClaimListController.getClaimList().getClaims();
		ArrayList<Claim> alist = new ArrayList<Claim>(claims);
		
		Collection<ExpenseItem> items = alist.get(position).getController().getExpenseItemList().getExpenseItem();
		ArrayList<ExpenseItem> list = new ArrayList<ExpenseItem>(items);
		
		// get the id of our name edit text that we will update with a new name
		// we will also the our other texts as well 
		EditText nametextView = (EditText) findViewById(R.id.editnameOfItem);
		EditText datetextView = (EditText) findViewById(R.id.edititemDate);
		EditText costtextView = (EditText) findViewById(R.id.edititemCost);
		EditText descriptiontextView = (EditText) findViewById(R.id.edititemDescription);
		
		// reference our spinner from our xml
		spinnerCategory = (Spinner)findViewById(R.id.edititemCategory);
		spinnerCurrency = (Spinner)findViewById(R.id.edititemCurrency);
		
		// this code will get the position and then fill out the edit text with the old name
		// the old start date, old end date, and old details
		int setposition = ItemPosition.getPosition();
		nametextView.setText(list.get(setposition).toString());
		// set a date format, the same as before
		SimpleDateFormat fmt = new SimpleDateFormat("yyyy/mm/dd");
		datetextView.setText(fmt.format(list.get(setposition).toDateString()));
		costtextView.setText(Float.toString(list.get(setposition).toCostString()));
		descriptiontextView.setText(list.get(setposition).toDescriptionString());
		
		// now we need a way to get the old spinner positions
		spinnerCategory.setSelection(getIndex(spinnerCategory, list.get(setposition).toCategoryString()));
		spinnerCurrency.setSelection(getIndex(spinnerCurrency, list.get(setposition).toCurrencyString()));
		
		// now we will find our id for the done button and the following code will run once the user hits the done button
		Button doneButton = (Button) findViewById(R.id.doneeditItem);
		doneButton.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				Toast.makeText(EditItemActivity.this, "Updated Item!", Toast.LENGTH_SHORT).show();
				
				// call our EditTexts and spinners for the new user values 
				EditText nametextView = (EditText) findViewById(R.id.editnameOfItem);
				EditText datetextView = (EditText) findViewById(R.id.edititemDate);
				EditText costtextView = (EditText) findViewById(R.id.edititemCost);
				EditText descriptiontextView = (EditText) findViewById(R.id.edititemDescription);
				spinnerCategory = (Spinner)findViewById(R.id.edititemCategory);
				spinnerCurrency = (Spinner)findViewById(R.id.edititemCurrency);
				String Category = spinnerCategory.getSelectedItem().toString();
				String Currency = spinnerCurrency.getSelectedItem().toString();
				// we also need to convert our cost into a float
				float cost = 0;
				if (costtextView.getText().toString().matches("")) {
					// do nothing 
				} else {
					cost = Float.valueOf(costtextView.getText().toString());
				}
				
				// call our position from our ItemPosition class
				int setposition = ItemPosition.getPosition();
				
				// call our Expense item list so that we can update items on it
				Collection<Claim> claims = ClaimListController.getClaimList().getClaims();
				ArrayList<Claim> alist = new ArrayList<Claim>(claims);
				int position = ClaimPosition.getPosition();
				
				Collection<ExpenseItem> items = ExpenseItemListController.getExpenseItemList().getExpenseItem();
				ArrayList<ExpenseItem> list = alist.get(position).getItemArray();
				
				// now we use our modifyName method in the ExpenseItem class
				// this will change the already existing information with new ones using our modify methods
				((ExpenseItem) list.get(setposition)).modifyName(nametextView.getText().toString());
				
				SimpleDateFormat fmt = new SimpleDateFormat("yyyy/mm/dd");
				try {
					((ExpenseItem) list.get(setposition)).modifyDate(fmt.parse(datetextView.getText().toString()));
				} catch (ParseException e) {
					e.printStackTrace();
				}
				((ExpenseItem) list.get(setposition)).modifyItemDescription(descriptiontextView.getText().toString());
				
				list.get(setposition).modifyItemCategory(Category);
				list.get(setposition).modifyItemCurrency(Currency);
				list.get(setposition).modifyItemCost(cost);
					
				// now we want to update our list view so we need to notify our listeners
				ExpenseItemListController eil = new ExpenseItemListController();
				eil.edittedExpenseItem();
				
				// now we want to update our total currency list as well
				Collection<TotalCurrency> total = TotalCurrencyController.getTotalCurrencyList().getTotalCurrency();
				ArrayList<TotalCurrency> clist = new ArrayList<TotalCurrency>(total);
				
				clist.get(setposition).modifyCost(cost);
				clist.get(setposition).modifyCurrency(Currency);
			}
		});
	}

	// this code is taken from http://stackoverflow.com/questions/8769368/how-to-set-position-in-spinner
	private int getIndex(Spinner spinner, String myString) {
		
		int index = 0;
		
		for (int i=0;i<spinner.getCount();i++) {
			if (spinner.getItemAtPosition(i).equals(myString)) {
				index = i;
			}
		}
		return index;
	}
}
