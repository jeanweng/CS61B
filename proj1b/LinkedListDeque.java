//package proj1a;

public class LinkedListDeque<T> implements Deque<T> {

	private class Node {
		private T _item;
		private Node _next;
		private Node _prev;
		public Node(T i, Node p, Node n) {
			_item = i;
			_prev = p;
		 	_next = n;
		}
		public T getItem() {
			return _item;
		}
	}

	private Node sentinel;
	private int size = 0;

	public LinkedListDeque() {
		sentinel = new Node(null, null, null);
		sentinel._next = sentinel;
		sentinel._prev = sentinel;
		size = 0;
	}

	// public LinkedListDeque(T x) {
	// 	  sentinel = new Node(null, null, null);
	// 	  Node node = new Node(x, sentinel, sentinel);
	// 	  sentinel._next = node;
	// 	  sentinel._prev = node;
	//    	size = 1;
	// }
	//
	// /*
	//  * Creates a deep copy of other
	//  */
  // public LinkedListDeque(LinkedListDeque other) {
	// 	  sentinel = new Node(null, null, null);
	// 	  sentinel._next = sentinel;
	// 	  sentinel._prev = sentinel;
	//    	size = 0;
	//
	// 	  for(int i = 0; i < other.size(); i++) {
	//    			addLast((T) other.get(i));
	// 	  }
  // }

	/*
	 * Adds an item of type T to the front of the deque
	 */
	public void addFirst(T item) {
		Node node = new Node(item, sentinel, sentinel._next);
		sentinel._next = node;
		node._next._prev = node;
		size++;
	}

	/*
	 * Adds an item of type T to the back of the deque
	 */
	public void addLast(T item) {
		Node node = new Node(item, sentinel._prev, sentinel);
		sentinel._prev = node;
		node._prev._next = node;
		size++;
	}	

	/*
	 * Returns true if deque is empty, false otherwise
	 */
	public boolean isEmpty() {
		return size == 0;
	}

	/*
	 * Returns the number of items in the deque
	 */
	public int size() {
		return size;
	}

	/*
	 * Prints the items in the deque from first to last
	 */
	public void printDeque() {
		Node p = sentinel._next;
		while(p != null && p._item != null) {
			System.out.print(p._item + " ");
			p = p._next;
		}
		System.out.println();
	}

	/*
	 * Removes and returns the item at the front of the deque. If no such item
	 * exists, returns null
	 */
	public T removeFirst() {
		if(size == 0) {
			return null;
			}
		Node removed = sentinel._next;
		sentinel._next = sentinel._next._next;
		sentinel._next._prev = sentinel;
		size--;
		return removed.getItem();
	}

	/*
	 * Removes and returns the item at the back of the deque. If no such item
	 * exists, returns null
	 */
	public T removeLast() {
		if(size == 0) {
			return null;
		}
		Node removed = sentinel._prev;
		sentinel._prev = sentinel._prev._prev;
		sentinel._prev._next = sentinel;
		size--;
		return removed.getItem();
	}

	/*
	 * Gets the item at the given index using iteration. If no such item exists,
	 * returns null
	 */
	public T get(int index) {
		if (index > size) {
			return null;
		}
		Node p = sentinel._next;
		while (index > 0) {
			p = p._next;
			index--;
		}
		return p.getItem();
	}

	/*
	 * Gets the item at the given index using recursion. If no such item exists,
	 * returns null
	 */
	public T getRecursive(int index) {
		if (index > size) {
			return null;
		}
		return getRecursive(index, sentinel._next);
	}

	/*
	 * Helper function for getRecursive(int index).
	 */
	private T getRecursive(int index, Node n) {
		if (index == 0) {
			return n.getItem();
		}
		return getRecursive(index - 1, n._next);
	}
}
