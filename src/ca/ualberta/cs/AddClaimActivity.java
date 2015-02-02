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

import android.app.Activity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Date;
import java.io.Serializable;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class AddClaimActivity extends Activity {
	
	private static final String FILENAME = "Claims.sav";
	private ArrayList<Claim> claims;
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		// set up our add_claim ui screen
		setContentView(R.layout.add_claim);
		
		Button doneButton = (Button) findViewById(R.id.doneButton);
		doneButton.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// Test text "Added claim!"
				Toast.makeText(AddClaimActivity.this, "Added claim!", Toast.LENGTH_SHORT).show();
				
				// initialize a ClaimListController where we can then 
				ClaimListController cl = new ClaimListController();
				
				// extract our name of the claim from the edit text and add it to our claim list
				EditText nametextView = (EditText) findViewById(R.id.nameOfClaim);
				EditText starttextView = (EditText) findViewById(R.id.startDate);
				EditText endtextView = (EditText) findViewById(R.id.endDate);
				EditText detailstextView = (EditText) findViewById(R.id.descriptionText);
				cl.addClaim(new Claim(nametextView.getText().toString(), starttextView.getText().toString(), 
						endtextView.getText().toString(), detailstextView.getText().toString()));
				
				claims = (ArrayList<Claim>) cl.getClaimList().getClaims();
				// now we want to save our claim into a file
				try {
					Gson gson = new Gson();
					FileOutputStream fos = openFileOutput(FILENAME, 0);
					OutputStreamWriter osw = new OutputStreamWriter(fos);
					gson.toJson(claims, osw);
					osw.flush();
					fos.close();
				} catch (FileNotFoundException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		});
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
