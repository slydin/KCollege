/*
	Main file for Binary Tree Lab
	@author Autumn C. Spaulding
	Creation Date: 24 July 2000
	
	More thorough documentation may be found within the BinaryTree class file.
*/

/**
 * Main method for Binary Tree and Binary Search Tree. 
 * 
 * Name, Date, Modifications:
 * Jeric Derama, 19 May 2012, Implemented the isBST method in a head on approach it is now isBST1. 
 * Jeric Derama, 23 May 2012, Finalized a new isBST method which utilizes the in order traversal. 
 * 
 * @author Jeric Derama with assistance from Lucas Kushner
 * @version 5/23/2012
 *
 */
public class BinaryTreeLab
{

	public static void main(String args[])
	{
		
		//construct an empty binary tree here.
		BinaryTree tree1 = new BinaryTree();
		//insert elements in level order here.
		int[] iarray = {12, 7, 3, 4, 8, 25, 0, 142, 17, 26};
		for(int i = 0; i < iarray.length; i++)
		{
			tree1.add(new Integer(iarray[i]));
		}

		BST binary = new BST();
		
		for(int i = 0; i < iarray.length; i++)	
			binary.add(new Integer(iarray[i]));
		
		System.out.println(isBST1(binary));
		System.out.println(isBST1(tree1));
		System.out.println("new method");
		System.out.println(isBST(binary));
		System.out.println(isBST(tree1));
		
	}
	
	/**
	 * Checks if the given tree is a Binary Search Tree
	 * @param obj to be checked
	 * @return true or false whether or not given object is a BST
	 */
	public static boolean isBST(BinaryTree obj)
	{
		// Create a boolean flag which will be returned in the method. 
		boolean check = true;
		// Initialize the ExtremeValueCalculator
		ExtremeValueCalculator value = new ExtremeValueCalculator();
		BinaryTree binary = obj;
		// Do an in order traversal in the given tree.
		binary.inOrderTraversal(value);
		// Let this be the starting point. 
		Comparable number = value.list().get(0);
		// Use a for loop to go through every value stored in the arraylist of the
		// ExtremeValueCalculator. 
		for(int i = 0; i < value.list().size(); i++)
		{
			// If the current value is greater than the next value 
			// check becomes false because it is always supposed to be less than
			// or equal(for the starting point case).
			if(number.compareTo(value.list().get(i)) > 0)
				check = false;
		}
		
		// return check to see whether or not the given tree is a binary search tree or not. 
		return check;
	}
	
	/**
	 * Checks if the given tree is a Binary Search Tree
	 * @param obj to be checked
	 * @return true if it is a binary search tree
	 */
	public static boolean isBST1(BinaryTree obj)
	{	
		BinaryTree binary = obj;
		boolean check = false;
		// First checks if the current node is empty.
		if( obj.isLeaf())
			{
				check = true;
				return check;
			}
		// Construct left and right trees.
		BinaryTree leftTree = binary.leftTree();
		BinaryTree rightTree = binary.rightTree();
		Comparable current = (Comparable) binary.getElement();
		
		// Recursive call to check every subtree element. 
		if(leftTree.getElement() != null)
			{
			check = true;
			if(current.compareTo(leftTree.getElement()) > 0)	
				check = isBST1(leftTree);
			else 
				check = false;
			}
		if(rightTree.getElement() != null)
		{
			if(current.compareTo(rightTree.getElement()) < 0)
				check = isBST1(rightTree);
			else 
				check = false;
		}
		return check; // return false otherwise
	}

}	//end class BinaryTreeLab
