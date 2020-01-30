import java.util.Arrays;
/*
 * This code is taken from the video 
 * https://www.youtube.com/watch?v=PafJOaMzstY
 * find number of ways to get coin of value N
 */

public class CoinChange {
	static int count( int S[], int m, int n )  
	{  
		//here rows are the coins
		//and columns are the sums
		int table[][] = new int[m+1][n+1];  
		//this sets all the values in 0th colum to 0
		for (int i = 0; i <= m; i++) {
			table[i][0] = 1;
		}
		for (int i = 1; i <= m; i++) {

			for (int j = 1; j <= n; j++) {
				// S is the array [1,2,3], so if i=1
				//then s[0] will be 1
				if (S[i - 1] > j) {
					table[i][j] = table[i - 1][j];

				}

				else {
					//excluding the ith coin+including the ith coin,
					
					table[i][j] = table[i - 1][j] + table[i][j -i];
				}

			}
		}
		System.out.println(Arrays.deepToString(table));
		return table[m][n];  
		
	}
	
	static int recCount(int S[], int m, int n) {
		// If n is 0 then there is 1 solution  
        // (do not include any coin) 
		if (n == 0)
			return 1;
		// If n is less than 0 then no  
        // solution exists 
		if (n < 0)
			return 0;
		// If there are no coins and n  
        // is greater than 0, then no 
        // solution exist 
		if (n >= 1 && m<= 0)
			return 0;
		//(S, m-1, n) -- excluding coin s[m-1]
		//(S, m, n-S[m-1]) -- including coin s[m-1]
		return recCount(S, m-1, n)+ recCount(S, m, n-S[m-1]);
			

	}
	public static void main(String[] args) {
		//start with simple example 1,2,3 and sum as 4
		int arr[] = {1, 2,3}; 
        int m = arr.length; 
        int n = 4; 
      
        System.out.println(count(arr, m, n)); 
		
	}

}
