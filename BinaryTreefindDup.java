import java.util.ArrayList;
import java.util.HashSet;
//this is a solution taken from geekforgeeks --
//https://www.geeksforgeeks.org/check-binary-tree-contains-duplicate-subtrees-size-2/
//Check if a Binary Tree contains duplicate subtrees of size 2 or more
//this doesnt seem to work for all cases

public class BinaryTreefindDup {
	int data;
	BinaryTreefindDup left;
	BinaryTreefindDup right;
	static int startIndex=0;
	static char MARKER = '$'; 
	public BinaryTreefindDup(int d) {
		data = d;
	}
	
	  public static String dupSubUtil(BinaryTreefindDup root, HashSet<String> subtrees)  
	    {  
	        String s = "";  
	        if (root != null)
	        	System.out.println("For node "+root.data+" "+"with set"+subtrees);
	        else
	        	System.out.println("For subtree "+subtrees);
	        	
	    
	        // If current node is NULL, return marker  
	        if (root == null)  
	            return s + MARKER;  
	    
	        // If left subtree has a duplicate subtree.  
	        //this could also have been done as lStr.equals("")
	        String lStr = dupSubUtil(root.left,subtrees); 
	        //this could well have been lStr.equals("")
	        if (lStr.equals(s))  {
	        	System.out.println("If left with "+lStr+" "+subtrees);
	            return s; 
	        }
	    
	        // Do same for right subtree  
	       
	        String rStr = dupSubUtil(root.right,subtrees); 
	        //this could also have been done as rStr.equals("")
	        ////this could well have been lStr.equals("")
	        if (rStr.equals(s)) { 
	        	System.out.println("If right with "+rStr+" "+subtrees);
	            return s;  
	        }
	    
	        // Serialize current subtree  
	        s = s + root.data + lStr + rStr;  
	    
	        // If current subtree already exists in hash  
	        // table. [Note that size of a serialized tree  
	        // with single node is 3 as it has two marker  
	        // nodes.  
	        if (s.length() > 2 && subtrees.contains(s))  
	            return "";  
	    
	        subtrees.add(s); 
	        System.out.println("For node "+root.data+" "+"leaving with "+subtrees);
	        return s;  
	    }  
	  
	    //Function to find if the Binary Tree contains duplicate  
	    //subtrees of size 2 or more 
	    public static String dupSub(BinaryTreefindDup root) 
	    { 
	        HashSet<String> subtrees=new HashSet<>(); 
	        return dupSubUtil(root,subtrees); 
	    } 
	  
	
	
	
	static void inOrder(BinaryTreefindDup root) {
		if (root == null)
			return;
		inOrder(root.left); 
		System.out.print(root.data+" ");
		inOrder(root.right);
		
	}
	
	
	public static void main(String[] args) {
		
		 BinaryTreefindDup s = new BinaryTreefindDup(5);
		 s.left = new BinaryTreefindDup(5);
		 s.left.left = new BinaryTreefindDup(3);
		 s.left.right = new BinaryTreefindDup(8);
		 s.right = new BinaryTreefindDup(18);
		 //s.right.left = new BinaryTreeserialize(3);
		 String str = dupSub(s);  
	        if(str.equals("")) 
	            System.out.print(" Yes "); 
	        else    
	            System.out.print(" No ");  
	}

}
