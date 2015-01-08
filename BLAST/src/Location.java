// Class: Location
//
// Author: Jeric Derama
// 
// Created on March 30 2012


/**
 * Location contains information regarding the indexes for both sequence and sequence position.
 * 
 * @author Jeric Derama and Olivia Kullman with assistance from Dr. Cutter and TAs
 * @version Spring 2012
 *
 */
public class Location
{
	private int index;
	private int location;
	
	/**
	 * Constructs a location for a substring within a given sequence and string position. 
	 * @param stringIndex provides the given sequence index
	 * @param locationIndex provides the string position
	 */
	public Location(int stringIndex, int locationIndex)
	{
		this.index = stringIndex;
		this.location = locationIndex;
	}
	
	/**
	 * Prints out data passed on to this location. 
	 */
	public void location()
	{
		System.out.println("Index: " + index + " Starting at " + location);
	}
	
	/**
	 * Getter method for the string index
	 * @return the string index
	 */
	public int index()
	{
		return index;
	}
	/**
	 * Getter method for the current location
	 * @return the location 
	 */
	public int placement()
	{
		return location;
	}

}

