package edu.iastate.cs228.hw1;

/*
 * @author
*/

public class GenomicDNASequence extends DNASequence {
	public boolean[] iscoding; // made public instead of private for grading.

	public GenomicDNASequence(char[] gdnaarr) {
		super(gdnaarr);
		iscoding = new boolean[gdnaarr.length];
		for (int i = 0; i < iscoding.length; i++) {
			iscoding[i] = false;
		}

	}

	public void markCoding(int first, int last) {
		int slen = seqLength();
		int dupFirst = first;
		int dupLast = last;
		if ((first < 0) || (last < 0) || (first >= slen) || (last >= slen)) {
			throw new IllegalArgumentException("Coding border is out of bound");
		}

		if (first > last) {
			dupFirst = slen - 1 - first;
			dupLast = slen - 1 - last;
			reverseComplement();
			for (int i = dupFirst; i <= dupLast; i++) {
				iscoding[i] = true;
			}
		}
	}

	public char[] extractExons(int[] exonpos)
  {
    if ((exonpos.length == 0) || ((exonpos.length / 2) == 1))
    {
    	throw new IllegalArgumentException("Empty array or odd number of array elements");
    }
    
    int start = exonpos[0];
    int end = exonpos[exonpos.length - 1];
    
    for (int p = start; p <= end; p++){
    	iscoding[p] = true;
    }
    for (int i = 0; i < exonpos.length; i++)
    {
    	if (exonpos[i] < 0 || exonpos[i] > seqLength())
    	{
    		throw new IllegalArgumentException("Exon position is out of bound");
    	}
    	
    	if (i + 1 < exonpos.length)
    	{
    		if (exonpos[i] > exonpos[i+1])
    		{
    			throw new IllegalArgumentException("Exon positions are not in order");
    		}
    	}
    	
    }
    
    for (int p = start; p <= end; p++){
    	if (iscoding[p] == false)
    	{
    		throw new  IllegalArgumentException("Noncoding position is found");
    	}
    }
    
    int len = 0;
    for (int i = 0; i < exonpos.length; i+=2)
    {
    	len += (exonpos[i+1] - exonpos[i]) + 1;
    }
    
    //  Length of the exon array.
    
    char[] exonarr = new char [len];
    int p = 0;  //counter
    //  Loops by twos through the position array.
    for (int i = 0; i < exonpos.length; i+=2)
    {
    	int n = exonpos[i];
    	
    	while(n <= exonpos[i+1])
    	{
    		exonarr[p] = seqarr[n];
    		n++;
    		p++;
    	}
    }
    
    return exonarr;
  }

}
