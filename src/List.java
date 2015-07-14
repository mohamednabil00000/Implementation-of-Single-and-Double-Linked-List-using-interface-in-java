public interface List<K> {

	public void insertAfter(K newNode, K node);

	public void insertBefore(K newNode, K node);

	public void insert(K val);

	public void insertBegining(K val);

	public void deleteFirst();

	public void deleteEnd();

	public void delete(int index);

	public K get(int index);

	public int getSize();

	public boolean isEmpty();

	public void traverse(int from, int to);

}
