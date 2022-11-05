package A_Matala1;

public class Ex1 {
	
//Question 1---------------------------------------------------------------------------------
    public static boolean pairs(int[] a, int s) {
    	int left=0;                               //O(1)   
    	int right=a.length-1;                     //O(1)
        
     
        while (left < right) {                    //O(n) because n is the arr.length
            if(a[left] + a[right] == s)           //O(1)
                return true;                      //O(1)
            else if(a[left] + a[right] < s)       //O(1)
                left++;                           //O(1)
            else // a[left] + a[right] > sum 
                right--;                          //O(1)
        }  
        return false;                             //O(1)
    } 
    
     //O(1)+O(1)+O(n)+O(1)+O(1)+O(1)+O(1)+O(1)+O(1) = O(n)
 //------------------------------------------------------------------------------------
 //Question 2:
    public static boolean triples(int[] a, int s) {
    	
    	for (int i = 0; i < a.length-2; i++) {          //O(n)
    		int left = i+1;                             //O(1)     
    		int right = a.length-1;                     //O(1)
    		while (left < right) {                      //O(n) because n is the arr.length
    			if (a[i]+a[left]+a[right] == s) {       //O(1)
    				return true;                        //O(1)
    			}
    			else if (a[i]+a[left]+a[right] < s)     //O(1)
    				left++;                             //O(1)
    			else      // a[i] + a[left] + a[right] > sum
    				right --;                           //O(1)
    		}
		}
		return false;                                   //O(1)
    }
    
     //O(n)*(O(1)+O(1)+O(n)+O(1)+O(1)+O(1)+O(1)+O(1)+O(1)) = O(n)*O(n) = O(n^2)
    
//-----------------------------------------------------------------------------------------
//test :
    public static void main(String[] args) {
        int arr[] ={1,7,9,20};
        System.out.println(pairs(arr,10));   //true
        System.out.println(pairs(arr,9));   //false
        System.out.println(triples(arr,29));  //false
        System.out.println(triples(arr,28));  //true
    }
}
