
public class SumOfSetDynamic {
	static boolean isSubsetSum(int set[], int n, int sum) {
		boolean subset[][] = new boolean[n + 1][sum + 1];
		// if sum is zero, result is true
		for (int i = 0; i <= n; i++) {
			System.out.print(i + " ");
			subset[i][0] = true;
		}
		// if sum is non zero, value is zero,
		// result is false
		//remember i should start from 1
		for (int i = 1; i <= sum; i++) {
			subset[0][i] = false;

		}
		System.out.println("-------------");
		for (int i = 0; i <= n; i++) {
			for (int j = 0; j <= sum; j++) {
				System.out.print(subset[i][j] + " " + i + " " + j + " ");

			}
			System.out.println();
		}

		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= sum; j++) {
				if (set[i-1] > j)
					subset[i][j] = subset[i-1][j];
				else {
					
					subset[i][j] = subset[i-1][j] || subset[i-1][j-set[i-1]] ;
					
					
				}		

			}
		}
		
		System.out.println("&&&&&&&&&&&&&&");
		for (int i = 0; i <= n; i++) {
			for (int j = 0; j <= sum; j++) {
				System.out.print(subset[i][j]+" " );

			}
			System.out.println();
		}

		return subset[n][sum];

	}

	public static void main(String[] args) {
		int set[] = { 1, 2, 5, 7 };
		int sum = 6;
		int n = set.length;
		if (isSubsetSum(set, n, sum) == true)
			System.out.println("Found a subset" + " with given sum");
		else
			System.out.println("No subset with" + " given sum");
	}

}
