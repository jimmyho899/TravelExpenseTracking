/*
    Travel Expense App: Keeps track of money spent on trips
    
    Copyright (C) 2015 Jimmy Ho jph@ualberta.ca

    This program is free software: you can redistribute it and/or modify
    it under the terms of the GNU General Public License as published by
    the Free Software Foundation, either version 3 of the License, or
    (at your option) any later version.

    This program is distributed in the hope that it will be useful,
    but WITHOUT ANY WARRANTY; without even the implied warranty of
    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
    GNU General Public License for more details.

    You should have received a copy of the GNU General Public License
    along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

package ca.ualberta.cs;

import java.util.ArrayList;

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
