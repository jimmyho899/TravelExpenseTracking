package ca.ualberta.cs;

public class Claim {
	
	protected String claimName;
	/*
	private int startyear;
	private int startmonth; 
	private int startday;
	private int endyear; 
	private int endmonth; 
	private int endday;
	*/

	public Claim(String claimName) {
		this.claimName = claimName;
		/*
		this.startyear = startyear;
		this.startmonth = startmonth;
		this.startday = startday;
		this.endyear = endyear;
		this.endmonth = endmonth;
		this.endday = endday;
		*/
	}

	public String getName() {
		return this.claimName;
	}
	
	public String toString() {
		return getName();
	}
	
}
