import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

//-------------------------------------------------------------------------
/**
 * DLLTest class for Doubly Linked List
 *
 * @author Ruairí O'Connor
 * @version 13/10/16 18:15
 */
@RunWith(JUnit4.class)
public class DoublyLinkedListTest {
	// ~ Constructor ........................................................
	@Test
	public void DLLTestConstructor() {
		new DoublyLinkedList<Integer>();
	}

	// ~ Public Methods ........................................................

	// ----------------------------------------------------------
	/**
	 * Check if the insertBefore works
	 */
	@Test
	public void testInsertBefore() {
		// DLLTest non-empty list
		DoublyLinkedList<Integer> DLLTest = new DoublyLinkedList<Integer>();
		DLLTest.insertBefore(0, 1);
		DLLTest.insertBefore(1, 2);
		DLLTest.insertBefore(2, 3);

		DLLTest.insertBefore(0, 4);
		assertEquals("Checking insertBefore to a list containing 3 elements at position 0", "4,1,2,3",
				DLLTest.toString());
		DLLTest.insertBefore(1, 5);
		assertEquals("Checking insertBefore to a list containing 4 elements at position 1", "4,5,1,2,3",
				DLLTest.toString());
		DLLTest.insertBefore(2, 6);
		assertEquals("Checking insertBefore to a list containing 5 elements at position 2", "4,5,6,1,2,3",
				DLLTest.toString());
		DLLTest.insertBefore(-1, 7);
		assertEquals(
				"Checking insertBefore to a list containing 6 elements at position -1 - expected the element at the head of the list",
				"7,4,5,6,1,2,3", DLLTest.toString());
		DLLTest.insertBefore(7, 8);
		assertEquals(
				"Checking insertBefore to a list containing 7 elemenets at position 8 - expected the element at the tail of the list",
				"7,4,5,6,1,2,3,8", DLLTest.toString());
		DLLTest.insertBefore(700, 9);
		assertEquals(
				"Checking insertBefore to a list containing 700 elements at position 9 - expected the element at the tail of the list",
				"7,4,5,6,1,2,3,8,9", DLLTest.toString());

		// DLLTest empty list
		DLLTest = new DoublyLinkedList<Integer>();
		DLLTest.insertBefore(0, 1);
		assertEquals(
				"Checking insertBefore to an empty list at position 0 - expected the element at the head of the list",
				"1", DLLTest.toString());
		DLLTest = new DoublyLinkedList<Integer>();
		DLLTest.insertBefore(10, 1);
		assertEquals(
				"Checking insertBefore to an empty list at position 10 - expected the element at the head of the list",
				"1", DLLTest.toString());
		DLLTest = new DoublyLinkedList<Integer>();
		DLLTest.insertBefore(-10, 1);
		assertEquals(
				"Checking insertBefore to an empty list at position -10 - expected the element at the head of the list",
				"1", DLLTest.toString());
	}

	@Test
	public void testIsEmpty() {
		DoublyLinkedList<Integer> DLLTest = new DoublyLinkedList<Integer>();
		assertTrue(DLLTest.isEmpty());
		DLLTest.insertBefore(0, 1);
		assertFalse(DLLTest.isEmpty());
	}

	@Test
	public void testGet() {
		DoublyLinkedList<Integer> DLLTest = new DoublyLinkedList<Integer>();
		assertNull(DLLTest.get(-5));
		DLLTest.insertBefore(0, 1);
		DLLTest.insertBefore(1, 2);
		DLLTest.insertBefore(2, 3);
		Integer expectedResult = 1;
		assertEquals("Checking get to a list containing 3 elements at the head of the list", expectedResult, DLLTest.get(0));
		expectedResult = 2;
		assertEquals("Checking get to a list containing 3 elements at position 1", expectedResult, DLLTest.get(1));
		expectedResult = 3;
		assertEquals("Checking get to a list containing 3 elements at the tail of the list", expectedResult, DLLTest.get(2));
	}

	@Test
	public void testDeleteAt() {
		DoublyLinkedList<Integer> DLLTest = new DoublyLinkedList<Integer>();
		assertFalse(DLLTest.deleteAt(-5));
		DLLTest.insertBefore(0, 1);
		DLLTest.insertBefore(1, 2);
		DLLTest.insertBefore(2, 3);
		assertTrue(DLLTest.deleteAt(2));
		assertEquals("Checking deleteAt to a list containing 3 elements at the tail of the list", "1, 2", DLLTest.toString());
		assertTrue(DLLTest.deleteAt(1));
		assertEquals("Checking deleteAt to a list containing 2 elements at position 1", "1", DLLTest.toString());
		assertTrue(DLLTest.deleteAt(0));
		assertEquals("Checking deleteAt to a list containing 1 element at the head of the list", "", DLLTest.toString());
	}

	@Test
	public void testReverse() {
		DoublyLinkedList<Integer> DLLTest = new DoublyLinkedList<Integer>();
		DLLTest.reverse();
		assertEquals("Checking reverse to an empty list", "", DLLTest.toString());
		DLLTest.insertBefore(0, 1);
		DLLTest.reverse();
		assertEquals("Checking reverse to a list containing 1 elements", "1", DLLTest.toString());
		DLLTest.insertBefore(1, 2);
		DLLTest.insertBefore(2, 3);
		DLLTest.reverse();
		assertEquals("Checking reverse to a list containing 3 elements", "3, 2, 1", DLLTest.toString());
	}
	@Test
	public void testmakeUnique() {
		DoublyLinkedList<Integer> DLLTest = new DoublyLinkedList<Integer>();
		DLLTest.makeUnique();
		assertEquals("Checking makeUnique to an empty list", "", DLLTest.toString());
		DLLTest.insertBefore(0, 1);
		DLLTest.makeUnique();
		assertEquals("Checking makeUnique to a list containing 1 elements", "1", DLLTest.toString());
		DLLTest.insertBefore(1, 2);
		DLLTest.insertBefore(2, 2);
		DLLTest.makeUnique();
		assertEquals("Checking makeUnique to a list containing 3 elements", "1, 2", DLLTest.toString());
	}
	@Test
	public void testPush() {
		DoublyLinkedList<Integer> DLLTest = new DoublyLinkedList<Integer>();
		DLLTest.push(1);
		assertEquals("Checking push to an empty list", "1", DLLTest.toString());
		DLLTest.push(2);
		assertEquals("Checking push to a list containing 1 element", "2, 1", DLLTest.toString());
		DLLTest.push(3);
		assertEquals("Checking push to a list containing 2 elements", "3, 2, 1", DLLTest.toString());
	}

	@Test
	public void testPop() {
		DoublyLinkedList<Integer> DLLTest = new DoublyLinkedList<Integer>();
		assertNull(DLLTest.pop());
		DLLTest.insertBefore(0, 1);
		DLLTest.insertBefore(1, 2);
		DLLTest.insertBefore(2, 3);
		DLLTest.pop();
		assertEquals("Checking pop to a list containing 3 elements", "2, 3", DLLTest.toString());
		DLLTest.pop();
		assertEquals("Checking pop to a list containing 2 elements", "3", DLLTest.toString());
		DLLTest.pop();
		assertEquals("Checking pop to a list containing 1 element", "", DLLTest.toString());
	}

	@Test
	public void testEnqueue() {
		DoublyLinkedList<Integer> DLLTest = new DoublyLinkedList<Integer>();
		DLLTest.enqueue(1);
		assertEquals("Checking enqueue to an empty list", "1", DLLTest.toString());
		DLLTest.enqueue(2);
		assertEquals("Checking enqueue to a list containing 1 element", "1, 2", DLLTest.toString());
		DLLTest.enqueue(3);
		assertEquals("Checking enqueue to a list containing 2 elements", "1, 2, 3", DLLTest.toString());
	}

	@Test
	public void testDequeue() {
		DoublyLinkedList<Integer> DLLTest = new DoublyLinkedList<Integer>();
		assertNull(DLLTest.dequeue());
		DLLTest.insertBefore(0, 1);
		DLLTest.insertBefore(1, 2);
		DLLTest.insertBefore(2, 3);
		assertEquals("Checking dequeue to a list containing 3 elements", "1, 2", DLLTest.dequeue());
		assertEquals("Checking dequeue to a list containing 2 elements", "1", DLLTest.dequeue());
		assertEquals("Checking dequeue to a list containing 1 element", "", DLLTest.dequeue());
	}
}
