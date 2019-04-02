public class TestDriver {
	public static void main(String[] args) {
		MyLinkedList<Integer> testList = new MyLinkedList<Integer>();
		//testList.addLast(-1);
		testList.addFirst(12);
		System.out.println(testList);
		MyLinkedList<Integer> otherOne = new MyLinkedList<Integer>();
		for (int i = 0; i < 10; i++) {
			otherOne.addFirst(i);
			otherOne.addLast(-i);
		}
		testList.concat(otherOne);
		System.out.println(testList);
		System.out.println(otherOne);
		while (testList.hasNext()) {
			System.out.println(testList.nextElement());
		}
	}
}
