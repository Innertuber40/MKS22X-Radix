import java.util.ArrayList;

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
		int[] testInts = new int[] {-645, 500, 43, 0, - 62, 0, -13455, -333, -44323, -5532, -1, -1, -9, -1, -9, 8, 9, -19};
		Radix.radixsort(testInts);
		for (int i = 0; i < testInts.length; i++) {
			System.out.print(testInts[i] + " ");
		}
		/*int[] bigRandom = new int[10000];
		for (int i = 0; i < 10000; i++) {
			int multiplier = -1;
			if (Math.random() < 0.5) {
				multiplier = 1;
			}
			bigRandom[i] = (int)(Math.random() * 100000) * multiplier;
		}
		ArrayList<Integer> other = new ArrayList(10000);
		for (int i = 0; i < 10000; i++) {
			other.add(bigRandom[i]);
		}
		System.out.println();
		/*for (int i = 0; i < 10000; i++) {
			if (other.get(i) != bigRandom[i]) {
				System.out.println(false);
			}
		}
		Radix.radixsort(bigRandom);
		other.sort(null);
		//System.out.println(other);
		for (int i = 0; i < 10000; i++) {
			if (other.get(i) != bigRandom[i]) {
				System.out.print(other.get(i) + " " + bigRandom[i] + " ");
			}
		}*/
	}
}
