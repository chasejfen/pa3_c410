
public class PQasSortedArray<C extends Comparable<? super C>> implements PQ<C> {
	C[] arr;
	int currentSize;
	C min;

	@SuppressWarnings("unchecked")
	public PQasSortedArray(int size) {
		arr = (C[]) new Comparable[size + 1];
		currentSize = 0;
	}

	public void insert(C data) {
		currentSize++;
		int i = currentSize;
		arr[i] = data;
		percUp();
	}

	public C min() {
		if (!isEmpty())
			return arr[1];
		else
			return null;
	}

	public C deleteMin() {
		C minval = min();
		arr[1] = arr[currentSize];
		arr[currentSize] = null;
		currentSize--;
		percDown();
		return minval;
	}

	void percDown() {
		int i = 1;
		while (hasLeftChild(i)) {
			int childMin = lefti(i);
			if (hasRightChild(i) && arr[lefti(i)].compareTo(arr[righti(i)]) > 0) {
				childMin = righti(i);
			}
			if (arr[i].compareTo(arr[childMin]) > 0) {
				swap(i, childMin);
			} else {
				break;
			}
			i = childMin;
		}
	}

	void percUp() {
		int i = this.currentSize;
		while (hasParent(i) && (parent(i).compareTo(arr[i]) > 0)) {
			swap(i, parenti(i));
			i = parenti(i);
		}
	}

	boolean hasParent(int i) {
		return i > 1;
	}

	int lefti(int i) {
		return i * 2;
	}

	int righti(int i) {
		return i * 2 + 1;
	}

	boolean hasLeftChild(int i) {
		return lefti(i) <= currentSize;
	}

	boolean hasRightChild(int i) {
		return righti(i) <= currentSize;
	}

	C parent(int i) {
		return arr[parenti(i)];
	}

	int parenti(int i) {
		return i / 2;
	}

	void swap(int i1, int i2) {
		C tmp = arr[i1];
		arr[i1] = arr[i2];
		arr[i2] = tmp;
	}

	public boolean isFull() {
		return currentSize == arr.length;
	}

	public boolean isEmpty() {
		return currentSize == 0;
	}

}