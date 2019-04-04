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
			System.out.print(testList.nextElement() + " ");
		}
		System.out.println();
		int[] testInts = new int[] {-645, 500, 43, 0, 0, -13455, -1, -1, -9, -1, -9, 8, 9};
		Radix.radixsort(testInts);
		for (int i = 0; i < testInts.length; i++) {
			System.out.print(testInts[i] + " ");
		}
	}
}
