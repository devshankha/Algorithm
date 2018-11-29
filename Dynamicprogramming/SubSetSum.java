package Dynamicprogramming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubSetSum {
	  /**
	   * return makeExactChange(numberOfCoinsPerSubtotal(t, coins), t);
	   **/
	  public List<Integer> subsetSumOfCoins(int[] coins, int t) {
	    int[] C = numberOfCoinsPerSubtotal(t, coins);
	    return makeExactChange(C, t);
	  }
	 
	  /**
	   * Compute the number of coins in each subtotal amount of money 
	   * from 0 to t.
	   */
	  private int[] numberOfCoinsPerSubtotal(int t, int[] coins) {
	    int[] C = new int[t + 1];
	    Arrays.fill(C, Integer.MAX_VALUE);
	    C[0] = 0;// base case
	    for (int coin : coins) {
	      for (int subtotal = 1; subtotal <= t; subtotal++) {
	        if (coin <= subtotal && C[subtotal] > C[subtotal - coin] + 1) {
	          C[subtotal] = C[subtotal - coin] + 1;
	        }
	      }
	    }
	    return C;
	  }
	 
	  /**
	   * Now that we know how many coins it takes to get each subtotal
	   * amount of money up to t, we can track the denomination of each coin:
	   * keep subtracting the next subtotal that takes fewer coins than t.
	   * For instance in the manual example above where t=10 and
	   * coins = {1,3,5}; since t N[t=10] takes 2 coins, the next subtotal
	   * that takes fewer coins than N[10] is N[5], and the next subtotal
	   * that takes fewer coins than N[5] is N[0]. Hence the denominations
	   * for N[10] are 10-5 and 5-0: {5,5}.
	   **/
	  private List<Integer> makeExactChange(int[] C, int t) {
	    List<Integer> result = new ArrayList<Integer>();
	    while (0 < C[t]) {
	      int big = t;
	      while (C[big] <= C[--t]);
	      result.add(big - t);
	    }
	    return result;
	  }
	  public static void main(String[] args) {
		  SubSetSum s = new SubSetSum();
		 int[] coins ={1,10,25};
		int[] from = s.numberOfCoinsPerSubtotal(30, coins);
		System.out.println();
		for (int k1: from)
			System.out.print(k1+" ");
		List<Integer> ls = s.makeExactChange(from,30);
		System.out.println(ls);
		
	}

}
