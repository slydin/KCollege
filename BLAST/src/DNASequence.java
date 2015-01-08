// Class: DNASequence
// 
// Author: Jeric Derama
// 
// Created on March 29 2012


/**
 * DNASequence contains the information obtained from the DataReader class.
 * 
 * 
 * @author Jeric Derama and Olivia Kullman with assistance from Dr. Cutter and TAs
 * @version Spring 2012
 *
 *
 */


public class DNASequence 
{

	private String gi;
	private String name;
	private String sequences;
	/**
	 * Constructs an object the contains information on a known DNA sample. 
	 * @param genInfo provided by DataReader object. Initial characters in a string
	 * @param type actual name of the sample
	 * @param sequence given sequence of the sample
	 */
	public DNASequence(String genInfo, String type, String sequence ) 
	{
		this.gi = genInfo;
		this.name = type;
		this.sequences = sequence;
	}
	
	/**
	 * Getter method to access information on object. 
	 * @return a string that shows object's general info, name, and sequence.
	 */
	public String toString()
	{
		return gi + " " + name + "\n" + sequences + "\n";
	}
	
	/**
	 * Getter method for accessing object's sequence.  
	 * @return the sequence.
	 */
	public String getSequence()
	{
		return sequences;
	}
	
	/**
	 * Getter method for the general information on this sequence.
	 * @return the general information
	 */
	public String getGeneralInfo()
	{
		return gi;
	}
	
	/**
	 * the Method to get the name of the dna sequence
	 * @return String
	 */
	public String getName()
	{
		return name;
	}
}
