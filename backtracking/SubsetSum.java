import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubsetSum {

	public static void main(String[] args) {

		int[] subset = {6,8};
		int k = 5;
		List<List<Integer>> res = generateSubsetSum(subset, k);
		for (List<Integer> l : res) {
			System.out.println(l);
		}
	}

	static List<List<Integer>> generateSubsetSum(int[] subset, int target) {
		List<List<Integer>> res = new ArrayList<>();
		List<Integer> l = new ArrayList<>();
		Arrays.sort(subset);
		//The lines till here are an optimization, 
		//first the array is sorted, and then checked if subset[i]> target
		//if so, no point in taking subset[i], helps for cases such as {6,8} and target -5
		//which will never have any solutions
		int i = subset.length - 1;
		while (i >= 0 && subset[i] > target)
			i--;
		if (i < 0)
			return res; 
		subset = Arrays.copyOfRange(subset, 0, i + 1);
		// The lines till here
		generateSubsetSumBacktrack(subset, 0, target, 0, l, res);
		return res;
	}

	static void generateSubsetSumBacktrack(int[] subset, int curSum, int target, int idx, List<Integer> l,
			List<List<Integer>> res) {
		// Here the list l contains the current working set
		//when all elements in l match up to target, we have found a solution,and
		//the contents of l are moved to res array

		if (curSum == target) {
			res.add(new ArrayList<>(l));
		} else {
			for (int i = idx; i < subset.length; i++) {
				if (curSum + subset[i] > target)
					break;
				l.add(subset[i]);				
				generateSubsetSumBacktrack(subset, curSum + subset[i], target, i + 1, l, res);
				l.remove(l.size() - 1);
			}
		}
	}
}
