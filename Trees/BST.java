import java.util.LinkedList;
import java.util.Queue;

/* 
 * Binary Search Tree Class. 
 * @author Jeric Derama
 * @version 5/23/2012
 * Implementation of a Binary Search Tree based off a Binary Tree. 
 *
 * A binary search tree is either:
 *  1.  an empty tree; or
 *  2.  a node, called a root, and two children, left and right, each
 *   of which is itself a binary search tree.  Each node contains a value 
 *   such that the value at the root is greater than the value in any of the nodes 
 *   in the left subtree, and less than or equal to the value of any nodes in the 
 *   right subtree.  (Berman, "Data Structures via C++:Objects by Evolution", 1997.) 
 */

/**
 * Binary Search Tree Class that extends a BinaryTree class. 
 * 
 * A binary search tree is either:
 *  1.  an empty tree; or
 *  2.  a node, called a root, and two children, left and right, each
 *   of which is itself a binary search tree.  Each node contains a value 
 *   such that the value at the root is greater than the value in any of the nodes 
 *   in the left subtree, and less than or equal to the value of any nodes in the 
 *   right subtree.  (Berman, "Data Structures via C++:Objects by Evolution", 1997.) 
 *   
 * @author Jeric Derama
 * @version 5/23/2012
 *
 */
public class BST extends BinaryTree {

	// Constructor for Binary Search Tree is the same for binary tree. 
	public BST() {
		super();
	}
	
	/**
	 * Re-implementation of the add method. Passed object must be a comparable. 
	 * @return true if the object is added. 
	 */
	public boolean add(Object value)
	{
		// First check if the current tree is empty.
		if(this.isEmpty())
		{
			this.data = value;
			this.left = new BST();
			this.right = new BST();
			return true;
		}
		
		// We then check the elements in the tree to place the given
		// comparable object in the correct node. 
		// This implements a recursive call. 
		if(((Comparable) this.getElement()).compareTo((Comparable)value) > 0)
			return ((BST) this.leftTree()).add(value);
		else if(((Comparable) this.getElement()).compareTo((Comparable)value) < 0)
			return ((BST) this.rightTree()).add(value);
		else
			return false;
	}
	
	/**
	 * Looks for the minimum value which is located in the left most node.
	 * @return min value which is the element in the left most node. 
	 */
	private Comparable leftMost()
	{
		// Check if empty first.
		if(this.isEmpty())
			return null;
		// If the current node is a leaf return the element
		if(this.isLeaf())
			return (Comparable) this.getElement();
		
		if(this.rightTree() != null && this.leftTree() == null)
			return (Comparable) this.getElement();
		
		// Construct a left tree
		BST left = (BST)this.leftTree();
		
		// Recursive call.
		return left.leftMost();
		
	}
	
	/**
	 * Looks for the minimum value which is located in the left most node. 
	 * Removes it and returns its value. 
	 * @return the minimum value
	 */
	private Comparable removeLeftMost()
	{
		// First check if it is empty
		if(this.isEmpty())
			return null;
		
		// Make the current leftEle this node's element.
		Comparable leftEle = (Comparable) this.getElement();
		
		// If it is a leaf make the data null and return it
		if(this.isLeaf())
		{
			this.data = null;
			this.right = null;
			this.left = null;
			return leftEle;
		}
		// If it contains a right tree and not a left tree we have
		// reached the left most tree which isn't a leaf. 
		if(this.rightTree() != null && this.leftTree() == null)
		{
			this.data = this.rightTree().getElement();
			this.right = this.rightTree().rightTree();
			this.left = this.rightTree().leftTree();
			return leftEle;
		}
		
		// Left tree constructor
		BST left = (BST)this.leftTree();
		
		return left.removeLeftMost();
	}
	
	/**
	 * Removes a given object within the BST and retains the tree's properties
	 * by changing the current data and left and right subtrees. Assumes object being 
	 * passed is of type Comparable.
	 * @param obj to be removed within the tree.
	 * @return true or false depending on whether or not the object was removed.
	 */
	public boolean remove(Object obj)
	{
		// First check if the current node is empty
		if(this.isEmpty())
			return false;
		
		// Using the Comparable to compare objects, assumes all objects are comparable
		Comparable current = (Comparable) this.getElement();
		int compared = current.compareTo((Comparable)obj);
		
		// If compared is 0 then we are at the correct node.
		if(compared == 0)
		{
			// Check if the node is a leaf it is easy we simply make everything
			// null and return true;
			if(this.isLeaf())
			{
				this.data = null;
				this.right = null;
				this.left = null;
				return true;
			}
			else
			{
				// If it isn't a leaf we say that the current data is its right subtrees
				// left most node as that is the min in the subtree. 
				this.data = ((BST)this.rightTree()).removeLeftMost();
				return true;
			}	
		}
		// If current is less than obj than go left
		// vice versa
		if(compared < 0)
			return ((BST)this.rightTree()).remove(obj);
		else if(compared > 0)
			return ((BST)this.leftTree()).remove(obj);
		
		return false;
	}
	
	/**
	 * Checks whether or not two BST trees are equal or not.
	 * @return true or false depending if they are equal or not.
	 */
	public boolean equals(Object obj)
	{
		BST current = this;
		BST check = (BST)obj;
		
		// Checks if the number of nodes are equal in both.
		if(current.numNodes() != check.numNodes())
			return false;
		
		// Use a NodeVisitor to check the elements in both trees.
		PrintAction printer = new PrintAction();
		
		// in order traversal checks to see if the trees have the same elements
		// in the correct order but in different set ups. 
		current.inOrderTraversal(printer);
		// Store the string.
		String cur = printer.print();
		// Clear the NodeVisitor for the next visit
		printer.clear();
		// Same thing as earlier for the next tree. 
		check.inOrderTraversal(printer);
		String chk = printer.print();
		// Check if they are the same.
		if(cur.equals(chk))
			return true;
		else
			return false;
	}
}
