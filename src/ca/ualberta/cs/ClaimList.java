package ca.ualberta.cs;

import java.util.ArrayList;


public class ClaimList {

	protected static ArrayList<Claim> claimList;

	public ClaimList(){	
		claimList = new ArrayList<Claim>();
	}
	
	public static ArrayList<Claim> getClaims() {
		return claimList;
	}

	public void addClaim(Claim testClaim) {		
		claimList.add(testClaim);		
	}

	public void deleteClaim(Claim testClaim) {		
		claimList.remove(testClaim);	
	}
	
	public int size(){	
		return claimList.size();		
	}

	public boolean contains(Claim testClaim) {
		return claimList.contains(testClaim);
	}
	
	

}
