import java.util.ArrayList;

/**
 * A NodeVisitor implementation that requires all data passed into it to be of type Comparable. 
 * finds the minimum and maximum values in a given data set. 
 * 
 * Name, Data, Modifications: 
 * Jeric Derama, 20 May 2012, added a getter method for an arraylist to help check binary search trees. 
 * @author Jeric Derama
 * @version 5/20/2012
 *
 */
public class ExtremeValueCalculator implements NodeVisitor
{
	private Comparable min;
	private Comparable max;
	private ArrayList<Integer> list;
	
	// Constructor for the NodeVisitor implementation that 
	// looks for  extreme values. 
	public ExtremeValueCalculator() 
	{
		list = new ArrayList<Integer>();
	}
	
	public void visit(Object data)
	{
		// If the data is null do nothing
		if(data == null)
			return;
		
		// Add the data to the list. 
		list.add((Integer) data);
		// Handles the first instance i.e first number
		if(max == null && min == null)
			{
				max = (Comparable)data;
				min = (Comparable)data;
			}
		
		// If max is less than data then make that data the max
		if(max.compareTo((Comparable)data) < 0)
			max = (Comparable)data;
		
		// If min is greater than data then make that data the min
		if(min.compareTo((Comparable)data) > 0)
			min = (Comparable)data;
		
	}
	
	/**
	 * Getter method for lowest number in a tree
	 * @return the min value
	 */
	public Comparable min()
	{
		return min;
	}
	
	/** 
	 * Getter method for the largest number in a tree
	 * @return the max value
	 */
	public Comparable max()
	{
		return max;
	}
	
	/**
	 * Getter method for a list of the numbers visited. 
	 * @return a list containing all the numbers visited. 
	 */
	public ArrayList<Integer> list()
	{
		return list;
	}
	
}
