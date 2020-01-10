import java.util.Arrays;
/*
 * construct a BSTRee given its preorder traversal, this is my own
 * implementation
 */

public class BSTreefrompreorder {
	Integer num;
	BSTreefrompreorder left;
	BSTreefrompreorder right;
	static int preIndex=0;

	public BSTreefrompreorder(Integer num) {
		this.num = num;
		this.left = null;
		this.right = null;
	}

	public void insert(BSTreefrompreorder b, Integer n) {
		if (b == null)
			return;
		BSTreefrompreorder temp = null;
		while (b != null) {
			temp = b;
			if (n == b.num)
				return;
			if (n < b.num)
				b = b.left;
			else
				b = b.right;
		}
		if (n < temp.num)
			temp.left = new BSTreefrompreorder(n);
		else
			temp.right = new BSTreefrompreorder(n);

	}
	
	void preOrder(BSTreefrompreorder b) {
		if (b == null)
			return;
		System.out.print(b.num+" ");
		preOrder(b.left);
		preOrder(b.right);
		
	}

	void inOrder(BSTreefrompreorder b) {
		if (b == null)
			return;
		inOrder(b.left);
		System.out.print(b.num + "    " + "--->");
		inOrder(b.right);
	}
	static BSTreefrompreorder constructTree(int[] preOrder,int[] sorted, int start, int end) {
		if (start == end) {
			return new BSTreefrompreorder(preOrder[preIndex++]);
		}
		//this is a special case
		//required for {8,3,5,13,21} and NOT for {13,5,3,8,21}
		if (start > end) 
			return null;
		int d = preOrder[preIndex++];
		BSTreefrompreorder root =new BSTreefrompreorder(d);
		System.out.println("--------"+root.num);
		int index = findIndex(d,sorted);
		root.left = constructTree(preOrder, sorted,start,index-1);
		root.right = constructTree(preOrder, sorted,index+1,end);
		return root;
		
		
	}
	static int findIndex(int d,int[] sorted) {
		int i;
		for ( i=0; i < sorted.length;i++) {
			
			if (sorted[i] == d)
				break;
		}
		return i;
	}
	public static void main(String[] args) {
		
		//int preOrder[]= {13,5,3,8,21};
		//int[] sorted = {3,5,8,13,21};
		
		int preOrder[]= {8,3,5,13,21};
		int[] sorted = {3,5,8,13,21};
		BSTreefrompreorder r = BSTreefrompreorder.constructTree(preOrder, sorted, 0,4);
		System.out.println("-------------");
		r.inOrder(r);
		System.out.println("-------------");
		r.preOrder(r);
	}
}