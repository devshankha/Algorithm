// Recursive Java program to print lca of two nodes
  
// A binary tree node
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
class BinaryTree 
{
    Node root;
  // find common ancestor of a binary tree, note, this need not be a binary search tree
  //code taken from Tushar youtube --   https://www.youtube.com/watch?v=13m9ZCB8gjw
  Node findLCA(Node root, Node p, Node q) {
    if (root == null)
      return null;
    if ( root == p || root == q)
      return root;
    Node left =  findLCA(root.left, Node p, Node q);
    Node right = findLCA(root.right, Node p, Node q);
    if (left != null && right != null)
      return root;
    if (left == null && right == null)
      return null;
    return left == null?right:left;
    
    
  }
      
    /* Function to find LCA of n1 and n2. The function assumes that both
       n1 and n2 are present in BST */
    Node lca(Node node, int n1, int n2) 
    {
    	System.out.println("MMMM Calling LCA with "+node.data);
        if (node == null)
            return null;
  
        // If both n1 and n2 are smaller than root, then LCA lies in left
        if (node.data > n1 && node.data > n2)
            return lca(node.left, n1, n2);
  
        // If both n1 and n2 are greater than root, then LCA lies in right
        if (node.data < n1 && node.data < n2) 
            return lca(node.right, n1, n2);
        System.out.println("MMMM Returning LCA with "+node.data);
        return node;
    }
  
    /* Driver program to test lca() */
    public static void main(String args[]) 
    {
        // Let us construct the BST shown in the above figure
        BinaryTree tree = new BinaryTree();
        tree.root = new Node(20);
        tree.root.left = new Node(8);
        tree.root.right = new Node(22);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(12);
        tree.root.left.right.left = new Node(10);
        tree.root.left.right.right = new Node(14);
  
       
        int n1 = 14;
        int n2 = 8;
        Node t = tree.lca(tree.root, n1, n2);
        System.out.println("LCA of " + n1 + " and " + n2 + " is " + t.data);
  
    
  
    }
}
  
// This code has been contributed by Mayank Jaiswal
