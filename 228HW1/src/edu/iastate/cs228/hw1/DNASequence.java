package edu.iastate.cs228.hw1;

/*
 * @author
*/

public class DNASequence extends Sequence {
	public DNASequence(char[] dnaarr) {
		super(dnaarr);
	}

	@Override
	public boolean isValidLetter(char let) {
		String letters = "aAcCgGtT";
		if (letters.indexOf(let) < 0) {
			return false;
		}
		return true;
	}

	public char[] getReverseCompSeq() {
		//String revSeq = new StringBuffer(seqarr.toString()).reverse().toString();
		char[] tempSeq = seqarr;
		char[] revCompSeq = new char[seqarr.length];
		for (int i = 0; i < tempSeq.length; i++){
			revCompSeq[i] = tempSeq[tempSeq.length-1-i];
		}
		//char[] revCompSeq = revSeq.toCharArray();
		for (int i = 0; i < revCompSeq.length; i++) {
			switch (revCompSeq[i]) {
			case 'a':
				revCompSeq[i] = 't';
				break;
			case 'A':
				revCompSeq[i] = 'T';
				break;
			case 'c':
				revCompSeq[i] = 'g';
				break;
			case 'C':
				revCompSeq[i] = 'G';
				break;
			case 'g':
				revCompSeq[i] = 'c';
				break;
			case 'G':
				revCompSeq[i] = 'C';
				break;
			case 't':
				revCompSeq[i] = 'a';
				break;
			case 'T':
				revCompSeq[i] = 'A';
				break;
			}
		}
		
		return revCompSeq;
	}

	public void reverseComplement() {
		char[] temparr = getReverseCompSeq();
		seqarr = temparr;
	}
}
