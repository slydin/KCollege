// Class: Indexer
// 
//  Author: Jeric Derama
//  
//  Created on March 30 2012
//  Modified on April 5 2012
//  Fixed run and printResults methods. 
// 

import java.util.*;
import java.util.Map.Entry;
/**
 * The BLASTApp runs an algorithm to search and find 
 * 
 * @author Jeric Derama and Olivia Kullman with assistance from Dr. Cutter and TAs
 * @version Spring 2012
 *
 *
 *
 */
public class BLASTApp 
{
	 //private instance variables
	private HashMap map;
	private int threshold;
	private ArrayList<DNASequence> dnaSequences;
	private ArrayList<Location> locations;
	private ArrayList<String> queryList;
	private ArrayList<MatchElement> matches;
	private Database dataStorage;
	
	
	
	/**
	 * The indexer basically sorts out all the substrings and their given locations into array lists. 
	 * @param fileName The given file to be read
	 * @param lengthOfSubstring User provided substring length
	 */
	public BLASTApp(String dataFile, String queryFile, int thresholdLength ) 
	{
		//instaniating instance variables
		this.threshold = thresholdLength;
		DNADataReader dnaReader = new DNADataReader(dataFile);	
		dataStorage = dnaReader.readData();
		map = dataStorage.currentData();
		QueryReader queryReader = new QueryReader(queryFile);
		queryList = (ArrayList<String>) queryReader.readQueries();
	}
	
	/**
	 * Runs the algorithm
	 */
	public void run()
	{
		// Create a start and end integer for substring length
		int start = 0;
		int end = 11;
		// add the segments to the database to ready it for matches.
		dataStorage.addSegments();
		// DNASequence ArrayList to locate substring and extend hits. 
		ArrayList<DNASequence> sequences = dataStorage.dnaSequences();	
		// Initializing a location ArrayList for later use with the HashMap.
		ArrayList<Location> locations = new ArrayList<Location>();
		// Initializing the Matches ArrayList
		matches = new ArrayList<MatchElement>();
		// Initializing the MatchElement.
		MatchElement match = null;
		// Algorithm to go through each query to find matches and extended matches in the DNA data. 
		for(String query: queryList)
		{
			// As long as the we don't exceed the length of the query
			// increase the length of the substring
			while(start + end < query.length())
			{
				// String to check for matches 
				String possibleMatch = query.substring(start, start + end);
				// Instance variable
				String hit = null;
				// If there is a key then there will at least be a match.
				if(map.containsKey(possibleMatch))
				{
					// Assumes that there is at least one location. 
					locations = (ArrayList<Location>) map.get(possibleMatch);
						// Check and extend at each location. 
						for(Location location: locations)
						{
							int extend = 1;
							// Integers to search each location.
							int index = location.index();
							int placement = location.placement();
							// Looping around to keep extending if possible. 
							boolean check = false;
							while(start + end + extend < query.length() && check == false)
								{
									if(query.substring(start, start+end+extend).equals(sequences.get(index).getSequence().substring(placement,placement+end+extend)))
									{
										// Save the current hit.
										hit = sequences.get(index).getSequence().substring(placement,placement+end+extend);
										// Extend further. 
										if(hit.length() < query.length())
												extend++; 
									}
									else 
										check = true;
								}
							if(hit != null && hit.length() >= threshold)
								{
									match = new MatchElement(queryList.indexOf(query), start,index, placement, hit.length(), sequences.get(index));
									matches.add(match);
								}
							
						}
				}
				// Natural extension. Not for extended hits. 
				start++;
			}
		}
		//create a new tree map and an array list
		//variable int for a check 
		TreeMap<Integer, ArrayList<MatchElement>> tMap = new TreeMap<Integer, ArrayList<MatchElement>>();
		ArrayList<MatchElement> sameQuery;
		int check = -1;
		//for loop to loop through arraylist of matches
		for(int i = 0; i < matches.size(); i++)
			{	
				//get element in array at index
				MatchElement search = matches.get(i);
				//loop through array list for size of array list
				for(int j = 0; j < matches.size(); j++)
				{
					//store the element in a variable
					MatchElement found = matches.get(j);
					//if the two variables are not equal
					if(!search.equals(found))
						//check if they are the same sequence
						if(search.getSequence() == found.getSequence())
							//then check to see if the difference in position is the same and the difference in the length
							if(search.getMatchLength() - found.getMatchLength() == found.getSequencePosition() - search.getSequencePosition())
								//then remove
								matches.remove(found);
				}
				//if matches is zero
				if(matches.size() == 0)
				{
					//print that no matches are found
					System.out.println("No matches found");
					break;
				}
				//if the variable is equal to exisiting query add it 
				if(search.getQuery() == check)
					tMap.get(search.getQuery()).add(search);
				else
				{
					//make a new array of match elements, add and put it into the tree, change the check variable
					sameQuery = new ArrayList<MatchElement>();
					sameQuery.add(search);
					tMap.put(search.getQuery(), sameQuery);
					check = search.getQuery();
				}
			}
		
		//make a set and an iterator to get elements in the map
		Set<Entry<Integer, ArrayList<MatchElement>>> tData = tMap.entrySet();
		Iterator<Entry<Integer,ArrayList<MatchElement>>> tIterator = tData.iterator();
		while(tIterator.hasNext())
		{
			//iterator through the entries in the map and print them.
			Entry<Integer, ArrayList<MatchElement>> e = tIterator.next();
			System.out.println("Query#: " + e.getKey() + " Number of Matches: " + e.getValue().size());
			for(MatchElement ele: e.getValue())
				ele.print();	
		}

	}
	
}

