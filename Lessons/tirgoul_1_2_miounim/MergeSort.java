package tirgoul_1_2_miounim;
import java.util.Arrays;
public class MergeSort {
	// Method to test above 
	public static void main(String[] args) {
		int[] arr = {8,7,6,5,4,3,2,1};
		Merge_Sort(arr);
		System.out.println(Arrays.toString(arr));
	}

	private static void Merge_Sort(int[] arr) {           //O(n.log n)
		Merge_Sort(arr,0,arr.length-1);
	}
	private static void Merge_Sort(int[] arr, int start, int end)
	{
		if(start < end) {
			int middle = (start+end)/2;
			Merge_Sort(arr,start,middle);
			Merge_Sort(arr,middle+1,end);
			Merge(arr,start,middle,end);
		}
	}

	private static void Merge(int[] arr, int start, int middle, int end) {   //O(n)
		int[] temp = new int[end - start + 1];
		int i = start;
		int j = middle + 1;
		int k = 0; // The Running Pointer
		while( i <= middle && j <= end) 
		{
			if(arr[i] < arr[j]) temp[k++] = arr[i++];
			else temp[k++] = arr[j++];
		}
		while( i <= middle)
			temp[k++] = arr[i++];
		
		while( j <= end)
			temp[k++] = arr[j++];
		
		// Copy The array
		 i = start;
		 k = 0;
		 while( k < temp.length && i <= end)
		 {
			 arr[i++] = temp[k++];
		 }
	}
}
