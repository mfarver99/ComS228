package edu.iastate.cs228.hw1;

/*
 * @author
*/

public class CodingDNASequence extends DNASequence
{
  public CodingDNASequence(char[] cdnaarr)
  {
    super(cdnaarr);
  }

  public boolean checkStartCodon()
  {
    if (seqarr.length < 3)
    {
    	return false;
    }
    
    char[] temp = {seqarr[0], seqarr[1], seqarr[2]};
    // char[] startCheck = {'A','T','G'};
    String aLetters = "Aa";
    String tLetters = "Tt";
    String gLetters = "Gg";
    
    if (aLetters.indexOf(temp[0]) >= 0) {
		return true;
	}
    
    if (tLetters.indexOf(temp[1]) >= 0) {
		return true;
	}
    
    if (gLetters.indexOf(temp[2]) >= 0) {
		return true;
	}
    
    return false;
  }

  public char[] translate()
  {
    if (!checkStartCodon())
    {
    	throw new RuntimeException("No start codon");
    }
    
    char[] acidarr = new char[(seqarr.length + 2) / 3];
    int m = 0;  //counter
    int p = 0;  //counter
    
    String tempSeq = String.valueOf(seqarr);
    
    do
    {
    	acidarr[p] = getAminoAcid(tempSeq.substring(m, m + 3));
    	m += 3;
    	p++;
    } while (m+3 <= seqarr.length);
    
    if (tempSeq.length() / 3 != 0){
    	acidarr[acidarr.length-1] = '$';
    }
    
    return acidarr;
  }

  private char getAminoAcid(String codon)
  {	
    if ( codon == null ) return '$';
    char aa = '$';
    switch ( codon.toUpperCase() )
    {
      case "AAA": aa = 'K'; break;
      case "AAC": aa = 'N'; break;
      case "AAG": aa = 'K'; break;
      case "AAT": aa = 'N'; break;

      case "ACA": aa = 'T'; break;
      case "ACC": aa = 'T'; break;
      case "ACG": aa = 'T'; break;
      case "ACT": aa = 'T'; break;

      case "AGA": aa = 'R'; break;
      case "AGC": aa = 'S'; break;
      case "AGG": aa = 'R'; break;
      case "AGT": aa = 'S'; break;

      case "ATA": aa = 'I'; break;
      case "ATC": aa = 'I'; break;
      case "ATG": aa = 'M'; break;
      case "ATT": aa = 'I'; break;

      case "CAA": aa = 'Q'; break;
      case "CAC": aa = 'H'; break;
      case "CAG": aa = 'Q'; break;
      case "CAT": aa = 'H'; break;

      case "CCA": aa = 'P'; break;
      case "CCC": aa = 'P'; break;
      case "CCG": aa = 'P'; break;
      case "CCT": aa = 'P'; break;

      case "CGA": aa = 'R'; break;
      case "CGC": aa = 'R'; break;
      case "CGG": aa = 'R'; break;
      case "CGT": aa = 'R'; break;

      case "CTA": aa = 'L'; break;
      case "CTC": aa = 'L'; break;
      case "CTG": aa = 'L'; break;
      case "CTT": aa = 'L'; break;

      case "GAA": aa = 'E'; break;
      case "GAC": aa = 'D'; break;
      case "GAG": aa = 'E'; break;
      case "GAT": aa = 'D'; break;

      case "GCA": aa = 'A'; break;
      case "GCC": aa = 'A'; break;
      case "GCG": aa = 'A'; break;
      case "GCT": aa = 'A'; break;

      case "GGA": aa = 'G'; break;
      case "GGC": aa = 'G'; break;
      case "GGG": aa = 'G'; break;
      case "GGT": aa = 'G'; break;

      case "GTA": aa = 'V'; break;
      case "GTC": aa = 'V'; break;
      case "GTG": aa = 'V'; break;
      case "GTT": aa = 'V'; break;

      case "TAA": aa = '$'; break;
      case "TAC": aa = 'Y'; break;
      case "TAG": aa = '$'; break;
      case "TAT": aa = 'Y'; break;

      case "TCA": aa = 'S'; break;
      case "TCC": aa = 'S'; break;
      case "TCG": aa = 'S'; break;
      case "TCT": aa = 'S'; break;

      case "TGA": aa = '$'; break;
      case "TGC": aa = 'C'; break;
      case "TGG": aa = 'W'; break;
      case "TGT": aa = 'C'; break;

      case "TTA": aa = 'L'; break;
      case "TTC": aa = 'F'; break;
      case "TTG": aa = 'L'; break;
      case "TTT": aa = 'F'; break;
      default:    aa = '$'; break;
    }
    return aa;
  }
}
