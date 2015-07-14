public class Node<K> {
	K val;
	Node next;
	Node prev;

	Node(K val) {
		this.val = val;
		next = null;
		prev = null;
	}
}
