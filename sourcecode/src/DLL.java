
public class DLL {
	Node head;

	class Node {
		int data;
		Node prev;
		Node next;

		// Constructor to create a new node
		// next and prev is by default initialized as null
		Node(int d) {
			data = d;
		}
	}
	
	void reverse() { 
        Node temp = null; 
        Node current = head; 
  
        /* swap next and prev for all nodes of  
         doubly linked list */
        while (current != null) { 
            temp = current.prev; 
            current.prev = current.next; 
            current.next = temp; 
            current = current.prev; 
        } 
  
        /* Before changing head, check for the cases like empty  
         list and list with only one node */
        if (temp != null) { 
            head = temp.prev; 
        } 
    } 
  
	
	public void push(int new_data) {
		Node n = new Node(new_data);
		n.next = head;
		n.prev = null;
		if (head != null) {
			head.prev = n;
		}
		head = n;

	}
	
	public void printlist(Node node) {
		Node temp = head; 
        System.out.println("Traversal in forward Direction"); 
        while (temp != null) { 
            System.out.print(temp.data + " ");              
            temp = temp.next; 
        } 
	}
	
	public void append(int new_data) {
		Node n = new Node(new_data);
		if (head == null) { 
	        n.prev = null; 
	        head = n; 
	        return; 
	    } 
		Node temp = head;
		while (temp.next != null) {
			temp = temp.next;
		}
		temp.next = n;
		n.prev = temp;
		
		
	}
	
	public static void main(String[] args) {
		DLL dll = new DLL();
		dll.append(2);
		dll.append(3);
		dll.append(4);
		dll.push(54);
		dll.printlist(dll.head);
		dll.reverse();
		System.out.println();
		dll.printlist(dll.head);
	}

}
