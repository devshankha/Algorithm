
// another backtracking problem, which uses recursion and loops, little difficult to 
//understand, the code is taken from here ==
//https://www.youtube.com/watch?v=LdtQAYdYLcE&t=327s


import java.util.ArrayList;

import java.util.List;

public class GenerateSubSets {

	public static List<List<Integer>> subsets(int[] nums) {
		List<List<Integer>> subsets = new ArrayList<>();
		generateSubSets(0, nums,new ArrayList<Integer>(), subsets);
		return subsets;

	}

	public static void generateSubSets(int index, int[] nums, List<Integer> current, List<List<Integer>> subsets) {
      subsets.add(new ArrayList<>(current)); 
      System.out.println(subsets+" "+current);
      for (int i=index;i < nums.length;i++) {    	  
    	  //taking the number
    	  current.add(nums[i]);
    	  //simulate moving on with the number
    	  generateSubSets(i+1, nums, current, subsets);
    	  //removing the number
    	  current.remove(current.size()-1);
    	  System.out.println("This is for "+i+" "+subsets+" "+current);
      }
	}

	public static void main(String[] args) {
		int[]k = {1,2};
		
		List<List<Integer>> m = subsets(k);
		System.out.println("--------------");
		
		System.out.println(m);
		

	}

}
