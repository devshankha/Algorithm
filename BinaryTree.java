/*
 * Code to find all array that can lead to a BST. Code is taken from
 * Cracking Coding interviews
 */

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Random;



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
