/** Longest consecutive sequence in Binary tree
Difficulty Level : Medium
Last Updated : 16 Jun, 2021
Given a Binary Tree find the length of the longest path which comprises of nodes with consecutive values in 

increasing order. Every node is considered as a path of length 1. **/
 
class Node
{
    int data;
    Node left, right;
 
    Node(int item)
    {
        data = item;
        left = right = null;
    }
}
 
class Result
{
    int res = 0;
}
 
class BinaryTree
{
    Node root;
 
    // method returns length of longest consecutive
    // sequence rooted at node root
    int longestConsecutive(Node root)
    {
        if (root == null)
            return 0;
 
        Result res = new Result();
         
        // call utility method with current length 0
        longestConsecutiveUtil(root, 0, root.data, res);
         
        return res.res;
    }
 
    // Utility method to return length of longest
    // consecutive sequence of tree
    private void longestConsecutiveUtil(Node root, int curlength,
                                        int expected, Result res)
    {
        if (root == null)
            return;
 
        // if root data has one more than its parent
        // then increase current length
        if (root.data == expected)
            curlength++;
        else
            curlength = 1;
 
        // update the maximum by current length
        res.res = Math.max(res.res, curlength);
 
        // recursively call left and right subtree with
        // expected value 1 more than root data
        longestConsecutiveUtil(root.left, curlength, root.data + 1, res);
        longestConsecutiveUtil(root.right, curlength, root.data + 1, res);
    }
 
    // Driver code
    public static void main(String args[])
    {
        BinaryTree tree = new BinaryTree();
 
        tree.root = new Node(6);
        tree.root.right = new Node(9);
        tree.root.right.left = new Node(7);
        tree.root.right.right = new Node(10);
        tree.root.right.right.right = new Node(11);
 
        System.out.println(tree.longestConsecutive(tree.root));
    }
}
 
// This code is contributed by shubham96301