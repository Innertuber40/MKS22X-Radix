class MyLinkedList<E> {
	class Node {
	    private E element;
	    private Node next, previous;

	    public Node(Node before, Node after, E value) {
		element = value;
		previous = before;
		next = after;
	    }

	    public Node next() {
		return next;
	    }
	    public Node previous() {
		return previous;
	    }
	    public E getValue() {
		return element;
	    }
	    public String toString() {
		return "" + element;
	    }

	    public void setNext(Node newby) {
		next = newby;
	    }
	    public void setPrevious(Node newby) {
		previous = newby;
	    }
	    public E setValue(E i) {
		E old = element;
		element = i;
		return old;
	    }
	}
	private int size;
	private Node start, end;

	public MyLinkedList() {
        	start = new Node(null, end, null);
        	end = new Node(start, null, null);
        	start.setNext(end);
        	size = 0;
    	}

    	public int size() {
        	return size;
    	}
    	public boolean addLast(E value) {
        	Node newNode = new Node(end.previous(), end, value);
        	newNode.previous().setNext(newNode);
        	end.setPrevious(newNode);
        	size++;
        	return true;
    	}
    	public boolean addFirst(E value) {
        	Node newNode = new Node(start, start.next(), value);
        	start.setNext(newNode);
        	newNode.next().setPrevious(newNode);
        	size++;
        	return true;
    	}
    	public String toString() {
        	Node now = start.next();
        	String returns = "";
        	while(now != end) {
            		returns = returns + now.toString() + " ";
            		now = now.next();
        	}
        	return returns;
	}

    	public E get(int index) {
        	if (index < 0 || index >= size) {
            		throw new IndexOutOfBoundsException(index + " is not an index of this list");
        	}
        	return find(index).getValue();
    	}
    	public boolean contains(E value) {
        	Node checked = start.next();
        	while(checked != end && checked.getValue() != value) {
            		checked = checked.next();
        	}
        	return checked != end;
    	}
    	public int indexOf(E value) {
        	Node checked = start.next();
        	int index = 0;
        	while(checked != end && checked.getValue() != value) {
            		checked = checked.next();
            		index++;
        	}
        	if (checked == end) {
            		return -1;
        	} else {
            		return index;
        	}
    	}

    	public E set(int index, E value) {
        	if (index < 0 || index >= size) {
            		throw new IndexOutOfBoundsException(index + " is not an index of this list");
        	}
        	Node foundIt = find(index);
        	E old = foundIt.getValue();
        	foundIt.setValue(value);
        	return old;
    	}

    	private Node find(int index) {
        	Node returns = start;
        	for(int i = 0; i <= index; i++) {
            		returns = returns.next();
        	}
        	return returns;
    	}
}
