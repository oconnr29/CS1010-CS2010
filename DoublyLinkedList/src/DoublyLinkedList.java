import java.util.Iterator;
import java.util.ListIterator;
import java.util.NoSuchElementException;

// -------------------------------------------------------------------------
/**
 *  This class contains the methods of Doubly Linked List.
 *
 *  @author  Ruairí O'Connor
 *  @version 09/10/18 11:13:22
 */

/**
 * Class DoublyLinkedList: implements a *generic* Doubly Linked List.
 * 
 * @param <T>
 *            This is a type parameter. T is used as a class name in the
 *            definition of this class.
 *
 *            When creating a new DoublyLinkedList, T should be instantiated
 *            with an actual class name that extends the class Comparable. Such
 *            classes include String and Integer.
 *
 *            For example to create a new DoublyLinkedList class containing
 *            String data: DoublyLinkedList<String> myStringList = new
 *            DoublyLinkedList<String>();
 *
 *            The class offers a toString() method which returns a
 *            comma-separated sting of all elements in the data structure.
 * 
 *            This is a bare minimum class you would need to completely
 *            implement. You can add additional methods to support your code.
 *            Each method will need to be tested by your jUnit tests -- for
 *            simplicity in jUnit testing introduce only public methods.
 */
class DoublyLinkedList<T extends Comparable<T>> {

	/**
	 * private class DLLNode: implements a *generic* Doubly Linked List node.
	 */
	private class DLLNode {
		public final T data; // this field should never be updated. It gets its
								// value once from the constructor DLLNode.
		public DLLNode next;
		public DLLNode prev;

		/**
		 * Constructor
		 * 
		 * @param theData
		 *            : data of type T, to be stored in the node
		 * @param prevNode
		 *            : the previous Node in the Doubly Linked List
		 * @param nextNode
		 *            : the next Node in the Doubly Linked List
		 * @return DLLNode
		 */
		public DLLNode(T theData, DLLNode prevNode, DLLNode nextNode) {
			data = theData;
			prev = prevNode;
			next = nextNode;
		}
	}

	// Fields head and tail point to the first and last nodes of the list.
	private DLLNode head, tail;

	/**
	 * Constructor of an empty DLL
	 * 
	 * @return DoublyLinkedList
	 */
	public DoublyLinkedList() {
		head = null;
		tail = null;
	}

	/**
	 * Tests if the doubly linked list is empty
	 * 
	 * @return true if list is empty, and false otherwise
	 *
	 *         Worst-case asymptotic running time cost: Theta(1)
	 *
	 *         Justification: We assume every basic operation takes Theta(1) time to
	 *         execute, since all we have in this method is 2 basic operations
	 *         (comparing 2 values and returning a value) the worst-case asymptotic
	 *         running time cost is Theta(1)
	 */
	public boolean isEmpty() {
		return head == null;
	}

	/**
	 * Inserts an element in the doubly linked list
	 * 
	 * @param pos
	 *            : The integer location at which the new data should be inserted in
	 *            the list. We assume that the first position in the list is 0
	 *            (zero). If pos is less than 0 then add to the head of the list. If
	 *            pos is greater or equal to the size of the list then add the
	 *            element at the end of the list.
	 * @param data
	 *            : The new data of class T that needs to be added to the list
	 * @return none
	 *
	 *         Worst-case asymptotic running time cost: Theta (n)
	 *
	 *         Justification: At worst you will have to go through every value in
	 *         the DLL to insert the data before the last node. In that case the
	 *         order of growth is Theta (n)
	 */
	public void insertBefore(int pos, T data) {
		DLLNode newNode;
		if (!isEmpty()) {
			if (pos <= 0) {
				newNode = new DLLNode(data, null, this.head);
				this.head.prev = newNode;
				this.head = newNode;
			} else {
				int nodeCounter = 0;
				for (DLLNode currentNode = head; currentNode != null; currentNode = currentNode.next) {
					if (pos == nodeCounter) {
						newNode = new DLLNode(data, currentNode.prev, currentNode);
						currentNode.prev = newNode;
						currentNode = newNode.prev;
						currentNode.next = newNode;
						return;
					}
					nodeCounter++;
				}
				newNode = new DLLNode(data, this.tail, null);
				this.tail.prev = newNode;
				this.tail = newNode;
			}
		} else {
			newNode = new DLLNode(data, null, null);
			this.head = newNode;
			this.tail = newNode;
		}
	}

	/**
	 * Returns the data stored at a particular position
	 * 
	 * @param pos
	 *            : the position
	 * @return the data at pos, if pos is within the bounds of the list, and null
	 *         otherwise.
	 *
	 *         Worst-case asymptotic running time cost: Theta (n)
	 *
	 *         Justification: At worst you will have to go through every value in
	 *         the DLL to get the last node. In that case the order of growth is
	 *         Theta (n)
	 *
	 */
	public T get(int pos) {
		int currentPos = 0;
		T data = null;
		DLLNode currentNode = head;
		if (pos < 0)
			return data;
		while (pos > currentPos) {
			currentNode = currentNode.next;
			if (currentNode == null)
				return data;
			currentPos++;
		}
		data = currentNode.data;
		return data;
	}

	/**
	 * Deletes the element of the list at position pos. First element in the list
	 * has position 0. If pos points outside the elements of the list then no
	 * modification happens to the list.
	 * 
	 * @param pos
	 *            : the position to delete in the list.
	 * @return true : on successful deletion, false : list has not been modified.
	 *
	 *         Worst-case asymptotic running time cost: Theta (n)
	 *
	 *         Justification: At worst you will have to go through every value in
	 *         the DLL to delete the data before the last node. In that case the
	 *         order of growth is Theta (n)
	 */
	public boolean deleteAt(int pos) {
		if (get(pos) == null)
			return false;
		else if (pos == 0) {
			if (head.next.next == tail) {
				head = null;
				tail = null;
			} else {
				head = head.next;
				head.prev = null;
			}
			return true;
		} else if (get(pos) == tail) {
			tail = tail.prev;
			tail.next = null;
			return true;
		} else {
			int currentPos = 0;
			DLLNode currentNode = head;
			while (currentPos < pos) {
				currentNode = currentNode.next;
				currentPos++;
			}
			currentNode.prev.next = currentNode.next;
			currentNode.next.prev = currentNode.prev;
			currentNode.prev = null;
			currentNode.next = null;
			return true;
		}
	}

	/**
	 * Reverses the list. If the list contains "A", "B", "C", "D" before the method
	 * is called Then it should contain "D", "C", "B", "A" after it returns.
	 *
	 * Worst-case asymptotic running time cost: Theta (n)
	 *
	 * Justification: You will have to go through every value in the DLL to change
	 * the order. In that case the order of growth is Theta (n)
	 */
	public void reverse() {
		if (!isEmpty() && head.next.next != tail) {
			DLLNode temp = head;
			head = tail;
			tail = temp;
			DLLNode current = head;
			while (current != null) {
				temp = current.next;
				current.next = current.prev;
				current.prev = temp;
				current = current.next;
			}
		}
	}

	/**
	 * Removes all duplicate elements from the list. The method should remove the
	 * _least_number_ of elements to make all elements unique. If the list contains
	 * "A", "B", "C", "B", "D", "A" before the method is called Then it should
	 * contain "A", "B", "C", "D" after it returns. The relative order of elements
	 * in the resulting list should be the same as the starting list.
	 *
	 * Worst-case asymptotic running time cost: Theta (n^2)
	 *
	 * Justification: You will have to go through compare every value to every other
	 * value. The order of growth of this is Theta(n)*Theta(n) = Theta (n^2)
	 */
	public void makeUnique() {
		for (int pos1 = 0; get(pos1) != null; pos1++)
			for (int pos2 = pos1 + 1; get(pos2) != null; pos2++)
				if (get(pos1) == get(pos2))
					deleteAt(pos2);
	}

	/*----------------------- STACK API 
	 * If only the push and pop methods are called the data structure should behave like a stack.
	 */

	/**
	 * This method adds an element to the data structure. How exactly this will be
	 * represented in the Doubly Linked List is up to the programmer.
	 * 
	 * @param item
	 *            : the item to push on the stack
	 *
	 *            Worst-case asymptotic running time cost: Theta(1)
	 *
	 *            Justification: You have to make the first item the second item and
	 *            the new item the first item, both of which are basic operation and
	 *            we therefore assume the have an order of growth of Theta(1).
	 */
	public void push(T item) {
		head.next = head;
		head = new DLLNode(item, null, head);
	}

	/**
	 * This method returns and removes the element that was most recently added by
	 * the push method.
	 * 
	 * @return the last item inserted with a push; or null when the list is empty.
	 *
	 *         Worst-case asymptotic running time cost: Theta (1)
	 *
	 *         Justification: At worst 4 methods will be called each are basic
	 *         operations and therefore have an order of growth of Theta (1).
	 */
	public T pop() {
		if (isEmpty()) {
			return null;
		} else {
			T data = head.data;
			head = head.next;
			return data;
		}
	}

	/*----------------------- QUEUE API
	 * If only the enqueue and dequeue methods are called the data structure should behave like a FIFO queue.
	 */

	/**
	 * This method adds an element to the data structure. How exactly this will be
	 * represented in the Doubly Linked List is up to the programmer.
	 * 
	 * @param item
	 *            : the item to be enqueued to the stack
	 *
	 *            Worst-case asymptotic running time cost: Theta (1)
	 *
	 *            Justification: At worst 7 methods will be called each are basic
	 *            operations and therefore have an order of growth of Theta (1).
	 */
	public void enqueue(T item) {
		if (isEmpty()) {
			DLLNode first = new DLLNode(item, null, null);
			head = first;
			tail = first;
		}
		DLLNode oldTail = tail;
		tail = new DLLNode(item, null, null);
		oldTail.prev = tail;
	}

	/**
	 * This method returns and removes the element that was least recently added by
	 * the enqueue method.
	 * 
	 * @return the earliest item inserted with an enqueue; or null when the list is
	 *         empty.
	 *
	 *         Worst-case asymptotic running time cost: Theta (1)
	 *
	 *         Justification: At worst 5 methods will be called each are basic
	 *         operations and therefore have an order of growth of Theta (1).
	 */
	public T dequeue() {
		if (isEmpty()) {
			return null;
		} else if (get(1) == tail) {
			head = null;
			tail = null;
			return null;
		} else {
			T data = head.data;
			head = head.next;
			return data;
		}
	}

	/**
	 * @return a string with the elements of the list as a comma-separated list,
	 *         from beginning to end
	 *
	 *         Worst-case asymptotic running time cost: Theta(n)
	 *
	 *         Justification: We know from the Java documentation that
	 *         StringBuilder's append() method runs in Theta(1) asymptotic time. We
	 *         assume all other method calls here (e.g., the iterator methods above,
	 *         and the toString method) will execute in Theta(1) time. Thus, every
	 *         one iteration of the for-loop will have cost Theta(1). Suppose the
	 *         doubly-linked list has 'n' elements. The for-loop will always iterate
	 *         over all n elements of the list, and therefore the total cost of this
	 *         method will be n*Theta(1) = Theta(n).
	 */
	public String toString() {
		StringBuilder s = new StringBuilder();
		boolean isFirst = true;

		// iterate over the list, starting from the head
		for (DLLNode iter = head; iter != null; iter = iter.next) {
			if (!isFirst) {
				s.append(",");
			} else {
				isFirst = false;
			}
			s.append(iter.data.toString());
		}

		return s.toString();
	}
}
