package ca.ualberta.cs;

import java.util.ArrayList;
import java.util.Collection;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemLongClickListener;

public class ListItemsActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.list_items);
		
		// now we want to load a list of expense items if there is any
		loadListView();
	}

	private void loadListView() {
        // update our list view to contain items in our list so that it shows on screen
        ListView listView = (ListView) findViewById(R.id.ItemListView);
        Collection<ExpenseItem> items = ExpenseItemListController.getExpenseItemList().getExpenseItem();
      
        int setposition = ClaimPosition.getPosition();
        Collection<Claim> claims = ClaimListController.getClaimList().getClaims();
		ArrayList<Claim> alist = new ArrayList<Claim>(claims);
		
        // not going to change after b/c it is final
        final ArrayList<ExpenseItem> list = alist.get(setposition).getItemArray();
        final ArrayAdapter<ExpenseItem> itemAdapter = new ArrayAdapter<ExpenseItem>(this, 
        		android.R.layout.simple_list_item_1, list);
        listView.setAdapter(itemAdapter);
        
        // now we will update so that our adapter knows that it needs to display new items
        // observer pattern. whenever claim list changes we update
        ExpenseItemListController.getExpenseItemList().addListener(new Listener() {
        	public void update() {
        		list.clear();
        		Collection<ExpenseItem> items = ExpenseItemListController.getExpenseItemList().getExpenseItem();
        		list.addAll(items);
        		itemAdapter.notifyDataSetChanged();
        	}
        });
        
        listView.setOnItemLongClickListener(new OnItemLongClickListener() {
			@Override
			public boolean onItemLongClick(AdapterView<?> adapterView, View view, 
					final int position, long id) {
				// create a message when the user long clicks
				AlertDialog.Builder adb = new AlertDialog.Builder(ListItemsActivity.this);
				adb.setMessage("Edit/Delete "+list.get(position).toString()+"?");
				adb.setCancelable(true);
				
				// now we set two options, one for edit and one for delete
				adb.setPositiveButton("Delete", new OnClickListener() {
					public void onClick(DialogInterface dialog, int which) {
						
						// now we set another two options, one to confirm the delete and another to deny
						AlertDialog.Builder adb2 = new AlertDialog.Builder(ListItemsActivity.this);
						adb2.setMessage("Delete "+list.get(position).toString()+"?");
						adb2.setCancelable(true);
						final int finalPosition = position;
						adb2.setPositiveButton("Yes", new OnClickListener() {
							// if user presses yes, then we will delete that claim in the claim list
							public void onClick(DialogInterface dialog, int which) {
								ExpenseItem item = list.get(finalPosition);
								ExpenseItemListController.getExpenseItemList().deleteExpenseItem(item);
								// we also need to delete the entry from the total currency list
								Collection<TotalCurrency> citems = TotalCurrencyController.getTotalCurrencyList().getTotalCurrency();
								ArrayList<TotalCurrency> clist = new ArrayList<TotalCurrency>(citems);
								TotalCurrency amount = clist.get(finalPosition);
								TotalCurrencyController.getTotalCurrencyList().removeTotalCurrency(amount);
							}
						});
						adb2.setNegativeButton("No", new OnClickListener() {
							// if user presses no we will not delete it and do nothing
							public void onClick (DialogInterface dialog, int which) {
							}
						});
						// adb2.show in order to show our message of Delete Y/N?
						adb2.show();
					}
				});
				adb.setNegativeButton("Edit", new OnClickListener() {
					public void onClick (DialogInterface dialog, int which) {
						// create a new intent to go to another class and layout 
						Intent intent = new Intent(ListItemsActivity.this, EditItemActivity.class);
						// set position is what will be used to let other classes know which position
						// in the list view that the item was pressed on
						new ItemPosition(position);
				    	startActivity(intent);
					}
				});
				// adb.show() to show our edit/delete option message
				adb.show();
				return false;
			}
        });     
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.list_items, menu);
		return true;
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
	
	public void addExpenseItem(MenuItem menu) {
		Toast.makeText(this, "Add Expense Item", Toast.LENGTH_SHORT).show();
		// we want to now change screens so that we can add an expense item
		Intent intent = new Intent(ListItemsActivity.this, AddItemActivity.class);
    	startActivity(intent);
	}
	
	public void gotoSummary(MenuItem menu) {
		Toast.makeText(this, "Summary of Claim", Toast.LENGTH_SHORT).show();
		// now we want to go to the summary activity 
		Intent intent = new Intent(ListItemsActivity.this, SummaryActivity.class);
		startActivity(intent);
	}
	
	
	
	
}
