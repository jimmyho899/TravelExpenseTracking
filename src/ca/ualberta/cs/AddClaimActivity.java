package ca.ualberta.cs;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;


public class AddClaimActivity extends Activity {
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		// set up our add_claim ui screen
		setContentView(R.layout.add_claim);
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.add_claim, menu);
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
	
	// on click of the done button in add_claim
	public void doneClaimAction(View v) {
		// Test text "Added claim!"
		Toast.makeText(this, "Added claim!", Toast.LENGTH_SHORT).show();
		
		// initialize a ClaimListController where we can then 
		ClaimListController cl = new ClaimListController();
		
		// extract our name of the claim from the edit text and add it to our claim list
		EditText nametextView = (EditText) findViewById(R.id.nameOfClaim);
		EditText starttextView = (EditText) findViewById(R.id.startDate);
		EditText endtextView = (EditText) findViewById(R.id.endDate);
		EditText detailstextView = (EditText) findViewById(R.id.descriptionText);
		cl.addClaim(new Claim(nametextView.getText().toString(), starttextView.getText().toString(), 
				endtextView.getText().toString(), detailstextView.getText().toString()));
		
	}
}
