package minnoofcoins;

import java.util.Arrays;

public class MinCoins {
	public static int CoinChangeDynamic(int []s,int sum)
	{
		int [] min_coins= new int[sum+1];
		min_coins[0]=0;
		int[] pred =  new int[sum+1];
		Arrays.fill(pred, -1);
		int n = min_coins.length;
		
		for(int i=1;i<min_coins.length;i++)
			min_coins[i]=Integer.MAX_VALUE;
		
		for(int i=1;i<=sum;i++)
			for(int j=0;j<s.length;j++) {
				if((s[j]<=i) && (min_coins[i-s[j]]+1<min_coins[i])) {
					min_coins[i]=min_coins[i-s[j]]+1;
					pred[i] = j;
				}
			}
	
		
		
		return min_coins[sum];
	}
 
	public static void main(String[] args) {
		int k = MinCoins.CoinChangeDynamic( new int[]{1, 3, 5},22);
		System.out.println(k);
	}

}
