package Dynamicprogramming;

public class MyTest {
	public static void main(String[] args) {
		int bi = 0;
		int[] les = {1,3,0,2,34};
		 for (int i = 1; i < les.length; i++) {
		      if (les[bi] < les[i]) {
		        bi = i;
		      }
		    }
		 
	   System.out.println(bi);
	}

}
