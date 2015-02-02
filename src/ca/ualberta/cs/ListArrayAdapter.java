package ca.ualberta.cs;

import java.util.ArrayList;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

// based from http://theopentutorials.com/tutorials/android/listview/android-custom-listview-with-image-and-text-using-arrayadapter
public class ListArrayAdapter extends ArrayAdapter<Claim> {
	
	private ArrayList<Claim> claims = null;
	
	public ListArrayAdapter(Context context, ArrayList<Claim> claims) {
		super(context, R.layout.activity_main, claims);
		
		this.claims = claims;
	}
	
	@Override
	public Claim getItem(int position) {
		return claims.get(position);
	}
	

}
