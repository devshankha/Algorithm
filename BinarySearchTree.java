
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

	TreeNode(int d) {
		data = d;
	}
}

public class BinarySearchTree {
	static void weaveLists(LinkedList<Integer> first, LinkedList<Integer> second,
			ArrayList<LinkedList<Integer>> results, LinkedList<Integer> prefix) {
		System.out.println("In the weaveList " + first + " " + second + " " + prefix);
		if (first.size() == 0 || second.size() == 0) {
			LinkedList<Integer> result = (LinkedList<Integer>) prefix.clone();
			result.addAll(first);
			result.addAll(second);
			results.add(result);
			return;
		}
		/**
		 * Recurse with head of first added to the prefix.
		 */
		int headFirst = first.removeFirst();
		// actually not required to use addLst
		//both add and adLast are equivalent
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

	static ArrayList<LinkedList<Integer>> allSequences(TreeNode node) {
		ArrayList<LinkedList<Integer>> result = new ArrayList<LinkedList<Integer>>();
		if (node == null) {
			result.add(new LinkedList<Integer>());
			return result;
		}
		LinkedList<Integer> prefix = new LinkedList<Integer>();
		prefix.add(node.data);
		ArrayList<LinkedList<Integer>> leftSeq = allSequences(node.left);

		ArrayList<LinkedList<Integer>> rightSeq = allSequences(node.right);
		System.out.println(leftSeq + " " + leftSeq.size());
		System.out.println(rightSeq + " " + rightSeq.size());
		/*
		 * Weave together lists from left and right sides
		 */
		for (LinkedList<Integer> left : leftSeq)
			for (LinkedList<Integer> right : rightSeq) {
				ArrayList<LinkedList<Integer>> weaved = new ArrayList<LinkedList<Integer>>();
				weaveLists(left, right, weaved, prefix);
				result.addAll(weaved);

			}
		System.out.println("The result is " + result);
		return result;

	}

	public static void main(String[] args) {
		TreeNode root = new TreeNode(5);
		root.left = new TreeNode(3);
		root.right = new TreeNode(8);
		//ArrayList<LinkedList<Integer>> l = BinarySearchTree.allSequences(root);
		//System.out.println(l);
		LinkedList<Integer> f1 = new LinkedList<>(); 
		LinkedList<Integer> f2 = new LinkedList<>(); 
		f1.add(1);
		f1.add(2);
		f2.add(8);
		f2.add(9);
		ArrayList<LinkedList<Integer>> weaved = new ArrayList<LinkedList<Integer>>();
		LinkedList<Integer> prefix = new LinkedList<Integer>();
		prefix.add(5);
		BinarySearchTree.weaveLists(f1,f2,weaved, prefix);
		System.out.println("---------------"+weaved);
		/*LinkedList<Integer> m = new LinkedList<>();
		m.add(1);
		m.add(2);
		m.add(3);
		System.out.println(m);
		System.out.println(m.get(0));
		m.addLast(4);
		System.out.println(m);*/
		

	}

}
