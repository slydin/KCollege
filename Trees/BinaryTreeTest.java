import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;


public class BinaryTreeTest {
	
	private BinaryTree tree1;
	private BinaryTree tree2;
	private int[] iarray;
	
	@Before
	public void setUp() throws Exception {
		tree1 = new BinaryTree();
		tree2 = new BinaryTree();
		int[] iarray = {12, 7, 3, 4, 8, 25, 0, 142, 17, 26};
		// Add in first breath order
		for(int i = 0; i < iarray.length; i++)	
		{
			tree1.add(new Integer(iarray[i]));
		}
		
		int[] i2array = {12, 7, 3, 4, 8, 0, 25, 142, 17, 26};
		for(int i = 0; i < i2array.length; i++)	
		{
			tree2.add(new Integer(iarray[i]));
		}
	}

	@Test   
	public void testIsEmpty() {
		BinaryTree emptyTree = new BinaryTree();
		assertEquals("An empty tree returns: ", true, emptyTree.isEmpty());
	}
	
	public void testIsNonEmpty() {
		BinaryTree tree = new BinaryTree();
		tree.add(5);
		assertEquals("Tree returns: ", false, tree.isEmpty());
	}

	@Test
	public void testGetElement() {
		assertEquals("First Element should be: ", 12, tree1.getElement());
	}

	@Test
	public void testIsLeaf() {
		BinaryTree leafTree = new BinaryTree();
		leafTree.add(5);
		assertEquals("leafTree should return: ", true, leafTree.isLeaf());
	}
	
	public void testisLeafNot() {
		BinaryTree leafTree = new BinaryTree();
		leafTree.add(5);
		leafTree.add(1);
		assertEquals("leafTree should return: ", false, leafTree.isLeaf());
	}

	@Test
	public void testNumNodes() {
		assertEquals("Should return the number: ", 10, tree1.numNodes());
	}
	
	public void testNumNodesEmpty() {
		BinaryTree tree = new BinaryTree();
		assertEquals("Should return the number: ", 1, tree.numNodes());
	}

	@Test
	public void testNumLeaf() {
		assertEquals("Should return the number: ", 5, tree1.numLeaf());
	}

	@Test
	public void testDepth() {
		assertEquals("Should return the number: ", 3, tree1.depth());
	}

	@Test
	public void testAdd() {
		BinaryTree addTree = new BinaryTree();
		addTree.add(5);
		assertEquals("Should return the number: ", 5, addTree.getElement());
	}

	public void testAddMultiElement() {
		BinaryTree addTree = new BinaryTree();
		addTree.add(5);
		addTree.add(10);
		addTree.add(15);
		assertEquals("Should return the number: ", 15, addTree.rightTree().getElement());
	}
	@Test
	public void testContains() {
		assertEquals("Should return: ", true, tree1.contains(142));
	}
	
	@Test
	public void testNotContain() {
		assertEquals("Should return: ", false, tree1.contains(500));
	}

	@Test
	public void testEqualsBinaryTree() {
		assertEquals("Should return: ", true, tree1.equals(tree2));
	}
	
	@Test
	public void testEqualsNotBinaryTree() {
		BinaryTree tree = new BinaryTree();
		tree.add(5);
		tree.add(5);
		tree.add(5);
		assertEquals("Should return: ", false, tree1.equals(tree));
	}

	@Test
	public void testNumOccurrences() {
		assertEquals("Should return the number: ", 1, tree1.numOccurrences(142));
	}
	
	public void testNonExistNumOccurrences() {
		assertEquals("Should return the number: ", 0, tree1.numOccurrences(500));
	}

	@Test
	public void testBreadthFirstTraversal() {
		PrintAction printer = new PrintAction();
		String numList = " 12 7 3 4 8 25 0 142 17 26";	
		tree1.breadthFirstTraversal(printer);
		assertEquals("This should return: ", true, printer.print().equals(numList));
	}

	@Test
	public void testPreorderTraversal() {
		PrintAction printer = new PrintAction();
		String numList = " 12 7 4 142 17 8 26 3 25 0";	
		tree1.preorderTraversal(printer);
		assertEquals("This should return: ", true, printer.print().equals(numList));
	}

	@Test
	public void testInOrderTraversal() {
		PrintAction printer = new PrintAction();
		String numList = " 142 4 17 7 26 8 12 25 3 0";	
		tree1.inOrderTraversal(printer);
		assertEquals("This should return: ", true, printer.print().equals(numList));
	}

	@Test
	public void testPostOrderTraversal() {
		PrintAction printer = new PrintAction();
		String numList = " 142 17 4 26 8 7 25 0 3 12";	
		tree1.postOrderTraversal(printer);
		assertEquals("This should return: ", true, printer.print().equals(numList));
	}

}
