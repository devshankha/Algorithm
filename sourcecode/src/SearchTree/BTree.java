package SearchTree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
class Stack {
	int top ;	
	BTree[] bsTree;
	int MAXSIZE = 100;	
	public Stack() {		
		bsTree = new BTree[MAXSIZE];
		top = -1;
				
	}
	void push (BTree b){
		
		bsTree[++top] = b;
	}
	BTree pop (){
		return bsTree[top--];
	}
	boolean isEmpty(){
		return top == -1;
	}
}
class Level {
	int level;
	Integer value;
	public Level(int level, Integer value) {
		super();
		this.level = level;
		this.value = value;
	}
	@Override
	public String toString() {
		return level+" - "+value;
	}
	
	
	
}


class Queue {
	
	int top ;
	int rear;
	BTree[] bsTree;
	int MAXSIZE = 10;
	int noOfitems ;
	public Queue() {		
		bsTree = new BTree[MAXSIZE];
		top = -1;
		rear = -1;
		noOfitems = -1;
		
	}
	boolean isEmpty(){
		if (noOfitems == -1)
			return true;
		return false;
	}
	void push (BTree bs){
		if (noOfitems == (MAXSIZE-1)) {
			System.out.println("Queue full");
			return;
		}
		bsTree[++top]=bs;
		noOfitems++;
		//System.out.println("Ïnseted "+bs.num);
		
	}
	BTree pop(){
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

public class BTree {
	List<Level> l = new ArrayList<>();
	
	Integer value;
	BTree left;
	BTree right;
	BTree(Integer v) {
		value = v;
		
	}
	public void dfs(){
		Stack stack = new Stack();
		BTree temp = this;
		
		if (temp == null)
			return;
		System.out.println(stack.isEmpty());
		stack.push(temp);
while (!stack.isEmpty()) {
			
			temp = stack.pop();
			System.out.print(temp+" ");
			
			if (temp.left != null) {
				stack.push(temp.left);
				
			}
			if (temp.right != null) {
				stack.push(temp.right);
				
			}
			
			
		}
		
	}
	public void bfs () {
		Queue q = new Queue();
		BTree temp = this;
		Integer i=-1;
		if (temp == null)
			return;
		q.push(temp);
		
		
		while (!q.isEmpty()) {
			
			temp = q.pop();
			System.out.print(temp+" ");
			
			if (temp.left != null) {
				q.push(temp.left);
				
			}
			if (temp.right != null) {
				q.push(temp.right);
				
			}
			
			
		}
		
	}
	public String toString(){
		return value.toString();
	}
	void inset (Integer v){
	
		if (this == null)
		return;
		BTree temp = this;
		Integer value = this.value;
		if (v <= temp.value) {
			while (temp.left != null && v <= temp.value )
				temp = temp.left;
			
		}
		if (v >= temp.value) {
			while (temp.right != null && v >= temp.value )
				temp = temp.right;
			
		}
		
		if (v >= temp.value)
			temp.right = new BTree(v);
		else
			temp.left = new BTree(v);
	}
	void inOrder(BTree p){
		if (p == null)
			return;
		inOrder(p.left);
		System.out.print(p+" ");
		inOrder(p.right);
	}
	public static void main(String[] args) {
		BTree b = new BTree(15);
		b.inset(8);
		b.inset(24);
		b.inset(6);
		b.inset(1);
		b.inset(19);
		//System.out.println();
		//b.bfs();
		//System.out.println();
	
	
		
				
		BTree temp = b;
		//b.inOrder(temp);
		b.dfs();
	}

}
