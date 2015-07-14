public class DoubleLinkedList<K> implements List<K> {
	private static int size = 0;
	private static Node head = null;
	private static Node last = null;

	@Override
	public void insertAfter(K newNode, K node) {
		Node p = head;
		for (int i = 0; i < size; i++) {
			if (p.val.equals(node)) {

				if (i == size - 1)
					insert(newNode);

				else {
					Node newnode = new Node(newNode);
					p.next.prev = newnode;
					newnode.next = p.next;
					p.next = newnode;
					newnode.prev = p;
					size++;

				}
				return;
			}
			p = p.next;
		}

	}

	@Override
	public void insertBefore(K newNode, K node) {
		Node p = head;

		for (int i = 0; i < size; i++) {
			if (p.val.equals(node)) {
				if (i == 0)
					insertBegining(newNode);
				else {
					Node newnode = new Node(newNode);
					p.prev.next = newnode;
					newnode.prev = p.prev;
					p.prev = newnode;
					newnode.next = p;
					size++;
				}
				return;
			}
			p = p.next;
		}

	}

	@Override
	public void insert(K val) {
		Node newnode = new Node(val);
		if (size == 0) {
			head = newnode;
		} else {
			last.next = newnode;
			newnode.prev = last;
		}
		last = newnode;
		size++;

	}

	@Override
	public void insertBegining(K val) {
		Node newnode = new Node(val);
		if (size == 0) {
			head = newnode;
			last = newnode;
		} else {
			newnode.next = head;
			head.prev = newnode;
			head = newnode;
		}
		size++;

	}

	@Override
	public void deleteFirst() {
		if (size == 0)
			return;
		if (size == 1) {
			head = null;
			last = null;
			size--;
			return;
		}
		head = head.next;
		head.prev = null;

		size--;

	}

	@Override
	public void deleteEnd() {
		if (size == 0)
			return;

		if (size == 1) {
			head = null;
			last = null;
			size--;
			return;
		}

		last = last.prev;
		last.next = null;
		size--;

	}

	@Override
	public void delete(int index) {
		if (index >= size || index < 0)
			return;

		if (index == 0) {
			deleteFirst();
			return;
		}
		if (index == size - 1) {
			deleteEnd();
			return;
		}
		Node p = head;
		for (int i = 0; i < index; i++) {
			p = p.next;
		}
		Node aft = p.next;
		Node bef = p.prev;
		bef.next = aft;
		aft.prev = bef;
		size = Math.max(size - 1, 0);

	}

	@Override
	public K get(int index) {
		if (index >= size || index < 0)
			return null;
		Node p;
		if (index < size - index) {
			p = head;
			for (int i = 0; i < index; i++)
				p = p.next;
		} else {
			p = last;
			for (int i = 0; i < size - index - 1; i++) {
				p = p.prev;
			}
		}

		return (K) p.val;
	}

	@Override
	public int getSize() {

		return size;
	}

	@Override
	public boolean isEmpty() {

		return size == 0 ? true : false;
	}

	@Override
	public void traverse(int from, int to) {
		Node p = head;
		for (int i = 0; i < from; i++) {
			p = p.next;
		}
		for (int i = from; i < to; i++) {
			System.out.println(p.val);
			p = p.next;
		}

	}

}
