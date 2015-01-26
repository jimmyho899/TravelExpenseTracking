package ca.ualberta.cs;

public class ClaimPosition {
	
	protected static int position;
	
	public ClaimPosition(int position) {
		this.position = position;
	}
	
	public static int getPosition() {
		return position;
	}

}
