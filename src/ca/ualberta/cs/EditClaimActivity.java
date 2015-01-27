package ca.ualberta.cs;

import java.util.ArrayList;
import java.util.Collection;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
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
		EditText textView = (EditText) findViewById(R.id.editnameOfClaim);
		
		// this code will get the position and then fill out the edit text with the old name 
		int setposition = ClaimPosition.getPosition();
		textView.setText(list.get(setposition).toString());
		
	}
	
	public void doneEditClaimAction (View v) {
		Toast.makeText(this, "Updated claim!", Toast.LENGTH_SHORT).show();
		
		// retrieve the new name of the claim and now we want to update it
		// textView gets the new id of the new name of the claim
		EditText textView = (EditText) findViewById(R.id.editnameOfClaim);
		
		// call our claim class through claims and list
		Collection<Claim> claims = ClaimListController.getClaimList().getClaims();
		ArrayList<Claim> list = new ArrayList<Claim>(claims);
		// call our position from our ClaimPosition class
		int setposition = ClaimPosition.getPosition();
		
		// now we use our modifyName method in the Claim class with our called objects
		// this will change the claim in the claim list at set position to another name
		((Claim) list.get(setposition)).modifyName(textView.getText().toString());
		
		// now we want to update our list view so we need to notify our listeners
		ClaimListController cl = new ClaimListController();
		cl.edittedClaims();
	}

	
}
