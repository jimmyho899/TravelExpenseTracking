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
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super .onCreate(savedInstanceState);
		setContentView(R.layout.edit_claim);
		Collection<Claim> claims = ClaimListController.getClaimList().getClaims();
		ArrayList<Claim> list = new ArrayList<Claim>(claims);
		EditText textView = (EditText) findViewById(R.id.editnameOfClaim);
		// need some way to get the position from the MainActivity. currently set at 0
		int test = ClaimPosition.getPosition();
		textView.setText(list.get(test).toString());
		
	}
	
	public void doneEditClaimAction (View v) {
		Toast.makeText(this, "Updated claim!", Toast.LENGTH_SHORT).show();
		
		
	}

	
}
