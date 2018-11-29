package test;
class Node {
	protected int data;
	protected Node next, prev;
	public Node() {
		super();
		this.data = 0;
		this.next = null;
		this.prev = null;
	}
	public Node(int data, Node next, Node prev) {
		super();
		this.data = data;
		this.next = next;
		this.prev = prev;
	}
	
	
}
class DLinkedList {
	 protected Node start;
	    protected Node end ;
	    public int size;
	 
	    /* Constructor */
	    public DLinkedList()
	    {
	        start = null;
	        end = null;
	        size = 0;
	    }
	    public void insertAtStart(int val)
	    {
	        Node nptr = new Node(val, null, null);        
	        if(start == null)
	        {
	            start = nptr;
	            end = start;
	        }
	        else
	        {
	            start.prev = nptr;
	            nptr.next = start;
	            start = nptr;
	        }
	        size++;
	    }
	    public void insertAtEnd(int val)
	    {
	        Node nptr = new Node(val, null, null);        
	        if(start == null)
	        {
	            start = nptr;
	            end = start;
	        }
	        else
	        {
	            nptr.prev = end;
	            end.next = nptr;
	            end = nptr;
	        }
	        size++;
	    }
	    public void display()
	    {
	        System.out.print("\nDoubly Linked List = ");
	        if (size == 0) 
	        {
	            System.out.print("empty\n");
	            return;
	        }
	        if (start.next == null) 
	        {
	            System.out.println(start.data );
	            return;
	        }
	        Node ptr = start;
	        System.out.print(start.data+ " <-> ");
	        ptr = start.next;
	        while (ptr.next != null)
	        {
	            System.out.print(ptr.data+ " <-> ");
	            ptr = ptr.next;
	        }
	        System.out.print(ptr.data+ "\n");
	    }
	

}


public class DoublyLinkedList {
	public static void main(String[] args) {
		DLinkedList l = new DLinkedList();
		l.insertAtEnd(1);
		l.insertAtEnd(2);
		l.insertAtEnd(3);
		l.insertAtEnd(4);
		l.display();
		l.insertAtStart(5);
		l.display();
	}

}
