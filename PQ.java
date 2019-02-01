
public interface PQ<C extends Comparable<? super C>> {
	public boolean isFull();

	public boolean isEmpty();

	public void insert(C data); // Precondition: Not full

	public C min(); // Precondition: Not empty

	public C deleteMin(); // Precondition: Not empty
}
