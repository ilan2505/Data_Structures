package Ex4;

import java.util.Arrays;

/**
 * 
 * @author Asaly Saed Maximum heap class - Data structures course, Ariel
 *         University - 2020.
 */
public class MaxHeap {
	int[] arr;
	int last;
	int size;

	public MaxHeap(int size) {
		this.size = size;
		arr = new int[size];
		last = -1;
	}

	public boolean Add(int data) {
		if (last == size - 1)
			return false;
		arr[++last] = data;
		Heapify_Up(last);
		return true;
	}

	private void Heapify_Up(int pos) {
		if (pos == 0)
			return;
		int parent = (int) (Math.floor((pos - 1) / 2));
		if (arr[pos] > arr[parent]) {
			swap(arr, pos, parent);
			Heapify_Up(parent);
		}

	}

	private void swap(int[] arr, int from, int to) {
		int tmp = arr[from];
		arr[from] = arr[to];
		arr[to] = tmp;
	}

	public int Delete() {
		if (last != 0) {
			int tmp = arr[0];
			swap(arr, 0, last--);
			Heapify_down(0);
			return tmp;
		} else if (last == 0) {
			int tmp = arr[0];
			last = -1;
			return tmp;
		} else {
			return Integer.MAX_VALUE;
		}
	}

	private void Heapify_down(int pos) {
		int left, right;
		left = 2 * pos + 1;
		right = 2 * pos + 2;
		if ((left == last) && ((arr[pos] < arr[left]))) {
			swap(arr, pos, left);
			return;
		}
		if ((right == last) && (arr[right] > arr[left]) && (arr[pos] < arr[right])) {
			swap(arr, pos, right);
			return;
		} else if ((right == last) && (arr[right] < arr[left]) && (arr[pos] < arr[left])) {
			swap(arr, pos, left);
			return;
		}
		if (left >= last || right >= last) {
			return;
		}
		if ((arr[left] > arr[right]) && (arr[pos] <= arr[left])) {
			swap(arr, pos, left);
			Heapify_down(left);
		} else if (arr[pos] < arr[right]) {
			swap(arr, pos, right);
			Heapify_down(right);
		}
	}

	public static void HeapSort(int[] arr) {
		MaxHeap h = new MaxHeap(arr.length);
		for (int i = 0; i < arr.length; i++) {
			h.Add(arr[i]);
		}
		for (int i = 0; i < arr.length; i++) {
			h.Delete();
			System.out.println(Arrays.toString(h.arr));
		}
		for (int i = 0; i < arr.length; i++)
			arr[i] = h.arr[i];
	}
	
	//build heap from array
	private void Heapify(){
		for (int i = (last+1) / 2 - 1; i >= 0; i--){
				Heapify_down(i);			
		}
	}
	
	public static MaxHeap mergeTwoHeaps(MaxHeap h1, MaxHeap h2) {
		MaxHeap mh = new MaxHeap(h1.last+1 + h2.last+1);
		// copy first heap as array
		for (int i = 0; i <= h1.last; i++) {
			mh.arr[i] = h1.arr[i];
		}
		mh.last = h1.last;
		// copy 2nd array
		for (int i = 0; i <= h2.last; i++) {
			mh.arr[++mh.last] = h2.arr[i];
		}
		//heapify
		mh.Heapify();
		return mh;
	}

	public static int[] getMinHeap(MaxHeap h) {
		MaxHeap minHeap = new MaxHeap(h.last+1);
		for (int i = 0; i <= h.last; i++) {
			minHeap.arr[i] = -1*h.arr[i];
		}
		minHeap.last = h.last;
		minHeap.Heapify();
		for (int i = 0; i <= h.last; i++) {
			minHeap.arr[i] *= -1;
		}
		return minHeap.arr;
	}
	
	public void printHeap(){
		for (int i = 0; i <=last; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}

	public static void main(String args[]){
		MaxHeap mh1 = new MaxHeap(8);
		mh1.Add(11);
		mh1.Add(7);
		mh1.Add(9);
		mh1.Add(2);
		
		MaxHeap mh2 = new MaxHeap(8);
		mh2.Add(15);
		mh2.Add(6);
		mh2.Add(14);
		mh2.Add(3);
		mh2.Add(6);
		
		MaxHeap merged = mergeTwoHeaps(mh1, mh2);
		merged.printHeap();
		
		
		int[] min1 = getMinHeap(mh1);
		int[] min2 = getMinHeap(mh2);
		int[] minH = getMinHeap(merged);
		System.out.println(Arrays.toString(min1));
		System.out.println(Arrays.toString(min2));
		System.out.println(Arrays.toString(minH));
	}
}
