import java.util.ArrayList;

/*
    Implementation of PrintAction class.
    @author Jeric Derama, made by Alyce Brady
    Creation Date: Spring 2001
    
    The PrintAction class implements the NodeVisitor interface.
	It prints the contents of the node to System.out.
*/

/**
 * Implementation of PrintAction class. 
 * 
 * Prints the data found in a given object. 
 * @author Jeric Derama
 * @version May 17, 2012
 *
 */
public class PrintAction implements NodeVisitor
{
	private String testString;
    
	/**
	 * Constructor for the PrintAction NodeVisitor implementation.
	 */
	public PrintAction ()
	{
		// testString is for a JUnit test. 
    	testString = "";
	}

    public void visit(Object data)
	{
        if ( data != null )
        { 
        	System.out.println (data.toString());
        	testString = testString + " " + data.toString();
        }
	}
    
    /**
     * Getter method for the data concatenated for a JUnit test.
     * @return concatenated data string
     */
    public String print()
    {
    	return testString;
    }
    
    public void clear()
    {
    	testString = "";
    }
}
