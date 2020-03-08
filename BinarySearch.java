import java.util.Arrays;
import java.util.Random;
/*
 *   My own implementations of binary search,
 *   contains both the recursive and iterative versions,
 *   both seems to be working 
 */

public class BinarySearch {
	
	static int binarySearchR(int[] arr,int low,int high,int key) {
		if (low > high)
			return -1;
		
		if (arr[low] == key)
			return low;
		if (arr[high] == key)
			return high;
		int mid = low +(high-low)/2;
		if (arr[mid]== key)
			return mid;
		if (key < arr[mid]) 
			return binarySearchR(arr,low,mid-1, key);
		if (key > arr[mid])
			return binarySearchR(arr,mid+1,high, key);
		return mid;
		
		
	}
	static int binarySearch(int[] arr,int key) throws InterruptedException {
		int low = 0;
		int high =  arr.length-1;
		while (low <= high) {
			if (arr[low] == key)
				return low;
			if (arr[high] == key)
				return high;
			//Thread.sleep(999);
			// the check (high-low)/2+low works, not just (high-low)/2
			int mid = (high-low)/2+low;
			//System.out.println("Printing the low, mid and high "+low+" "+mid+" "+high);
			if (arr[mid] == key)
				return mid;
			if (key < arr[mid]) {
				high = mid-1;
			}
			else {
				low = mid+1;
			}
		}
		return -1;
	}

	

	public static void main(String[] args) throws InterruptedException {
		 int arr[] = { 2, 3, 4, 10 };
		// int result1 = binarySearch(arr, -4);
		// System.out.println(result1);
		 
		 int result = binarySearchR(arr, 0,arr.length-1,-4); 
		 System.out.println(result);
		

	}

}
