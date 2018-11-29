// Btree.cpp : Defines the entry point for the console application.
//

#include "stdafx.h"
# include <iostream>
using namespace std;
class BTree;
class Queue {
	BTree *arr[500];
	int MAX;
	int front;
	int rear;
	int count;
    public:
	Queue(){
		MAX = 500;
		//a = new BTree[MAX];
		front = rear = -1;
		count = 0;
	}
	void push(BTree *d) {
		arr[++front] = d;
		count++;
		//cout << "In push method "<<arr[front]<<'\t'<<front<<'\t'<<arr[1]<<endl ;
	}
	BTree * pop(){
		//cout << "In pop LLL "<< arr[1];
		count--;
		//BTree d = arr[++rear];
		return arr[++rear];
	}
	bool isEmpty(){
		return count==0; 
	}


};
class Stack {
	BTree *arr[500];
	int index;
	int count;
	
    public:
	Stack(){
		
		index = -1;
		count = 0;
	}
	void push(BTree *d) {
		arr[++index] = d;
		count++;
		//cout << "In push method "<<arr[front]<<'\t'<<front<<'\t'<<arr[1]<<endl ;
	}
	BTree * pop(){
		//cout << "In pop LLL "<< arr[1];
		count--;
		//BTree d = arr[++rear];
		return arr[index--];
	}
	bool isEmpty(){
		return count==0; 
	}


};
class BTree {
public:
	struct node {
		int data;
		BTree *left;
		BTree *right;

	} *p;

	BTree(){
	}
	BTree(int d){		
		p = new node();
		p->data = d;		
		p->left = NULL;
		p->right = NULL;
		
	}
	void insert (int d) {
		
		if (d == p->data)
			return;
		BTree *temp1 = this;
		BTree *temp2 = temp1;
		while (true){
			temp2 = temp1;
			bool lessThan = false;
			if (d < temp1->p->data) {				
				lessThan = true;				
			}		
			if (lessThan)
				temp1 = temp1->p->left;
			else 
				temp1 = temp1->p->right;


			if (temp1 == NULL) {				
				if (d < temp2->p->data) {
					temp2->p->left = new BTree(d);					
				} 
				if (d > temp2->p->data) {
					temp2->p->right = new BTree(d);		

				}
				return;
				
			}			
			if (d == temp1->p->data)
				break;
		}

	}
	//method to find height of a tree;
	static int height (BTree *t){
		if (t == NULL)
			return 0;
		int left =height(t->p->left);
		int right =height(t->p->right);
		if (left > right)
			return left+1;
		return right+1;



	}
	/* Print nodes at the given level */
    static void printGivenLevel (BTree *root ,int level)
    {
        if (root == NULL)
            return;
        if (level == 1)
            cout << root->p->data<<'\t';
        else if (level > 1)
        {
            printGivenLevel(root->p->left, level-1);
            printGivenLevel(root->p->right, level-1);
        }
    }
	//print all the nodes level wise
	  void printLevelOrder()
    {
        int h = height(this);
        int i;
        for (i=1; i<=h; i++) {
			//cout << "For level "<<i<< '\t';
            printGivenLevel(this, i);
			cout << endl;
		}
    }
     // do breadth traversal
	static void breadthfirst(BTree d){
		Queue s;
		s.push(&d);
		while (!s.isEmpty()){
			BTree *node = s.pop();
			cout << node->p->data<< '\t';
			if (node->p->left != NULL)
				s.push(node->p->left);
			if (node->p->right != NULL)
				s.push(node->p->right);
		}

	}
	void printLevel(BTree *t,int level,int *max_level){
		if (t == NULL)
			return ;
		if (*max_level < level){
			cout << t->p->data<<'\t';
			*max_level = level;
		}
		printLevel(t->p->left,level+1,max_level);
		printLevel(t->p->right,level+1,max_level);
	}
	//Print the left view of a binary tree
	void printLeftView(BTree t){
		int max = 0;
		printLevel(&t,1,&max);

	}
	//// do depth traversal
	static void deapthfirst(BTree d){
		Stack s;
		s.push(&d);
		while (!s.isEmpty()){
			BTree *node = s.pop();
			cout << node->p->data<< '\t';
			if (node->p->left != NULL)
				s.push(node->p->left);
			if (node->p->right != NULL)
				s.push(node->p->right);
		}

	}
	void inorder(BTree *t){
		if ( t ) {
       inorder(t->p->left);
       cout << t->p->data << " ";
       inorder(t->p->right);
    }
		// This function checks whether a BT is a BST
	bool isBST(BTree *t){
		return isBSTUtil(t,-100,100);
	}
	bool isBSTUtil(BTree *t, int min, int max){
		 if (t == NULL)
			return true;
		// cout << "In the initial "<< t->p->data<<'\t'<<min <<'\t'<<max<<'\t'<< endl;
		if (t->p->data > max || t->p->data < min) {
			// cout << "If it comes here "<<min <<'\t'<< max<< '\t'<<t->p->data ;
			return false;
		}
		return isBSTUtil(t->p->left,min,t->p->data-1) && isBSTUtil(t->p->right,t->p->data+1,max);
		
		


	}



	}
};

int _tmain(int argc, _TCHAR* argv[])
{
	Queue s;
	BTree t(5);
	t.insert(3);
	t.insert(2);
	t.insert(8);
	t.insert(7);

	
	//t.inorder(&t);
	cout << endl;
	//BTree::breadthfirst(t);
	cout << endl;
	// BTree::deapthfirst(t);
	cout << endl;
	// cout << "The height is "<< BTree::height(&t)<< endl;
	//BTree::printGivenLevel(&t,2);
	 t.printLevelOrder();




	
	return 0;
}

