package ca.ualberta.cs;

import java.util.ArrayList;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class AddClaimActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.add_claim);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.add_claim, menu);
		doneButton();
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
	
	private void doneButton() {
		Button doneButton = (Button) findViewById(R.id.doneButton);
		final EditText claimName = (EditText) findViewById(R.id.nameOfClaim);
		doneButton.setOnClickListener(new View.OnClickListener() {
			
			public void onClick(View v) {
				Toast.makeText(AddClaimActivity.this, "Added Claim", Toast.LENGTH_SHORT).show();
				Claim nameofclaim = new Claim(claimName.getText().toString());
				
				ArrayList<Claim> listofclaims = ClaimList.getClaims();
				listofclaims.add(nameofclaim);
				
				
				ListView displayclaims = (ListView) findViewById(R.id.claimListView);
				ArrayAdapter<Claim> adapter = new MyListAdapter();
				displayclaims.setAdapter(adapter);
			}
		});
		
	}
	
	private class MyListAdapter extends ArrayAdapter<Claim> {
		public MyListAdapter() {
			
			super(AddClaimActivity.this, R.layout.add_claim, ClaimList.getClaims());
		}

		@Override
		public View getView(int position, View convertView, ViewGroup parent) {
			View itemView = convertView;
			if (itemView == null) {
				itemView = getLayoutInflater().inflate(R.layout.activity_main, parent, false);
			}
			
			TextView nameText = (TextView) itemView.findViewById(R.id.nameOfClaim);
			nameText.setText(Claim.getName().toString());
			
			return itemView;
		}
		
		
	}
	
}
