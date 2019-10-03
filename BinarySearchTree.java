/*
 * Code to find all array that can lead to a BST. Code is taken from
 * Cracking Coding interviews
 */

import java.util.ArrayList;
import java.util.LinkedList;
class TreeNode {
	int data;
	TreeNode left;
	TreeNode right;
}
public class BinarySearchTree {
	void weaveLists(LinkedList<Integer> first, LinkedList<Integer> second,
			ArrayList<LinkedList <Integer>> results,LinkedList<Integer> prefix) {
		if (first.size()==0 || second.size() == 0) {
			LinkedList<Integer > result = (LinkedList<Integer>)prefix.clone();
			result.addAll(first);
			result.addAll(second);
			results.add(result);
			return;			
		}
		/**
		 *  Recurse with head of first added to the prefix. 
		 */
		int headFirst = first.removeFirst();
		prefix.addLast(headFirst);
		weaveLists(first, second, results, prefix);
		prefix.removeLast();
		first.addFirst(headFirst);
		
		int headSecond = second.removeFirst();
		prefix.addLast(headSecond);
		weaveLists(first, second, results, prefix);
		prefix.removeLast();
		second.addFirst(headSecond);
		
	}

	ArrayList<LinkedList<Integer>> allSequences(TreeNode node) {
		ArrayList<LinkedList<Integer>> result = new ArrayList<LinkedList<Integer>>();
		if (node == null) {
			result.add(new LinkedList<Integer>());
			return result;
		}
		LinkedList<Integer> prefix = new LinkedList<Integer>();
		prefix.add(node.data);
		ArrayList<LinkedList<Integer>> leftSeq = allSequences(node.left);
		ArrayList<LinkedList<Integer>> rightSeq = allSequences(node.right);
		/*
		 * Weave together lists from left and right sides
		 */
		for (LinkedList<Integer> left : leftSeq)
			for (LinkedList<Integer> right : rightSeq) {
				ArrayList<LinkedList<Integer>> weaved = new ArrayList<LinkedList<Integer>>();
				weaveLists(left, right, weaved, prefix);
				result.addAll(weaved);

			}
		return result;

	}
	
	
	

}
