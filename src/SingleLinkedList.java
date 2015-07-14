public class SingleLinkedList<K> implements List<K> {

	private static Node head = null;
	private static Node Last = null;
	private static int size = 0;

	@Override
	public void insertAfter(K newNode, K node) {
		Node p = head;

		for (int i = 0; i < size; i++) {
			if (p.val.equals(node)) {
				if (i == size - 1) {
					insert(newNode);
				} else {
					Node newnode = new Node(newNode);
					newnode.next = p.next;
					p.next = newnode;
					size++;
				}
				break;
			}
			p = p.next;
		}

	}

	@Override
	public void insertBefore(K newNode, K node) {
		Node p = head;
		Node pBef = head;
		for (int i = 0; i < size; i++) {

			if (p.val.equals(node)) {
				if (i == 0)
					insertBegining(newNode);
				else {
					Node newnode = new Node(newNode);
					pBef.next = newnode;
					newnode.next = p;
					size++;
				}
				break;
			}
			pBef = p;
			p = p.next;
		}

	}

	@Override
	public void insert(K val) {

		Node newNode = new Node(val);
		if (size == 0) {
			head = newNode;
			Last = newNode;
		} else {
			Last.next = newNode;
			Last = newNode;
		}
		size++;

	}

	@Override
	public void insertBegining(K val) {
		Node newNode = new Node(val);

		if (size == 0) {
			head = newNode;
			Last = newNode;
		} else {
			newNode.next = head;
			head = newNode;
		}
		size++;
	}

	@Override
	public void deleteFirst() {
		if (size < 2) {
			head = null;
			Last = null;

		} else {
			head = head.next;
		}

		size = Math.max(size - 1, 0);

	}

	@Override
	public void deleteEnd() {
		if (size < 2) {
			head = null;
			Last = null;

		} else {
			Node p = head;
			for (int i = 0; i < size - 2; i++)
				p = p.next;

			Last = p;
			Last.next = null;
		}

		size = Math.max(size - 1, 0);

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
		for (int i = 0; i < index - 1; i++) {
			p = p.next;
		}
		Node del = p.next;
		p.next = del.next;
		size = Math.max(size - 1, 0);

	}

	@Override
	public K get(int index) {
		if (index >= size || index < 0)
			return null;
		Node p = head;
		for (int i = 0; i < index; i++)
			p = p.next;

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
		for (int i = 0; i < from; i++)
			p = p.next;

		for (int i = from; i < to; i++) {
			System.out.println(p.val);
			p = p.next;
		}

	}

}
