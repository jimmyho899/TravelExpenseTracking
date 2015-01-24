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

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;


public class MainActivity extends Activity {
	
	private ArrayList<Claim> listofClaims = new ArrayList<Claim>();
	

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        
        
        //adapter = new ArrayAdapter<Claim>(this, R.layout.activity_main, listofClaims);
        //clickClaimListItem();
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
    
    public void addaClaim(MenuItem menu) {
    	Toast.makeText(this, "Add Claim", Toast.LENGTH_SHORT).show();
    	Intent intent = new Intent(MainActivity.this, AddClaimActivity.class);
    	startActivity(intent);
    	
    }
    
    public void emailClaim(MenuItem menu) {
    	Toast.makeText(this, "Email Claim", Toast.LENGTH_SHORT).show();
    	
    }
    /*
    private void clickClaimListItem() {
    	ListView claimListViewItem = (ListView) findViewById(R.id.claimListView);
    	claimListViewItem.setAdapter(adapter);
    	claimListViewItem.setOnItemClickListener(new AdapterView.OnItemClickListener() {
			
			public void onClick(View v) {
				Toast.makeText(MainActivity.this, "Clicked Claim", Toast.LENGTH_SHORT).show();
				
			}

			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				// TODO Auto-generated method stub
				
			}
		});
        
    }
	*/
}
