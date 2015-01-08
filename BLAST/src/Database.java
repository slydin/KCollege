import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

/**
 * Class Name: Database
 * Contains methods to add DNA sequences to the array of dna sequences
 * 
 * @author Jeric Derama and Olivia Kullman with assistance from Dr. Cutter and TAs
 * @version Spring 2012
 *
 */
public class Database {

	private HashMap map;
	// String that will be added to. 
	private String stringOfMatches;
	private String string1;
	// Original ArrayList comes from the DNAData 
	private ArrayList<DNASequence> sequences;
	private int segmentLength;
	private ArrayList<Location> locations;
	
	/**
	 * Database constructor
	 */
	public Database()
	{
		//instainate instance variables
		sequences = new ArrayList<DNASequence>();
		map = new HashMap();
		segmentLength = 11;
	}
	
	/**
	 * Adds the sequences of DNA to an arraylist to be added into the database. 
	 */
	public void add(DNASequence sequence)
	{
		// Add the sequence to an arraylist for storage
		sequences.add(sequence);
	}
	
	
	/**
	 *  Goes through all the sequences and gets their location and indices a whole hash map. 
	 */
	public void addSegments()
	{
		// int i goes through the number of sequences within a DNASequence ArrayList.
		// int j goes through the number of positions within a specific sequence. 
			
		for(int i = 0; i <= sequences.size()-1; i++)
		{
			String sequence = sequences.get(i).getSequence();
			for(int j = 0; j < sequence.length()-1-segmentLength; j++)
			{	
				// Creating a new ArrayList of Locations for each SubstringandLocs object that will be instantiated. 
				locations = new ArrayList<Location>();
				// A method to check whether a substring already exists within the SubstringandLocs ArrayList. 
				boolean check = false;
				
				String possibleMatch = sequence.substring(j,j+segmentLength);
			
				// Checks to see if the key already exists. 
				if(map.containsKey(possibleMatch))
				{
					locations = (ArrayList<Location>) map.get(possibleMatch);
					locations.add(new Location(i, j));
					map.put(possibleMatch, locations);
					check = true;
				}
				
				// If key doesn't exist check == false which means we will add a new key and value 
				// to the hashmap.
				if(check == false)
				{
					locations.add(new Location(i,j));	
					map.put(possibleMatch, locations);
				}							
			}
		}
	}
		
	/**
	 * the hash map contains the current data
	 * 
	 * @return hashmap
	 */
	public HashMap currentData()
	{
		return map;
	}
	
	/**
	 * what is the in the array?
	 * @return array list of dna sequnce objects
	 */
	public ArrayList<DNASequence> dnaSequences()
	{
		return sequences;
	}
	
}
