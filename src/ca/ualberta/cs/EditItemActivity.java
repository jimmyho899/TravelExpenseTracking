package ca.ualberta.cs;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class EditItemActivity extends Activity {

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super .onCreate(savedInstanceState);
		// set up our layout to be edit_claim
		setContentView(R.layout.edit_item);
	}
	
	public void doneEditItemAction (View v) throws java.text.ParseException {
		Toast.makeText(this, "Updated Item!", Toast.LENGTH_SHORT).show();
	}
}
