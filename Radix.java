public class Radix {
	public static void radixsort(int[] data) {
		int layers = 0;
		MyLinkedList<Integer>[] bucketDump = new MyLinkedList[20];
		for (int i = 0; i < 20; i++) {
			bucketDump[i] = new MyLinkedList<Integer>();
		}
		for (int i = 0; i < data.length; i++) {
			int value = data[i];
			if (Math.abs(value / 10) >= layers * 10) {
				layers++;
			}
			if (value < 0) {
				bucketDump[9 - Math.abs(value) % 10].addFirst(value);
			} else {
				bucketDump[10 + value % 10].addLast(value);
			}
		}
		int currentLayer = 1;
		while (currentLayer <= layers) {
			MyLinkedList<Integer> negaCatted = new MyLinkedList<Integer>();
			MyLinkedList<Integer> posiCatted = new MyLinkedList<Integer>();
			for (int i = 0; i < 10; i++) {
				negaCatted.concat(bucketDump[i]);
			}
			System.out.println(negaCatted);
			for (int i = 10; i < 20; i++) {
				posiCatted.concat(bucketDump[i]);
			}
			System.out.println(posiCatted);
			while(negaCatted.hasNext()) {
				int value = negaCatted.nextElement();
				bucketDump[9 - Math.abs(value) / (int)Math.pow(10, currentLayer) % 10].addLast(value);
			}
			while(negaCatted.hasNext()) {
				int value = posiCatted.nextElement();
				bucketDump[10 + value / (int)Math.pow(10, currentLayer) % 10].addLast(value);
			}
			currentLayer++;
		}
		MyLinkedList<Integer> catted = new MyLinkedList<Integer>();
		for (int i = 0; i < 20; i++) {
			catted.concat(bucketDump[i]);
		}
		for (int i = 0; i < data.length; i++) {
			while (catted.hasNext()) {
				data[i] = catted.nextElement();
			}
		}
	}
}	
