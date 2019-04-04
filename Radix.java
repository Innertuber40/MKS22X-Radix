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
		int currentLayer = 1;
		while (currentLayer <= layers) {
			MyLinkedList<Integer> catted = new MyLinkedList<Integer>();
			for (int i = 0; i < 10; i++) {
				catted.concat(bucketDump[i]);
			}
			System.out.println(catted);
			while(catted.hasNext()) {
				int value = catted.nextElement();
				if (value < 0) {
					bucketDump[Math.abs(value) / (int)Math.pow(10, currentLayer) % 10].addBreakOff(value);
					System.out.println(bucketDump[Math.abs(value) / (int)Math.pow(10, currentLayer) % 10]);
				} else {
					bucketDump[value / (int)Math.pow(10, currentLayer) % 10].addLast(value);
				}
			}
			currentLayer++;
		}
		/*MyLinkedList<Integer> catted = new MyLinkedList<Integer>();
		for (int i = 0; i < 10; i++) {
			catted.concat(bucketDump[i]);
		}
		System.out.println(catted);*/
		int currentIndex = 0;
		for (int i = 9; i >= 0; i--) {
			while (bucketDump[i].hasNeakoff()) {
				int value = bucketDump[i].nextElement();
				data[currentIndex] = value;
				currentIndex++;
			}
		}
		for (int i = 0; i < 10; i++) {
			while (bucketDump[i].hasNext()) {
				data[currentIndex] = bucketDump[i].nextElement();
				currentIndex++;
			}
		}
	}
}	
