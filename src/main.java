public class main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		SingleLinkedList<Integer> s = new SingleLinkedList<>();
		DoubleLinkedList<Integer> d = new DoubleLinkedList<>();

		for (int i = 0; i < 10; i++) {
			d.insertBegining(i);
		}

		//d.deleteFirst();
		//d.deleteEnd();
		//d.deleteEnd();
		// d.deleteFirst();
	//	 System.out.println(d.get(10));
		d.insertBefore(300, 5);
		d.insertBefore(500,300);
		d.insertBefore(100, 9);
		d.insertAfter(10000, 0);
		d.insertAfter(20000,10000);
		d.insertAfter(5555555,100);
		d.traverse(0, d.getSize());
	}

}
