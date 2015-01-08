/**
 * 
 */

/**
 * @author Jeric Derama
 * @version 8 May 2012
 *
 */
public class Summer implements NodeVisitor {

	private int total;
	/**
	 * Constructor for a NodeVisiter object that sums up all the elements in a binary tree.  
	 */
	public Summer()
	{
		total = 0;
	}
	/**
	 * Implementation of the visit method from NodeVisitor but must take 
	 * in an Integer. 
	 * @param number an Integer 
	 */
	public void visit(Object data) {
		if(data == null)
			System.out.println("Please enter an Integer Value");
		else 
			total = ((Integer) data).intValue() + total;
	}
	
	public int total()
	{
		return total;
	}
}
