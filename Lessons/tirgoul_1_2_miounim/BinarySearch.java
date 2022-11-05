package tirgoul_1_2_miounim;
import java.util.Arrays;
public class BinarySearch {
	// Method to test above 
	public static void main(String[] args) {
		int[] sortedArray = {1,2,3,4,5,6};
		int key = 6; // Prints Not Found  
		int index = Arrays.binarySearch(sortedArray, key);
		System.out.println((index >= 0) ? index : "Not Found");
        System.out.println(binarySearchInducion(sortedArray,5));

	}

	public int binarySearch( int[] sortedArray, int key, int low, int high) {
		int middle = (low + high) / 2;  
		if (high < low) { 
			return -1; 
		} 
		if (key == sortedArray[middle])  { 
			return middle; 
		} 
		else if (key < sortedArray[middle])  
			return binarySearch(sortedArray, key, low, middle - 1); 
		else  
			return binarySearch(sortedArray, key, middle + 1, high);
	}
	
	
	public static int binarySearchInducion(int []arr,int value){
		if (value<arr[0] || value>arr[arr.length-1]){
			return -1;
		}
		int low = 0, high = arr.length-1;
		while (low <=high){
			int middle = (low + high)/2;
			if (arr[middle] == value){//value was found
				return middle;
			}
			// value suppose to be left
			if (value < arr[middle]){
				high = middle-1;
			}
			// value suppose to be right
			else{
				low = middle+1;
			}
		}
		return -1;
	}

}
