class MyLinkedList {
	class Node {
	    private E element;
	    private Node next, previous;

	    public Node(Node before, Node after, Integer value) {
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
	    public Integer getValue() {
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
	    public Integer setValue(Integer i) {
		Integer old = element;
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
    	public boolean add(Integer value) {
        	Node newNode = new Node(end.previous(), end, value);
        	newNode.previous().setNext(newNode);
        	end.setPrevious(newNode);
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

    	public Integer get(int index) {
        	if (index < 0 || index >= size) {
            		throw new IndexOutOfBoundsException(index + " is not an index of this list");
        	}
        	return find(index).getValue();
    	}
    	public boolean contains(Integer value) {
        	Node checked = start.next();
        	while(checked != end && checked.getValue() != value) {
            		checked = checked.next();
        	}
        	return checked != end;
    	}
    	public int indexOf(Integer value) {
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

    	public E set(int index, Integer value) {
        	if (index < 0 || index >= size) {
            		throw new IndexOutOfBoundsException(index + " is not an index of this list");
        	}
        	Node foundIt = find(index);
        	Integer old = foundIt.getValue();
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
