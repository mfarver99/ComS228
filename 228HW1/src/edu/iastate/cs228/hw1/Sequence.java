package edu.iastate.cs228.hw1;

/*
 * @author
*/

public class Sequence {
	public char[] seqarr; // made public instead of protected for grading.
	

	public Sequence(char[] sarr) {
		
		// Loops through seqarr to make sure each letter is valid.
		for (int i = 0; i < sarr.length; i++) 
		{
			if (isValidLetter(sarr[i]) == false) {
				throw new IllegalArgumentException("Invalid sequence letter for class " + this.getClass().getSimpleName());
			}
		}
		
		seqarr = sarr;
	}

	public int seqLength() {
		return seqarr.length;
	}

	public char[] getSeq() {
		char[] tempSeqarr = seqarr;
		return tempSeqarr;
	}

	public String toString() {
		return seqarr.toString();
	}

	public boolean equals(Object obj)
  { 

		//  Checks if obj is null.
		if (obj.getClass() == null) {
			return false;
		}
		
		//  Checks if obj and this represent the same sequence, returns false if not equal.
		if (obj.toString().equalsIgnoreCase(this.toString()) == false) {
			return false;
		}

		return true;
	}

	public boolean isValidLetter(char let) {
		if ((Character.isLowerCase(let) == true) || (Character.isUpperCase(let) == true)) {
			return true;
		}
		return false;
	}

}
