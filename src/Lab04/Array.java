package Lab04;
/**
 * Implementation of Array
 * 
 * @author Somsubhra
 * 
 */
public class Array {

	private int size;
	private int[] arr;

	/**
	 * Constructs an empty array with given maximum size.
	 * 
	 * @param maxsize
	 *            The maximum size of the Array
	 */
	public Array(int maxsize) {

		size = 0;
		arr = new int[maxsize];

	}

	/**
	 * Inserts a new item in the Array.
	 * 
	 * @param item
	 *            The item to be inserted in the Array
	 */
	public void insert(int item) {

		arr[size] = item;
		size++;

	}

	/**
	 * Displays the Array.
	 */
	public void display() {
		for (int i = 0; i < getSize(); i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.print("\n");
	}

	/**
	 * Finds the size of the array.
	 * 
	 * @return The size of the Array
	 */
	public int getSize() {
		return size;
	}

	/**
	 * Finds the element of the Array at the index specified.
	 * 
	 * @param i
	 *            The index of the element to be fetched
	 * @return The element from the Array at the given index
	 */
	public int get(int i) {

		return arr[i];
	}

	/**
	 * Finds the maximum element in the Array.
	 * 
	 * @return The maximum element in the Array
	 */
	public int getMaximum() {

		int max = arr[0];

		for (int i = 1; i < getSize(); i++) {

			if (arr[i] > max) {

				max = arr[i];
			}
		}

		return max;
	}

	/**
	 * Finds the minimum element in the Array.
	 * 
	 * @return The minimum element in the Array
	 */

	public int getMinimum() {

		int min = arr[0];

		for (int i = 1; i < getSize(); i++) {

			if (arr[i] < min) {

				min = arr[i];
			}
		}

		return min;
	}

	/**
	 * Swaps two elements of the Array.
	 * 
	 * @param i
	 *            The first element to be swapped
	 * @param j
	 *            The second element to be swapped
	 */
	public void swap(int i, int j) {

		int tmp = arr[i];
		arr[i] = arr[j];
		arr[j] = tmp;
	}

	/**
	 * Sorts the Array using merge-sort technique.
	 */
	public void mergeSort() {
		mergeSort(0, getSize() - 1);
	}

	/**
	 * Sorts the Array in the given range recursively using merge-sort.
	 * 
	 * @param start
	 *            The starting element of the Array
	 * @param end
	 *            The last element of the Array
	 */
	private void mergeSort(int start, int end) {

		if (start < end) {
			int middle = (start + end) / 2;
			mergeSort(start, middle);
			mergeSort(middle + 1, end);
			merge(start, middle, end);
		}
	}

	/**
	 * Merges two Arrays for merge sort.
	 * 
	 * @param start
	 *            The starting element of the merged Array
	 * @param middle
	 *            The middle element of the merged Array
	 * @param end
	 *            The last element of the merged Array
	 */
	private void merge(int start, int middle, int end) {
		int[] tmp = new int[getSize()];
		for (int i = start; i <= end; i++) {
			tmp[i] = arr[i];

		}

		int i = start;
		int j = middle + 1;
		int k = start;

		while (i <= middle && j <= end) {
			if (tmp[i] <= tmp[j]) {
				arr[k] = tmp[i];
				i++;
			}

			else {
				arr[k] = tmp[j];
				j++;
			}
			k++;

		}

		while (i <= middle) {
			arr[k] = tmp[i];
			k++;
			i++;
		}
	}

	/**
	 * Sorts the Array using bubble-sort technique.
	 */
	public void bubbleSort() {
		for (int i = 0; i < getSize(); i++) {
			for (int j = 0; j < getSize() - i - 1; j++) {
				if (arr[j] > arr[j + 1]) {
					swap(j, j + 1);
				}
			}
		}
	}

	/**
	 * Sorts the Array using selection-sort technique.
	 */
	public void selectionSort() {
		int out, in, min;

		for (out = 0; out < getSize() - 1; out++) {
			min = out;
			for (in = out + 1; in < getSize(); in++) {
				if (arr[in] < arr[min]) {
					min = in;
				}
			}
			swap(out, min);
		}
	}

	/**
	 * Sorts the Array using insertion-sort technique.
	 */
	public void insertionSort() {
		int in, out;
		for (out = 1; out < getSize(); out++) {
			int temp = arr[out];
			in = out;

			while (in > 0 && arr[in - 1] >= temp) {
				arr[in] = arr[in - 1];
				in--;
			}
			arr[in] = temp;
		}
	}

	/**
	 * Sorts the Array using Quick Sort technique.
	 */
	public void quickSort() {
		quickSort(0, getSize() - 1);
	}

	/**
	 * Sorts the array in the given range recursively using quick sort.
	 * 
	 * @param p
	 *            The starting element of the array
	 * @param r
	 *            The ending element of the array
	 */
	private void quickSort(int start, int end) {

		if (start < end) {
			int q = partition(start, end);
			quickSort(start, q);
			quickSort(q + 1, end);

		}
	}

	/**
	 * Partitions the Array for quick sort.
	 * 
	 * @param p
	 *            The starting element of the array
	 * @param r
	 *            The ending element of th array
	 * @return The partition location
	 */
	private int partition(int start, int end) {
		int x = arr[start];
		int i = start - 1;
		int j = end + 1;

		while (true) {
			i++;
			while (i < end && arr[i] < x) {
				i++;
			}
			j--;
			while (j > start && arr[j] > x) {
				j--;
			}

			if (i < j) {
				swap(i, j);
			} else {
				return j;
			}
		}
	}

	/**
	 * Search for an item using Linear Search.
	 * 
	 * @param item
	 *            The item to be searched
	 * @return The index of the item found
	 */
	public int linearSearch(int item) {
		int i;
		for (i = 0; i < getSize(); i++) {
			if (arr[i] == item) {
				break;
			}
		}

		if (i < getSize()) {
			return i;
		} else {
			return (-1);
		}
	}

	/**
	 * Searches for an item using Binary Search.
	 * 
	 * @param item
	 *            The item to be searched
	 * @return The rank of the item found
	 */
	public int binarySearch(int item) {
		Array tmp = new Array(getSize());
		for (int i = 0; i < getSize(); i++) {
			tmp.insert(arr[i]);
		}
		tmp.bubbleSort();

		int start = 0;
		int end = tmp.getSize() - 1;
		int current;

		while (true) {
			current = (start + end) / 2;

			if (tmp.get(current) == item) {
				return current;
			}

			else if (start > end) {
				return (-1);
			}

			else {
				if (tmp.get(current) < item) {
					start = current + 1;
				}

				else {
					end = current - 1;
				}
			}
		}
	}

}
