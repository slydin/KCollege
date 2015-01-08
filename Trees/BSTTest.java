import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;


public class BSTTest {
	
	BST tree1;
	BST tree2;

	@Before
	public void setUp() throws Exception {
		tree1 = new BST();
		tree2 = new BST();
		int[] iarray = {12, 7, 3, 4, 8, 25, 0, 142, 17, 26};
		for(int i = 0; i < iarray.length; i++)	
		{
			tree1.add(new Integer(iarray[i]));
		}
		
		int[] i2array = {12, 3, 0, 4, 8, 7, 26, 142, 17, 25};
		for(int i = 0; i < i2array.length; i++)	
		{
			tree2.add(new Integer(iarray[i]));
		}
	}

	@Test
	public void testAddOneElement() {
		BST addTree = new BST();
		addTree.add(10);
		assertEquals("Number should be: ", 10, addTree.getElement());
	}
	
	@Test
	public void testAddMultiElement() {
		PrintAction printer = new PrintAction();
		BST addTree = new BST();
		addTree.add(10);
		addTree.add(20);
		addTree.add(15);
		addTree.inOrderTraversal(printer);
		String cur = printer.print();
		assertEquals("List of numbers should go as: ", " 10 15 20", cur);
	}

	@Test
	public void testRemove() {
		tree1.remove(7);
		assertEquals("Should return: ", true, tree2.remove(7));
	}
	
	@Test
	public void testRemoveEmpty() {
		BST emptyTree = new BST();
		assertEquals("Should return: ", false, emptyTree.remove(7));
	}

	@Test
	public void testEqualsObject() {
		assertEquals("Should return: ", true, tree1.equals(tree2));
	}
	
	@Test
	public void testNotEqualsEmpty() {
		BST emptyTree = new BST();
		assertEquals("Should return: ", false, tree1.equals(emptyTree));
	}

	@Test
	public void testRemoveRoot() {
		tree1.remove(12);
		assertEquals("Should return: ", 17,tree1.getElement());
		
	}
}
