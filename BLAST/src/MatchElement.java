import java.util.ArrayList;
/**
 * The match element class contains methods to get information regarding matches and to construct 
 * match element objects.
 * 
 * 
 * @author Jeric Derama and Olivia Kullman with assistance from Dr. Cutter and TAs
 * @version Spring 2012
 *
 */
public class MatchElement {

	//instance variables
	private ArrayList<String> extendedMatches;
	private int query;
	private int queryPosition;
	private int sequence;
	private int sequencePosition;
	private int matchLength;
	private DNASequence dna;
	
	// Constructor for MatchElement
	public MatchElement(int queryLine, int queryPos, int sequenceLine, int sequencePos, int lengthOfMatch, DNASequence dnaSequence)
	{
		//declare instance variabels
		query = queryLine;
		queryPosition = queryPos;
		sequence = sequenceLine;
		sequencePosition = sequencePos;
		matchLength = lengthOfMatch;
		dna = dnaSequence;
		extendedMatches = new ArrayList<String>();
	}
	/**
	 * Getter method for the query.
	 * @return the query.
	 */
	public int getQuery()
	{
		return query;
	}
	
	/**
	 * Getter method for the queryPosition
	 * @return the queryPostion
	 */
	public int getQueryPosition()
	{
		return queryPosition;
	}
	
	/**
	 * Getter method for the sequence
	 * @return the sequence
	 */
	public int getSequence()
	{
		return sequence;
	}
	
	/**
	 * Getter method for the sequencePostion
	 * @return the sequence position
	 */
	public int getSequencePosition()
	{
		return sequencePosition;
	}
	
	/**
	 * Getter method for the matchLength
	 * @return the matchLength
	 */
	public int getMatchLength()
	{
		return matchLength;
	}
	
	/**
	 * Getter method for the original dna sequence. 
	 * @return
	 */
	public DNASequence getDna()
	{
		return dna;
	}
	/**
	 * Prints out the information regarding this matchElement.
	 */
	public void print()
	{
		System.out.println(" " + this.getDna().getGeneralInfo() + this.getDna().getName());
		System.out.println(" " + "Query Position: " + this.getQueryPosition());
		System.out.println(" " + "In Database: " + "(" + this.getSequence() + "," + this.getSequencePosition() + ")");
		System.out.println(" " + "Length: " + this.getMatchLength());
	}
}
