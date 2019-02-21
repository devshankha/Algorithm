import java.util.concurrent.CountDownLatch;

class Stack {
	private int top = -1;
	private BSTree arr[];

	Stack() {
		arr = new BSTree[100];
	}

	void push(BSTree d) {
		arr[++top] = d;

	}

	BSTree pop() {
		return arr[top--];

	}

	boolean isEmpty() {
		return top == -1;
	}

}

class Queue {

	int top;
	int rear;
	BSTree[] bsTree;
	int MAXSIZE = 10;
	int noOfitems;

	public Queue() {
		bsTree = new BSTree[MAXSIZE];
		top = -1;
		rear = -1;
		noOfitems = -1;

	}

	boolean isEmpty() {
		if (noOfitems == -1)
			return true;
		return false;
	}

	void push(BSTree bs) {
		if (noOfitems == (MAXSIZE - 1)) {
			System.out.println("Queue full");
			return;
		}
		bsTree[++top] = bs;
		noOfitems++;
		// System.out.println("Ïnseted "+bs.num);

	}

	BSTree pop() {
		if (noOfitems == -1) {
			System.out.println("Queue Empty");
			return null;
		}
		noOfitems--;
		// System.out.println(" Ëlement removed ");
		// rear++;
		// System.out.println(rear);
		return bsTree[++rear];

	}

}

public class BSTree {
	Integer num;
	BSTree left;
	BSTree right;

	public BSTree(Integer num) {
		this.num = num;
		this.left = null;
		this.right = null;
	}
	//My own version of this method
	//appears to be working
	static void preOrderNonRec(BSTree b) {
		Stack s = new Stack();
		BSTree temp = b;
		while (temp != null || !s.isEmpty()) {
			while(temp != null) {
				System.out.print(temp.num+" ");
				s.push(temp);
				temp = temp.left;				
			}
			BSTree c = s.pop();
			temp = c.right;
		}
		
	}
	
		static void inOrderNonrec(BSTree b) {
		
		Stack<BSTree> s = new Stack<BSTree>();
		BSTree temp = b;
		while (temp != null || !s.isEmpty()) {
			while (temp != null) {
				/*
				 * place pointer to a tree node on the stack before traversing the node's left
				 * subtree
				 */
				s.push(temp);
				temp = temp.left;
			}
			temp = s.pop();

			System.out.print(temp.num + " ");

			/*
			 * we have visited the node and its left subtree. Now, it's right subtree's turn
			 */
			temp = temp.right;

		}

	}
    //insets an element in the BST
	public void inset(BSTree b, Integer n) {
		if (b == null)
			return;
		BSTree temp = null;
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
			temp.left = new BSTree(n);
		else
			temp.right = new BSTree(n);

	}

	@Override
	public String toString() {
		return num + "===>";
	}
   // does bst traversal of a BST
	void bfs(BSTree p) {
		if (p == null)
			return;
		Queue q = new Queue();
		q.push(p);
		while (!q.isEmpty()) {
			BSTree temp = q.pop();
			System.out.print(temp);
			if (temp.left != null)
				q.push(temp.left);
			if (temp.right != null)
				q.push(temp.right);
		}

	}
   // does dfs traversal of a bst
	void dfs(BSTree p) {
		if (p == null)
			return;
		Stack q = new Stack();
		q.push(p);
		while (!q.isEmpty()) {
			BSTree temp = q.pop();
			System.out.print(temp);
			if (temp.left != null)
				q.push(temp.left);
			if (temp.right != null)
				q.push(temp.right);
		}

	}

	void inOrder(BSTree b) {
		if (b == null)
			return;
		inOrder(b.left);
		System.out.print(b.num + "    " + "--->");
		inOrder(b.right);
	}

	// This method finds the height of a BST
	int height(BSTree d) {
		if (d == null)
			return 0;

			int ls = d.height(d.left);
			int rs = d.height(d.right);
			if (ls > rs)
				return ls + 1;
			return rs + 1;
		

	}

	static void printLevel(BSTree t, int level) {
		if (t == null)
			return;
		if (level == 1) {
			System.out.print(t.num + "   ");
			return;

		} 
			printLevel(t.left, level - 1);
			printLevel(t.right, level - 1);
		

	}
	 BSTree leastCommonAncestor(BSTree t1,BSTree t2, BSTree root){
		 if (root == null)
			 return null;
		 System.out.println("leastCommonAncestor with "+root.num+" t1 "+t1.num+" t2 "+t2.num);
	
		 if ( (root.num > t1.num) && (root.num > t2.num)){
			 return leastCommonAncestor(t1,t2,root.left) ;
		 }
		 if ( (root.num <t1.num) && (root.num < t2.num)){
			 return leastCommonAncestor(t1,t2,root.right) ;
		 }
		 
		System.out.println(" Returning The ancestor as "+root.num);	 
		 return root;
		 
		
	}
    // print nodes at each level
	static void printOrder(BSTree d) {
		int height = d.height(d);

		for (int i = 1; i <= height; i++) {
			printLevel(d, i);
			System.out.println();

		}

	}

	public static void main(String[] args) {
		
		BSTree mb = new BSTree(24);
		BSTree l2=mb.right = new BSTree(32);
		mb.right.right = new BSTree(44);
		BSTree l1=  mb.right.right.right = new BSTree(54);
		
		mb.left = new BSTree(23);
		mb.left.left = new BSTree(21);
		mb.left.left.left = new BSTree(18);
		mb.bfs(mb);
		System.out.println();
		System.out.println(mb.num);
		BSTree fc =mb.leastCommonAncestor(l1,l2, mb);
		//System.out.println("Ancestor is "+fc.num);
		
		// bs.inOrder(bs);
		// bs.bfs(bs);
		// bs.dfs(bs);
		//bs.printOrder(bs);
		//mb.printOrder(mb);
		 //System.out.println(bs.height(bs));

	}

}
