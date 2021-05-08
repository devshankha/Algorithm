//Given an array of integers of size ‘n’.
//Our aim is to calculate the maximum sum of ‘k’ 
//consecutive elements in the array.
//
public class MaxSum {

	// Returns maximum sum in
	// a subarray of size k.
	static int maxSum(int arr[], int n, int k) {
		int csum = 0;
		int msum = 0;
		int len = arr.length;
		for (int i=0; i < k;i++ ) {
			csum+=arr[i];
		}
		msum = csum;
		System.out.println(csum);
		for (int i=k; i < len;i++) {
			csum=csum+arr[i] -arr[i-k];
			msum = Math.max(msum,csum);
		}
		return msum;
		//
	}

	public static void main(String[] args) {
		 int arr[] = { 1, 4, 2, 10, 2, 3};
	        int k = 3;
	        int n = arr.length;
	        System.out.println(maxSum(arr, n, k));

	}

}
