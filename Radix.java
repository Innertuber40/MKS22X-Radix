public class Radix {
	public static void radixsort(int[] data) {
		int layers = 0;
		MyLinkedList<Integer>[] bucketDump = new MyLinkedList[10];
		for (int i = 0; i < 10; i++) {
			bucketDump[i] = new MyLinkedList<Integer>();
		}
		for (int i = 0; i < data.length; i++) {
			int value = data[i];
			if (Math.abs(value / 10) >= layers * 10) {
				layers++;
			}
			if (value < 0) {
				bucketDump[Math.abs(value) % 10].addFirst(value);
			} else {
				bucketDump[value % 10].addLast(value);
			}
		}
		MyLinkedList<Integer> catted = bucketDump[0];
		for (int i = 1; i < 10; i++) {
			catted.concat(bucketDump[i]);
		}
		int currentLayer = 2;
		while (currentLayer <= layers) {
			while(catted.hasNext()) {
				int value = catted.nextElement();
				if (value < 0) {
					bucketDump[Math.abs(value) / Math.pow(10, currentLayer) % 10].addFirst(value);
				} else {
					bucketDump[value % 10].addLast(value);
				}
			}
		}
		for (int i = 0; i < data.length; i++) {
			data[i] = catted.nextElement();
		}
	}
}	
