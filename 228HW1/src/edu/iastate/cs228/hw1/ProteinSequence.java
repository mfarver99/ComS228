package edu.iastate.cs228.hw1;

/*
 * @author
*/

public class ProteinSequence extends Sequence
{
  public ProteinSequence(char[] psarr)
  {
	  super(psarr);
  }

  @Override
  public boolean isValidLetter(char aa)
  {
	  String letters = "BbJjOoUuXxZz";
		if (!(letters.indexOf(aa) < 0)) {
			return false;
		}
		return true; 
  }
}
