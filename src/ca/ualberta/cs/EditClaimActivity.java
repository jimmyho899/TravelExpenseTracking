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

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class EditClaimActivity extends Activity {
	
	// We only enter this class when the user wants to update his/her claim
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super .onCreate(savedInstanceState);
		// set up our layout to be edit_claim
		setContentView(R.layout.edit_claim);
		
		// call our claim list of claims with claims and list
		Collection<Claim> claims = ClaimListController.getClaimList().getClaims();
		ArrayList<Claim> list = new ArrayList<Claim>(claims);
		
		// get the id of our name edit text that we will update with a new name
		// we will also the our start date, end date and details from the edit text too 
		EditText nametextView = (EditText) findViewById(R.id.editnameOfClaim);
		EditText starttextView = (EditText) findViewById(R.id.editstartDate);
		EditText endtextView = (EditText) findViewById(R.id.editendDate);
		EditText detailstextView = (EditText) findViewById(R.id.editdescriptionText);
		
		// this code will get the position and then fill out the edit text with the old name
		// the old start date, old end date, and old details
		int setposition = ClaimPosition.getPosition();
		nametextView.setText(list.get(setposition).toString());
		
		SimpleDateFormat fmt = new SimpleDateFormat("yyyy/mm/dd");
		starttextView.setText(fmt.format(list.get(setposition).toStartString()));
		endtextView.setText(fmt.format(list.get(setposition).toEndString()));
		detailstextView.setText(list.get(setposition).toDetailString());
		
		Button doneButton = (Button) findViewById(R.id.editdoneButton);
		doneButton.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				Toast.makeText(EditClaimActivity.this, "Updated claim!", Toast.LENGTH_SHORT).show();
				
				// retrieve the new name of the claim and now we want to update it
				// nametextView gets the new id of the new name of the claim, starttextView for start date
				// and so on...
				EditText nametextView = (EditText) findViewById(R.id.editnameOfClaim);
				EditText starttextView = (EditText) findViewById(R.id.editstartDate);
				EditText endtextView = (EditText) findViewById(R.id.editendDate);
				EditText detailstextView = (EditText) findViewById(R.id.editdescriptionText);
				
				// call our claim class through claims and list
				Collection<Claim> claims = ClaimListController.getClaimList().getClaims();
				ArrayList<Claim> list = new ArrayList<Claim>(claims);
				// call our position from our ClaimPosition class
				int setposition = ClaimPosition.getPosition();
				
				// now we use our modifyName method in the Claim class with our called objects
				// this will change the claim in the claim list at set position to another name,
				// start date, end date, and details if the user changes them
				((Claim) list.get(setposition)).modifyName(nametextView.getText().toString());
				
				SimpleDateFormat fmt = new SimpleDateFormat("yyyy/mm/dd");
				try {
					((Claim) list.get(setposition)).modifyStartDate(fmt.parse(starttextView.getText().toString()));
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				try {
					((Claim) list.get(setposition)).modifyEndDate(fmt.parse(endtextView.getText().toString()));
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				((Claim) list.get(setposition)).modifyClaimDetails(detailstextView.getText().toString());
			
				// now we want to update our list view so we need to notify our listeners
				ClaimListController cl = new ClaimListController();
				cl.edittedClaims();

			}
		});
	}
	
}
