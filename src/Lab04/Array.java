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
	
	public void quickSort(){
		quickSort(2,getSize()-1);
	}
	
	private void quickSort(int p, int r){
		int q;
		if(p<r){
			q = partition(p,r);
			quickSort(p,q-1);
			quickSort(q+1,r);
			
		}
	}
	
	private int partition(int p, int r){
		int x = arr[r];
		int i = p-1;
		
		for(int j=p; j<r; j++){
			if(arr[j]<=x){
				i = i+1;
				swap(arr[i],arr[j]);
			}
		}
		swap(arr[i+1],arr[r]);
		return i+1;
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
