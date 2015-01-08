 import java.util.Queue;
import java.util.LinkedList;
/*

The BinaryTree Class

@author Autumn C. Spaulding <a href="mailto:autumn@max.cs.kzoo.edu">email</a>
Creation Date: 24 July 2000

Modifications:
    Modifier: Alyce Brady
    Modification Date: November 11, 2002
    Modifications Made: Modifications to documentation (e.g., to remove
        empty preconditions); added levelOrderTraversal;
        also modified to use NodeAction interface.
    Modifier: Nathan Sprague
    Modification Date: May 10, 2010
    Modifications Made: Modified to use Java Queue interface.

Modifications:
    Modifier: Jeric Derama
    Modification Date: 5/18/2012
    Modifications Made: Implementations of all traversals and characteristic methods 
    a binary tree. i.e depth;

Description:
    This file contains some of the implementation of a BinaryTree class. 
    It is intended as an outline and starting point for the "Binary Trees"
    lab in the Data Structures course.  The implementation is based on the 
    recursive definition of a tree rather than on the graph theory definition
    of a tree (compare to Bailey, 190).
    
    A binary tree is either:
        1.  An empty tree; or
        2.  a node, called a root (the node contains the data), and two 
            children, left and right, each of which are themselves binary trees.
                (Berman, "Data Structures via C++: Objects by Evolution", 1997.)
    
    In this implementation, an empty tree is represented by a node with null
    data and null references for the children.  A leaf node is represented by
    a node with a data value and two references to empty trees (NOT a data
    value and two null references!).  We could represent this as an object
    invariant: data, left, right are either all null (representing an empty
    tree) or none of them are null (a non-empty tree).

*/

/**
 * Binary Tree class.
 * 
 * @author Jeric Derama
 * @version May 18, 2012
 *
 */
public class BinaryTree
{
    //data:
    protected Object data;
    protected BinaryTree left;
    protected BinaryTree right;
        
    /*tested*/
    /** Creates an empty binary tree with no data and no children. */
    public BinaryTree()
    {
        //this is the constructor for the BinaryTree object
        data = null;
        left = null;
        right = null;
    }
     
    /*tested*/
    /** Tests whether this is an empty tree.
            @return true if the tree is empty; false otherwise
    */
    public boolean isEmpty()
    {
        return data == null;
    }
   
    /*tested*/
    /** Gets the data associated with the root node of this particular tree
        (recall recursive definition of trees).
            @return value associated with tree's root node; 
                          null if tree is empty
    */
    public Object getElement()
    {
        return data;
    }

    /*tested*/
    /** Gets the left child of the current tree.
            @return the left child (a tree)
    */
    public BinaryTree leftTree()
    {
        return left;
    }

    /*tested*/
    /** Gets the right child of the current tree.
            @return the right child (a tree)
    */
    public BinaryTree rightTree()
    {
        return right;
    }

    /**
     * Checks if the current node is a leaf 
     * @return a boolean to see if it is a leaf
     */
    public boolean isLeaf()
    {
    	// Checks if current node is a leaf
    	if(this.leftTree().isEmpty() && this.rightTree().isEmpty())	
    		return true;
    	return false; 
    }
    
    /**
     * Getter method for the number of nodes in the binary tree.
     * @return Node number
     */
    public int numNodes()
    {
    	// Checks if the current node is empty if it is it doesn't count.
    	if(this.isEmpty())
    		return 0;
    	
    	// Construct left and right trees.
    	BinaryTree left = this.leftTree();
    	BinaryTree right = this.rightTree();
    	
    	// Return a recursive call to check the left and right sides and count them.
    	return 1 + left.numNodes() + right.numNodes();
    }
    
    /**
     * Getter method for the number of leaves.
     * @return the number of leaves.
     */
    public int numLeaf()
    {
    	// Check if the current node is empty.
    	if(this.isEmpty())
    		return 0;
    	
    	// Check if the current node is a leaf
    	if(this.isLeaf())
    		return 1;
    	// Construct left and right trees.
    	BinaryTree left = this.leftTree();
    	BinaryTree right = this.rightTree();
    	
    	// Recursive call to look for leaves. 
    	return left.numLeaf() + right.numLeaf();
    }
    
    /**
     * Method that finds the depth of the given tree.
     * @return the depth
     */
    public int depth()
    {
    	// If we reach an empty tree it doesn't count towards the depth.
    	if(this.isEmpty())
			return 0;
    	// Check if the current node is a leaf.
    	if(this.isLeaf())
    		return 0;
    	
		// Construct left and right trees.
		BinaryTree left = this.leftTree();
		BinaryTree right = this.rightTree();

		// Made to find left and right side differences
		int leftDepth = left.depth();
		int rightDepth = right.depth();
		
		// Allows for the recursive call to go left or right depending on which side 
		// is larger.
		if(leftDepth >= rightDepth)
			return leftDepth + 1;
		else 
			return rightDepth+ 1;
		
    }
    
    /** Adds elements to a binary tree.  This implementation adds the
        elements in breadth-first (top-down, left-to-right) order.
            @param value the value to be added to the tree.
            @return true when the value has been added; should never return false
    */
    public boolean add(Object value)
    {
        Queue<Object> queue = new LinkedList<Object>();
        queue.add(this);
        
        while( ! queue.isEmpty() )
        {
            BinaryTree tree = (BinaryTree)queue.remove();

            //if the current position is null, then we know we can place a
            //value here.
            //place the value in that position in the tree, and create new 
            //BinaryTrees for its children, which will both initially be null.
            if (tree.isEmpty())
            {
                tree.data = value;
                tree.left = new BinaryTree();
                tree.right = new BinaryTree();
                return true;
            }
            //otherwise, if the position is not null (that is, we can't place
            //it at the current position), then we add the left and right children
            //to the queue (if we can) and go back to the beginning of the loop.
            queue.add(tree.left);
            queue.add(tree.right);
        }
        return false;    //this statement should never be executed.
    }
    
    /**
     * Checks to see if the tree contains the object.
     * 
     * @param newData the object being looked for.
     * @return true if the tree contains newData
     */
    public boolean contains(Object newData)
    {   
    	// If the current node is empty returns false
    	if(this.isEmpty())
    		return false;
    	
    	// Gets the current node's element to check
    	if(this.getElement().equals(newData))
    		return true;
    	
    	// Construct left and right trees.
    	BinaryTree left = this.leftTree();
    	BinaryTree right = this.rightTree();
    	
    	// Checks the left and right side. 
    	if(left.contains(newData))
    		return true;
    	if(right.contains(newData))
    		return true;
    	
    	return false;
    }
    
    /**
     *  Checks to see if the provided tree is equal to this tree. 
     * @param tree to be checked
     * @return true if they are equal.
     */
    public boolean equals(BinaryTree tree)
    {
    	// Checks if the number of nodes are equal in both.
    	if(this.numNodes() != tree.numNodes())
    		return false;
    	// Calls on the helper method for a recursive call.
    	return equalCheck(this, tree);
    }
    
    /**
     * Helper method for the equals method that does a recursive call to check numOccurrences
     * of objects in both trees. 
     * 
     * @param a referring to the original tree
     * @param b referring to the tree being checked
     * @return true if both trees have an equal number of occurrences of each object. 
     */
    public boolean equalCheck(BinaryTree a, BinaryTree b)
    {
    	// Construct left and right trees for both a and b.
    	BinaryTree leftA = a.leftTree();
    	BinaryTree rightA = a.rightTree();
    	BinaryTree leftB = b.leftTree();
    	BinaryTree rightB = b.rightTree();
    	
    	// Check if the current nodes are empty.
    	if(a.isEmpty() && b.isEmpty())
    		return true;
    	
    	// Check if the number of occurrences for a single object is the same in both tree. 
    	if(b.numOccurrences(a.getElement()) == a.numOccurrences(a.getElement()))
    			return equalCheck(leftA, leftB) && equalCheck(rightA, rightB);
    	else 
    		return false;
    }	
    
    /**
     * Looks for the number of occurrences of a particular object
     * 
     * @param newData object being looked for.
     * @return the number of times the object is found in the tree.
     */
 
    public int numOccurrences(Object newData)
    {
    	
    	// Check if the node is empty, if it is return 0.
    	if(this.isEmpty())
    		return 0;
    	
    	// Check the current element to see if it is the equal
    	if(this.getElement().equals(newData))
    		return 1;
    	
    	// Construct the left and right trees.
    	BinaryTree left = this.leftTree();
    	BinaryTree right = this.rightTree();
    	
    	// Recursive call for the left and right occurrences. 
    	return left.numOccurrences(newData) + right.numOccurrences(newData);
    }

	/** 
	 * Traverses the tree in breadth-first order.
	 * @param action an object that will act on all the nodes in the tree
	 */
	public void breadthFirstTraversal(NodeVisitor action)
	{
		Queue<Object> queue = new LinkedList<Object>();
		queue.add(this);
		while( ! queue.isEmpty() )
		{
			BinaryTree tree = (BinaryTree)queue.remove();
			if ( ! tree.isEmpty() )
            {
    			action.visit(tree.getElement());
    			queue.add(tree.leftTree());
    			queue.add(tree.rightTree());
            }
		}
	}	
	/**
	 * Traverses the tree in pre-order.
	 * @param action an object that will act on all the nodes in the tree
	 */
	public void preorderTraversal(NodeVisitor action)
	{
		// First check if this is empty
		if(this.isEmpty())
			return;
		// Construct left and right trees.
		BinaryTree left = this.leftTree();
		BinaryTree right = this.rightTree();

		// Get the element 
		action.visit(this.getElement());
		// Go left
		left.preorderTraversal(action);
		// Go right	
		right.preorderTraversal(action);
		
		return;
	}
    /**
     * Traverses the tree in in-order.
     * @param action an object that will act on all the nodes in the tree
     */
	public void inOrderTraversal(NodeVisitor action)
	{
		// First check if this is empty
		if(this.isEmpty())
				return;
		// Construct left and right trees.
		BinaryTree left = this.leftTree();
		BinaryTree right = this.rightTree();
		
		// Go left 
		left.inOrderTraversal(action);		
		// Get the element
		action.visit(this.getElement());	
		// Go right.
		right.inOrderTraversal(action);
		
		return;
	}
	/**
	 * Traverses the tree in post-order.
	 * @param action an object that will act on all the nodes in the tree
	 */
	public void postOrderTraversal(NodeVisitor action)
	{
		// First check if this is empty
		if(this.isEmpty())
				return;
		// Construct left and right trees.
		BinaryTree left = this.leftTree();
		BinaryTree right = this.rightTree();
		
		// Go left 
		left.postOrderTraversal(action);		
		// Go right.
		right.postOrderTraversal(action);
		// Get the element
		action.visit(this.getElement());	
		
		return;
	}
    

}    
