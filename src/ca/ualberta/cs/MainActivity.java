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

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;


public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        loadListView();
    }

	private void loadListView() {
        // update our list view to contain items in our list so that it shows on screen
        ListView listView = (ListView) findViewById(R.id.claimListView);
        Collection<Claim> claims = ClaimListController.getClaimList().getClaims();
        // not going to change after b/c it is final
        final ArrayList<Claim> list = new ArrayList<Claim>(claims);
        final ArrayAdapter<Claim> claimAdapter = new ArrayAdapter<Claim>(this, 
        		android.R.layout.simple_list_item_1, list);
        listView.setAdapter(claimAdapter);
        
        // now we will update so that our adapter knows that it needs to display new items
        // observer pattern. whenever claim list changes we update
        ClaimListController.getClaimList().addListener(new Listener() {
        	public void update() {
        		list.clear();
        		Collection<Claim> claims = ClaimListController.getClaimList().getClaims();
        		list.addAll(claims);
        		claimAdapter.notifyDataSetChanged();
        	}
        });
        
        // now we want an option to delete the claim on the list
        // we will delete a claim with prompt user if the user holds on a claim
        // based on Abram Hindle Student Picker https://www.youtube.com/watch?v=7zKCuqScaRE
        listView.setOnItemLongClickListener(new OnItemLongClickListener() {
			@Override
			public boolean onItemLongClick(AdapterView<?> adapterView, View view, 
					final int position, long id) {
				AlertDialog.Builder adb = new AlertDialog.Builder(MainActivity.this);
				adb.setMessage("Edit/Delete "+list.get(position).toString()+"?");
				adb.setCancelable(true);
				final int finalPosition = position;
				adb.setPositiveButton("Delete", new OnClickListener() {
					public void onClick(DialogInterface dialog, int which) {
						AlertDialog.Builder adb2 = new AlertDialog.Builder(MainActivity.this);
						adb2.setMessage("Delete "+list.get(position).toString()+"?");
						adb2.setCancelable(true);
						final int finalPosition = position;
						adb2.setPositiveButton("Yes", new OnClickListener() {
							public void onClick(DialogInterface dialog, int which) {
								Claim claim = list.get(finalPosition);
								ClaimListController.getClaimList().deleteClaim(claim);
							}
						});
						adb2.setNegativeButton("No", new OnClickListener() {
							public void onClick (DialogInterface dialog, int which) {
							}
						});
						adb2.show();
					}
				});
				adb.setNegativeButton("Edit", new OnClickListener() {
					public void onClick (DialogInterface dialog, int which) {
						Intent intent = new Intent(MainActivity.this, EditClaimActivity.class);
						//intent.putExtra("test",  )
				    	startActivity(intent);
					}
				});
				adb.show();
				return false;
			}
        }); 
        
        // now we want to be able to click a claim to go to a list of items
        listView.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> adapterView, View view,
					int position, long id) {
				Intent intent = new Intent(MainActivity.this, ListItemsActivity.class);
				startActivity(intent);
			}
        	
        });
	}
	
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
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
    
    // our add claim from our menu drop
    public void addaClaim(MenuItem menu) {
    	Toast.makeText(this, "Add Claim", Toast.LENGTH_SHORT).show();
    	// make an intent which will then go to our AddClaimActivity class
    	Intent intent = new Intent(MainActivity.this, AddClaimActivity.class);
    	startActivity(intent);
    }
    
    public void emailClaim(MenuItem menu) {
    	Toast.makeText(this, "Email Claim", Toast.LENGTH_SHORT).show();
    	
    }

}
