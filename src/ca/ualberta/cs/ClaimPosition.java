package ca.ualberta.cs;

/* This class is essentially used to get the position from the claim list view
  and then it will allow other classes who need that position to be able to use it
 */
public class ClaimPosition {
	
	protected static int position;
	
	public ClaimPosition(int position) {
		ClaimPosition.position = position;
	}
	
	public static int getPosition() {
		return position;
	}

}
