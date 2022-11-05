package Ex4;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
public class Ex4 {
	
	public static int getSum(int[] arr, int i, int j, int k){
		return arr[i] + arr[j] + arr[k];
	}
	
	public static List<int[]> ThreeSum(int[] arr, int target) {
		ArrayList<int[]> res = new ArrayList<int[]>();
		//sort the array
		Arrays.sort(arr);
		//fix first element of the array
		for (int i = 0; i < arr.length - 1; i++) {
			//skip duplicates
			if(i > 0 && arr[i] == arr[i-1]){
				continue;
			}
			//find the other 2 elements using 2 indices
			int l = i+1;
			int r = arr.length-1;
			while(l < r){
				//skip duplicates
				if((r < arr.length-1 && arr[r] == arr[r+1]) || arr[r] == arr[i]){
					r--;
					continue;
				}
				if((l > i+1 && arr[l] == arr[l-1]) || arr[l] == arr[i] || arr[l] == arr[r]){
					l++;
					continue;
				}
				int sum = getSum(arr,i,l,r);
				//found 2 numbers
				if (sum == target) {
					int[] tmp = new int[]{arr[i], arr[l], arr[r]};
	                res.add(tmp);
	                l++;
	                r--;
	            }
				// too small, move the search window to the right
	            else if (sum < target){
	                l++;
	            }
				// too big, move the search window to the left
	            else{ 
	                r--;
	            }
			}
		}
		return res;
	}

	public static void printArr(int[] arr){
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}
	
	public static void main(String[] args) {
		int[] arr = new int[20];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = new Random().nextInt(20)+1;
		}
		printArr(arr);
		List<int[]> l = ThreeSum(arr,15);
		System.out.printf("found %d sum(s)\n", l.size());
		for (int[] is : l) {
			System.out.printf("%d %d %d\n", is[0], is[1], is[2]);
		}
	}
}
