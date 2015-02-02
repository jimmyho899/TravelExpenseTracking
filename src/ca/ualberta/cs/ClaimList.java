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
import java.util.Collection;
import java.io.Serializable;

// this class is used to access our list of claims
public class ClaimList implements Serializable {

	private static final long serialVersionUID = 1155703775532352548L;
	protected ArrayList<Claim> claimList = null;
	protected ArrayList<Listener> listeners;

	public ClaimList(){	
		// create a new claim list 
		claimList = new ArrayList<Claim>();
		listeners = new ArrayList<Listener>();
	}
	
	public Collection<Claim> getClaims() {
		// return the collection of our claims
		return claimList;
	}

	// add a claim to our list of claims
	public void addClaim(Claim testClaim) {		
		claimList.add(testClaim);	
		// notify to update other things that we have new things
		notifyListeners();
	}

	// delete a claim from the claim list
	public void deleteClaim(Claim testClaim) {		
		claimList.remove(testClaim);	
		notifyListeners();
	}
	
	// update our listeners whenever we edit our claim
	public void edittedClaim() {
		notifyListeners();
	}
	
	// return the size of the claim list
	public int size(){	
		return claimList.size();		
	}

	// check to see if testClaim is in claim list
	public boolean contains(Claim testClaim) {
		return claimList.contains(testClaim);
	}
	
	public Claim chooseClaim() throws EmptyClaimListException {
		int size = claimList.size();
		// if the size is less than 0 then it is empty
		if (size <= 0) {
			throw new EmptyClaimListException();
		}
		// return the item of claimList
		int index = 0;
		return claimList.get(index);
	}
	
	// code below and on listeners taken from abram hindle tutorial video https://www.youtube.com/watch?v=7zKCuqScaRE Jan 16/15
	public void notifyListeners() {
		for (Listener listener: listeners) {
			listener.update();
		}
	}
	
	public void addListener(Listener l) {
		listeners.add(l);
	}
	
	public void removeListener (Listener l) {
		listeners.remove(l);
	}
	
}
