package ca.ualberta.cs;

import java.util.ArrayList;


public class ClaimList {

	protected ArrayList<Claim> claimList = null;

	public ClaimList(){	
		claimList = new ArrayList<Claim>();
	}
	
	public ArrayList<Claim> getClaims() {
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
	
	public Claim chooseClaim() throws EmptyClaimListException {
		int size = claimList.size();
		if (size <= 0) {
			throw new EmptyClaimListException();
		}
		
		int index = 0;
		return claimList.get(index);
	}
	

}
