package ca.ualberta.cs;

public class Claim {
	
	protected String claimName;

	public Claim(String claimName) {
		this.claimName = claimName;
	}

	public String getName() {
		return this.claimName;
	}
	
}
