package List;


class Queue {
	
	int top ;
	int rear;
	BSTree[] bsTree;
	int MAXSIZE = 10;
	int noOfitems ;
	public Queue() {		
		bsTree = new BSTree[MAXSIZE];
		top = -1;
		rear = -1;
		noOfitems = -1;
		
	}
	boolean isEmpty(){
		if (noOfitems == -1)
			return true;
		return false;
	}
	void push (BSTree bs){
		if (noOfitems == (MAXSIZE-1)) {
			System.out.println("Queue full");
			return;
		}
		bsTree[++top]=bs;
		noOfitems++;
		//System.out.println("Ïnseted "+bs.num);
		
	}
	BSTree pop(){
		if (noOfitems == -1) {
			System.out.println("Queue Empty");
			return null;
		}
		noOfitems--;
		//System.out.println(" Ëlement removed ");
		//rear++;
		//System.out.println(rear);
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
	public void inset(BSTree b,Integer n) {
		if (b == null)
			return;
		BSTree temp=null;
		while (b != null) {
			temp = b;
			if (n == b.num)
				return;
			if (n < b.num)
				b = b.left;
			else
				b = b.right;
		}
		if (n < temp.num )
			temp.left = new BSTree(n);
		else
			temp.right = new BSTree(n);
		
	}
	
	@Override
	public String toString() {
		return num +"===>";
	}
	void bfs(BSTree p) {
		if (p == null)
			return;
		Queue q = new Queue();
		q.push(p);
		while (!q.isEmpty()){
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
		System.out.print(b.num+"    "+"--->");
		inOrder(b.right);
	}
	public static void main(String[] args) {
		BSTree bs = new BSTree(24);
		bs.inset(bs, 32);
		bs.inset(bs, 23);
		bs.inset(bs, 25);
		bs.inset(bs, 98);
		bs.inset(bs, 14);
		bs.bfs(bs);
		bs.inOrder(bs);
	
	}
	
	

}