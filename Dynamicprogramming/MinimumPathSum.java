//Minimum path sum--dynamic programming problem
//idea taken from https://www.youtube.com/watch?v=t1shZ8_s6jc&t=4s

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MinimumPathSum  {
	

	static int minCost(int arr[][]) {
		int rows = arr.length;
		int cols = arr[0].length;
		int aux[][] = new int[rows][cols];
		//fill the first row
		for (int i=0; i < cols;i++) {
			if (i == 0) {
				aux[0][0] = arr[0][0];
				continue;
			}
			aux[0][i] = aux[0][i-1]+arr[0][i];
			
		}
		
		//System.out.println(Arrays.deepToString(aux));
		//Fill the first column
		int sum = 0;
		for (int i=1; i < rows;i++) {
			
			aux[i][0] = arr[i][0]+aux[i-1][0];
			sum = aux[i][0];
			
		}
		//System.out.println(Arrays.deepToString(aux));
		//Fill the rest
		for (int i=1; i < rows;i++) {
			for (int j=1; j < cols;j++) {
				
				 
				if (aux[i-1][j]>= aux[i][j-1])
					aux[i][j] = aux[i][j-1]+arr[i][j];
				else
					aux[i][j] = aux[i-1][j]+arr[i][j];
					
			}
				
			
			
			
		}
		System.out.println(Arrays.deepToString(aux));
		return aux[rows-1][cols-1];
	}
	
	
	 
	 public static void main(String[] args) {
		int arr[][]= {{1,3,5},{2,1,2},{4,3,1}};
		//System.out.println(arr.length);
		//System.out.println(arr[0].length);
		
		//System.out.println(Arrays.deepToString(arr));
		int l =MinimumPathSum.minCost(arr);
		//System.out.println(l);
		//System.out.println(Circle.minCost(arr, 2,2));
		
		//Circle.minCost(arr, 3,3);
		
	}

}
