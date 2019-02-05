
public class LongestCommonSubsequence {
	public static int lcs(char X[],char[] Y,int l,int m) {
		
		int arr[][] = new int[l+1][m+1];
		for (int i=0; i <=l;i++)
			for (int j=0; j<=m;j++) {
				if (i==0 || j==0)
					arr[i][j]= 0;
				else if (X[i-1] == Y[j-1])
					arr[i][j] = 1+arr[i-1][j-1];
				else
		           arr[i][j] = max(arr[i-1][j], arr[i][j-1]);
				
			}
		return arr[l][m];
		
	}
	static int max(int a, int b) 
	  { 
	    return (a > b)? a : b; 
	  } 

	public static void main(String[] args) {
		 String s1 = "AB"; 
		    String s2 = "ABC"; 
		  
		    char[] X=s1.toCharArray(); 
		    char[] Y=s2.toCharArray(); 
		    int m = X.length; 
		    int n = Y.length; 
		    System.out.println("Length of LCS is" + " " + 
		    		LongestCommonSubsequence.lcs( X, Y, m, n ) ); 

	}

}
