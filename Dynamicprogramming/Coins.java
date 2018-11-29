package Dynamicprogramming;

import java.util.Arrays;

public class Coins {
	public static int[] NumberOfCoins(int sum, int[] denominations) {
		int[] a = new int[sum + 1];
		Arrays.fill(a, Integer.MAX_VALUE-1000);
		a[0]=0;
		for (int i = 0; i <= sum; i++) {
			for (int j = denominations.length - 1; j >= 0; j--) {
				if (denominations[j] <= i) {
					a[i] = Math.min(1 + a[i - denominations[j]], a[i]);
				}
			}
		}
		return a;
	}
	public static void printArray(int[] a) {
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i] + "  ");
		}
		System.out.println();
	}
	public static void main(String[] args) {
		int[] denominations = new int[] { 1,  5, 7 };
		int sum = 10;
		
		printArray(NumberOfCoins(sum, denominations));
	}

}
