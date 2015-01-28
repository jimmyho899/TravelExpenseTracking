package ca.ualberta.cs;

public class ClaimListController {
	
	// 
	private static ClaimList claimList = null;
	
	static public ClaimList getClaimList() {
		// if it is empty create a new ClaimList
		if (claimList == null) {
			claimList = new ClaimList();
		}
		
		return claimList;
	}
	
	// 
	public Claim chooseClaim() throws EmptyClaimListException {
		return getClaimList().chooseClaim();
	}
	
	// this adds a claim to our claim list
	public void addClaim(Claim claim) {
		getClaimList().addClaim(claim);
	}

	// this is used to notify our listeners
	public void edittedClaims() {
		getClaimList().edittedClaim();
	}
	

	
}
