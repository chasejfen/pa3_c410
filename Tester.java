
import java.util.PriorityQueue;
import java.util.Random;

public class Tester<C extends Comparable<? super C>> {
	public static int N = 5000;
	public static Double[] arr;
	public static int child;
	public static double tmp;

	public static void main(String[] args) {

		PQ<Double> pq1 = new PQasSortedArray<Double>(N);
		PriorityQueue<Double> pq2 = new PriorityQueue<Double>(N);
		double[] arr1 = new double[N];
		double[] arr2 = new double[N];
		double[] arr3 = new double[N];
		for (int i = 0; i < arr1.length; i++) {
			Random rand = new Random();
			arr1[i] = rand.nextDouble();
			arr2[i] = arr1[i];
			arr3[i] = arr1[i];
		}

		// timing for insert of PQasSortedArray
		long startTime, endTime;
		startTime = System.nanoTime();

		for (int i = 0; i < arr1.length; i++)
			pq1.insert(arr1[i]);
		endTime = System.nanoTime();
		System.out.println("PQasArray took " + ((endTime - startTime) / 1000000) + " time units");

		// timing for offer of java's PQ
		long startTime2, endTime2;
		startTime2 = System.nanoTime();

		for (int i = 0; i < arr1.length; i++)
			pq2.offer(arr1[i]);

		endTime2 = System.nanoTime();
		System.out.println("java PQ took " + ((endTime2 - startTime2) / 1000000) + " time units");

		// timing for heapSort
		long startTime3, endTime3;
		startTime3 = System.nanoTime();

		HeapSort(arr3);

		endTime3 = System.nanoTime();
		System.out.println("heapsort took " + ((endTime3 - startTime3) / 1000000) + " time units");
	}

	static void HeapSort(double[] arr3) {
		for (int i = arr3.length / 2 - 1; i >= 0; i--)
			percDown(arr3, i, arr3.length);
		for (int i = arr3.length - 1; i > 0; i--) {
			swap(arr3, 0, i);
			percDown(arr3, 0, i);
		}
	}

	private static void swap(double[] arr2, int x, int y) {
		arr2[x] = arr2[x] + arr2[y];
		arr2[y] = arr2[x] - arr2[y];
		arr2[x] = arr2[x] - arr2[y];
	}

	private static int leftChild(int i) {
		return 2 * i + 1;
	}

	private static void percDown(double[] arry, int i, int n) {
		for (tmp = arry[i]; leftChild(i) < n; i = child) {
			child = leftChild(i);
			if (child != n - 1 && arry[child] < arry[child + 1])
				child++;
			if (tmp < arry[child])
				arry[i] = arry[child];
			else
				break;
		}
		arry[i] = tmp;
	}
}
