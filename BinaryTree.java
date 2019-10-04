
/*
 * Code to find all array that can lead to a BST. Code is taken from
 * Cracking Coding interviews
 */

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Random;

class TreeNode {
	int data;
	TreeNode left;
	TreeNode right;
	private int size = 0;

	TreeNode(int d) {
		data = d;
		size = 1;
	}
	
	public int size() {
		return size;
	}

	public TreeNode getRandomNode() {
		int leftSize = left == null ? 0 : left.size();
		Random random = new Random();
		int index = random.nextInt(size);
		if (index < leftSize)
			return left.getRandomNode();
		else if (index == leftSize)
			return this;
		else
			return right.getRandomNode();

	}
	
	public void insertInOrder(int d) {
		if (d <= data) {
			if (left == null)
				left = new TreeNode(d);
			else left.insertInOrder(d);
		} else {
			if (right == null)
				right = new TreeNode(d);
			else right.insertInOrder(d);			
		}
		size++;
	}
}

public class BinaryTree {
	public static void main(String[] args) {
		TreeNode root = new TreeNode(5);
		root.insertInOrder(3);
		root.insertInOrder(1);
		root.insertInOrder(5);
		root.insertInOrder(8);
		//root.getRandomNode().data
		System.out.println(root.getRandomNode().data);
	}

}
