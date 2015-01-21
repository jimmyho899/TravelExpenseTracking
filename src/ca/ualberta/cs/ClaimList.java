package ca.ualberta.cs;

import java.util.ArrayList;
import java.util.Collection;


public class ClaimList {

	protected ArrayList<Claim> claimList;

	public ClaimList(){	
		claimList = new ArrayList<Claim>();
	}
	
	public Collection<Claim> getClaims() {
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
