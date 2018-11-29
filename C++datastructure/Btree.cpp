// Btree.cpp : Defines the entry point for the console application.
//

#include "stdafx.h"
# include <iostream>
using namespace std;
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
	void inorder(BTree *t){
		if ( t ) {
       inorder(t->p->left);
       cout << t->p->data << " ";
       inorder(t->p->right);
    }



	}
};


int _tmain(int argc, _TCHAR* argv[])
{
	BTree t(5);
	t.insert(6);
	t.insert(6);
	t.insert(13);
	t.insert(99);
	t.insert(2);
	t.insert(7);
	t.insert(-3);
	//t.insert(4);
	//t.insert(11);
	//cout << t.p->data;
	//cout << t.p->left->p;
	//cout << t.p->left->p->data;
	t.inorder(&t);
	return 0;
}

