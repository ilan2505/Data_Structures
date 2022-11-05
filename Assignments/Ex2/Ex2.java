package A_Matala2;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Random;
public class Ex2 {
	static Random rand = new Random();

	

	// Q3.1
	public static void mergeSort2(int[] arr) {
		// working with small sub arrays 1,2,4..n/2 
		for (int subArraySize = 1; subArraySize < arr.length; subArraySize = 2 * subArraySize) {
			for (int low = 0; low < arr.length - 1; low += 2 * subArraySize) {
				int mid = Math.min(low + subArraySize - 1, arr.length - 1);

				int high = Math.min(low + 2 * subArraySize - 1, arr.length - 1);

				// using code we saw in class to merge
				int[] temp = new int[2 * subArraySize];
				int i = low, j = mid + 1, k = 0;
				while (i <= mid && j <= high) {
					if (arr[j] < arr[i]) {
						temp[k++] = arr[j++];
					} else {
						temp[k++] = arr[i++];
					}
				}
				while (i <= mid)
					temp[k++] = arr[i++];
				while (j <= high)
					temp[k++] = arr[j++];
				for (int p = low; p <= high; p++) {
					arr[p] = temp[p - low];
				}
			}
		}
	}

	public static void swap(int[] arr, int i, int j) {
		int tmp = arr[i];
		arr[i] = arr[j];
		arr[j] = tmp;
	}

	// Q3.2
	public static void merge(int[] arr, int low, int mid, int high, int max_num) {
		boolean swapped;
		for (int i = low; i <= high; i++) {
			swapped = false;
			for (int j = low; j < high - i; j++) {
				if (arr[j] > arr[j + 1]) {
					swap(arr, j, j + 1);
					swapped = true;
				}
			}

			if (swapped == false)
				break;
		}
	}

	public static void printArray(int arr[]) {
		for (int i = 0; i < arr.length; i++)
			System.out.print(arr[i] + " ");
		System.out.println();
	}

	public static int[] generateRandomArray(int size, int maxNum) {

		int[] arr = new int[size];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = rand.nextInt(maxNum + 1);
		}
		return arr;
	}

	public static LinkedList<Integer> generateSortedLinkedList(int size, int maxNum) {
		int[] a = generateRandomArray(size, maxNum);
		mergeSort2(a);
		LinkedList<Integer> res = new LinkedList<Integer>();
		for (int i = 0; i < a.length; i++) {
			res.add(a[i]);
		}
		return res;
	}

	public static ArrayList<LinkedList<Integer>> generateArrayOfSortedLists(int size, int maxNum) {
		int sizeOfLists = 3 + rand.nextInt(6);
		ArrayList<LinkedList<Integer>> res = new ArrayList<LinkedList<Integer>>(size);
		for (int i = 0; i < size; i++) {
			res.add(generateSortedLinkedList(sizeOfLists, maxNum));
		}
		return res;
	}

	public static void printList(LinkedList<Integer> ll) {
		for (Integer i : ll) {
				System.out.print(i + " ");
			}
			System.out.println();
	}
	
	public static void printListOfLists(ArrayList<LinkedList<Integer>> ll2) {
		for (LinkedList<Integer> ll : ll2) {
			printList(ll);
		}

	}

	public static int[] concatArrays(int[] a, int[] b) {
		int[] result = new int[a.length + b.length];
		for (int i = 0; i < a.length; i++)
			result[i] = a[i];
		for (int i = 0; i < b.length; i++)
			result[a.length + i] = b[i];
		return result;
	}

	// Q3.3
	public static LinkedList<Integer> join(ArrayList<LinkedList<Integer>> arr) {
		return join(arr, 0, arr.size() - 1);
	}

	public static LinkedList<Integer> join(ArrayList<LinkedList<Integer>> arr, int i, int j) {
		if (i == j)
			return new LinkedList<Integer>(arr.get(i));

		if (j == i + 1) 
			return mergeLinkedLists(arr.get(i), arr.get(i+1));
		LinkedList<Integer> left = join(arr,i,(i+j)/2);
		LinkedList<Integer> right = join(arr,1+(i+j)/2,j);
		LinkedList<Integer> merged = mergeLinkedLists(left, right);
		return merged;
	}

	public static LinkedList<Integer> mergeLinkedLists(LinkedList<Integer> l1, LinkedList<Integer> l2) {
		LinkedList<Integer> l3 = new LinkedList<Integer>();
		int i=0,j=0;
		while(i < l1.size() && j<l2.size()){
			if(l1.get(i) < l2.get(j))
				l3.add(l1.get(i++));
			else
				l3.add(l2.get(j++));
		}
		while(i < l1.size()){
			l3.add(l1.get(i++));
		}
		while(j<l2.size()){
			l3.add(l2.get(j++));
		}
		return l3;
	}
	
	// Q4
		public static int diff(int[] arr) {
			int maxDiff = 0, prev;

			int[] counts = new int[arr.length + 1];
			for (int i = 0; i < arr.length; i++) {
				counts[arr[i]]++;
			}

			int k = 0;
			while (counts[k] == 0)
				k++;
			prev = k;
			while (k < counts.length) {
				if (counts[k] != 0) {

					if (maxDiff < k - prev) {
						maxDiff = k - prev;
					}
					prev = k;
				}
				k++;
			}

			return maxDiff;
		}
	
//	public static void main(String[] args) {
//		System.out.println("Q4:");
//		int[] arr = generateRandomArray(10, 10);
//		printArray(arr);
//		System.out.println("Max diff: " + diff(arr));
//
//		System.out.println("\nQ3.1:");
//		arr = generateRandomArray(10, 20);
//		System.out.println("Before the sort");
//		printArray(arr);
//		mergeSort2(arr);
//		System.out.println("After the sort");
//		printArray(arr);
//
//		System.out.println("\nQ3.2:");
//		int[] a = generateRandomArray(3, 20);
//		mergeSort2(a);
//		int[] b = generateRandomArray(4, 20);
//		mergeSort2(b);
//		int[] c = concatArrays(a, b);
//		System.out.println("Array with 2 parts sorted");
//		printArray(c);
//		System.out.println("After merging:");
//		merge(c, 0, a.length - 1, a.length + b.length - 1, 0);
//		printArray(c);
//
//		System.out.println("\nQ3.3");
//		ArrayList<LinkedList<Integer>> all = generateArrayOfSortedLists(4, 12);
//		printListOfLists(all);
//		LinkedList<Integer> ll = join(all);
//		printList(ll);
//	}
}
