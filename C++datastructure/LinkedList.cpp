// LinkedList.cpp : Defines the entry point for the console application.
//

#include "stdafx.h"
#include <iostream>
using namespace std;
class LinkedList {
private:
	struct node {
		int data;
		node *next;
		};
	node *p;
public:
	LinkedList(){
		p = NULL;

		}
	~LinkedList(){
		if (p == NULL)
			return;
		node *temp = p;
		while (temp != NULL) {
			p = temp;
			temp = temp->next;
			delete p;

		}

	}
	void lastToFirst(){
		if (p == NULL)
			return;
		node *temp = p;
		node *last = NULL;
		while(temp->next != NULL){
			last = temp;
			temp = temp->next;

		}
		last->next = NULL;
		temp->next = p;
		p = temp;
	}
	};
	LinkedList(int num) {
		p = new node;
		p->data = num;
		p->next = NULL;
		}
	void deleteAlternate(){
		node *temp = p;
		while (true) {
			node *temp1 = temp->next;
			if (temp1 == NULL)
				break;
			node *temp2 = temp1->next;
			if (temp2 == NULL) {
				temp->next = NULL;
				cout << "Just before deleting temp next";
				delete temp->next;
				break;
			}
			temp->next = temp2;
			temp1->next = NULL;
			delete temp1->next;
			temp = temp2;

		}

	}
	void deleteEnd() {
		if (p == NULL)
			return;
		node *temp = p;
		node *last = NULL;
		while (temp->next != NULL){
			last = temp;
			temp = temp->next;

		}
		delete temp;
		last->next = NULL;
	}
	void append(int num){
		if (p == NULL){
			p = new node;
			p->data = num;
			p->next = NULL;
			return;
			}
		node *temp = p;
		while (temp->next != NULL){
			temp = temp->next;
			}
		temp->next = new node;
		temp->next->data = num;
		temp->next->next = NULL;
		}
	void display(){
		node *temp = p;
		while (temp != NULL){
			cout << temp->data << endl;
			temp = temp->next;
			}
		}
	};


int _tmain(int argc, _TCHAR* argv[])
{
LinkedList l;
l.append(1);
l.append(2);
l.append(3);
l.append(7);
cout << endl;
l.display();


	return 0;
}

