package Dynamicprogramming;

import java.util.Arrays;

public class LCS {
	int[] process(int[] arr ){
		int n = arr.length;
		int max=1;
		
		int[] les = new int[n];
		 int[] pred = new int[n];
		    Arrays.fill(pred, -1);
		for (int i=0; i < n;i++)
			les[i]= 1;
		
		for (int i=1;i < n ; i++) {
			for (int j=0; j <i;j++) {
				if ((arr[i] > arr[j]) && (les[i] < les[j]+1)) {
					
					les[i] = les[j]+1;
					pred[i] = j;				
					
				}
			}
		}
		for (int i=0; i < n;i++)
			if (max < les[i])
				max = les[i];
		  for (int i=0; i < les.length;i++)
		    	System.out.print(les[i]+" ");
		  System.out.println("------------");
		  for (int i=0; i < pred.length;i++)
		    	System.out.print(pred[i]+" "+" xxx ");
		
		
		  int bi = 0;
		    for (int i = 1; i < n; i++) {
		      if (les[bi] < les[i]) {
		        bi = i;
		      }
		    }
		   System.out.println("The bi is "+bi);
		   
		    
		    int[] res = new int[max];
		    
		
		    System.out.println();
		    for (int i = bi; i != -1; i = pred[i]) {
		    	
		      res[--max] = arr[i];
		    }
		  
		 
		 
	
		return res;
		
	}
	public static void main(String[] args) {
		LCS k = new LCS();
		int[] res =k.process(new int[]{3,5,1,2,12,44});
		  for (int i=0; i < res.length;i++)
		    	System.out.print(res[i]+" ");
		
		
	}

}
