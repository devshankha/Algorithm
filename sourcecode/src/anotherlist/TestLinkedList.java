package test;

class LinkedList {
	int data;
	LinkedList next;

	public LinkedList(int d) {
		this.data = d;
		this.next = null;
	}

	void insertEnd(int d) {
		LinkedList temp = this;
		while (temp.next != null)
			temp = temp.next;
		temp.next = new LinkedList(d);

	}
	void delete(int d){
		LinkedList temp1 = this;
		LinkedList temp2 = null;
		while (temp1.data != d){
			temp2 = temp1;
			temp1 = temp1.next;
			if (temp1 == null)
				break;
			
		}
		temp2.next = temp1.next;
	}

	void print() {
		LinkedList temp = this;
		while (temp != null) {
			System.out.print(temp.data + " -->");
			temp = temp.next;

		}
	}

}

public class TestLinkedList {
	public static void main(String[] args) {
		LinkedList l1 = new LinkedList(1);
		l1.insertEnd(2);
		l1.insertEnd(3);
		l1.insertEnd(4);
		l1.print();
		System.out.println();
		l1.delete(3);
		l1.print();
	}

}
