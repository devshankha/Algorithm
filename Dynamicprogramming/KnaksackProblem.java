import java.util.Arrays;

public class KnaksackProblem {
	// Returns the maximum value that can be put in a knapsack of capacity W
	static int knapSack(int W, int wt[], int val[]) {
		int i, w;
		int n = wt.length;
		int K[][] = new int[n + 1][W + 1];
		

		// Build table K[][] in bottom up manner
		for (i = 0; i <= n; i++) {
			for (w = 0; w <= W; w++) {
				if (i == 0 || w == 0)
					K[i][w] = 0;
				//here wt is the array { 1,3,6 };
				// so wt[0] is 1, wt[1] is 3 and so on
				
				else if (wt[i-1 ] <= w) {
					// here val is the array { 2,3,4 } so val[0] is 2
					
					//Here max of excluding and including the coin
					K[i][w] = Math.max(val[i - 1] + K[i - 1][w - wt[i - 1]], K[i - 1][w]);
					//if (i== 1 && w == 1  )
						//System.out.println("MMMMMMMMMMMMM "+i+" "+w+" "+wt[i-1 ]);
				}
				else
					K[i][w] = K[i - 1][w];
			}
			//System.out.println(Arrays.deepToString(K));
			//System.out.println();
		}
		int res = K[n][W]; 
       // System.out.println(res); 
        w = W; 
        for (i = n; i > 0 && res > 0; i--) { 
  
            // either the result comes from the top 
            // (K[i-1][w]) or from (val[i-1] + K[i-1] 
            // [w-wt[i-1]]) as in Knapsack table. If 
            // it comes from the latter one/ it means 
            // the item is included. 
            if (res == K[i - 1][w]) 
                continue; 
            else { 
  
                // This item is included. 
                System.out.print(wt[i - 1] + " "); 
  
                // Since this weight is included its 
                // value is deducted 
                res = res - val[i - 1]; 
                w = w - wt[i - 1]; 
            } 
        } 

		return K[n][W];
	}

	public static void main(String[] args) {
		int val[] = new int[] { 2,3,4 };
		int wt[] = new int[] { 1,3,6 };
		int W = 7;
		//int val[] = new int[] { 2,3,4 };
		//int wt[] = new int[] { 1,2,3 };
		//int W = 7;
		int n = val.length;
		System.out.println(knapSack(W, wt, val));

	}

}
