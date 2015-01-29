package ca.ualberta.cs;
/* This class is essentially used to get the position from the item list view
and then it will allow other classes who need that position to be able to use it
*/
public class ItemPosition {
	protected static int position;
	
	public ItemPosition(int position) {
		this.position = position;
	}
	
	public static int getPosition() {
		return position;
	}
}
