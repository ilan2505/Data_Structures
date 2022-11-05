package tirgoul_1_2_miounim;

import java.util.Arrays;
public class BubbleSort {
	// Method to test above 
	public static void main(String[] args) {
		int[] arr = {8,7,6,5,4,3,2,1};
		Bubble_Sort(arr);
		System.out.println(Arrays.toString(arr));
	}

	// A function to implement bubble sort 
	public static void Bubble_Sort(int[] arr) {      //O(n^2)
		for(int i=0,n=arr.length; i < n-1 ; i++)
			for (int j=0; j<n-i-1; j++)
				if(arr[j] > arr[j+1])
					swap(arr,j,j+1);
	}

	// Swap Functions
	public  static void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}	
}
