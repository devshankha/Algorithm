import java.util.Arrays;

public class Factorial {
	static int l = 5;
	static int[] fact1 = new int[l+1];
	static {
		Arrays.fill(fact1, -1);
	}
	// factorial using recursion
	static int fact(int n) {
		if (n <= 1)
			return 1;
		return n*fact(n-1);
			
	}
	// factorial using DP bottom up
	static int dynamicbottomfact(int n) {
		int[] fact = new int[n+1];
		fact[0]=1;
		fact[1]=1;
		for (int i=2; i<= n;i++) {
			fact[i] = i*fact[i-1];
		}
		return fact[n];
				
	}	
	// factorial using DP top up
	static int topDownfactorial(int n) {
		System.out.println("Printing the value "+n+" "+Arrays.toString(fact1));

		if (n == 0)
			return 1;
		if (fact1[n] != -1)
			return fact1[n];
		return (fact1[n] = n * topDownfactorial(n - 1));

	}
	public static void main(String[] args) {
		//System.out.println(Factorial.fact(4)); 
		//System.out.println(Factorial.dynamicbottomfact(4));
		System.out.println(Factorial.topDownfactorial(5));
	}
	

}
