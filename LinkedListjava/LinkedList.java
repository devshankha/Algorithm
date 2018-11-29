

public class LinkedList {
	private String value;
	private LinkedList next;
	
	public LinkedList(String value) {		
		this.value = value;
		this.next = null;
	}
	//This method inserts nodes at the end of the linkedlist
	public void insertEnd(LinkedList p, String value){
		if (p == null)
			return ;
		while ( p.next != null)
			p= p.next;
		p.next = new LinkedList(value);
		
		
	}
	public void deleteEnd(){
		
	}
	//This method reverse a linkedlist
	LinkedList reverse(LinkedList p) {
		 LinkedList prev = null;
	     LinkedList current = p;
	     LinkedList next = null;
	     while (current != null) {
	            next = current.next;
	            current.next = prev;
	            prev = current;
	            current = next;
	        }
	       p = prev;
	       return p;
	     
		
	}
	//Prints the nodes of a linkedlist
	public void display(LinkedList p){
		while ( p != null) {
			System.out.print(p.value+"----> ");
			p= p.next;
		}
		
	}
	//Prints the nodes of a linked list recursively from back
	public LinkedList recReverse(LinkedList p) {
		if (p == null || p.next == null)
			return p;
		LinkedList temp = p.next;
		p.next = null;
		LinkedList count = recReverse(temp);
		temp.next = p;
		
		return count;	
		
	}
	//pairwiseswap elements of a linked list
	LinkedList pairwiseswap(){
		if (this == null)
			return null;
		LinkedList prev = this;
		LinkedList current = this.next;		
		LinkedList node = current;
		LinkedList next = null;
		
		while (true){
			next = current.next;
			current.next = prev;
			//prev.next = next;
			
			if (next == null || next.next == null){
				System.out.println("If it comes here");
				prev.next = next;
				
				break;		
				
			}
			prev.next = next.next;			
			current = prev.next;
			prev = next;
			
		}
		return node;
	}
	//merge alternate nodes of linkedlist
	static LinkedList mergeAlternate(LinkedList l1,LinkedList l2){
		LinkedList c=null;
		LinkedList temp1 = l1;
		LinkedList temp2 = l2;
		while (true){
			if (temp1 != null){
				LinkedList p = temp1;
				temp1 = temp1.next;
				p.next = null;
				LinkedList counter = c;
				if (c == null){
					c = p;
				} else {
				while (counter.next != null){
					counter = counter.next;				
					
				}
				counter.next = p;
				}
				
				
			}
			if (temp2 != null) {
				LinkedList p = temp2;
				temp2 = temp2.next;
				p.next = null;
				LinkedList counter = c;
				if (c == null) {
					c = p;
				} else {
					while (counter.next != null) {
						counter = counter.next;

					}
					counter.next = p;
				}

			}
			if (temp1 == null && temp2 == null)
				return c;
		}
	}
	// deletes alternate nodes of a linked list
	void deleteAlternate(){
		if (this == null )
			return;
		
		LinkedList temp1 = this;
		LinkedList temp2 = this.next;
		LinkedList temp3 = null;
		
		while(true){
			if (temp2 == null){
				temp1.next = null;
				return;
			}
			temp3 = temp2.next;
			if (temp3 == null){
				temp1.next = null;
				return;
			}
			temp1.next = temp3;
			temp2.next = null;
			temp1 = temp3;
			temp2 = temp1.next;
			
			
		}
			
		
	}

	public static void main(String[] args) {
		LinkedList l = new LinkedList("1");
		l.insertEnd(l,"2");	
		l.insertEnd(l,"3");
		l.insertEnd(l,"4");	
		l.insertEnd(l,"5");
		l.insertEnd(l,"6");
		l.display(l);
		System.out.println(" -------- ");
		l=l.reverse(l);
		l.display(l);
		System.out.println(" -------- ");
		LinkedList l1 = new LinkedList("11");
		l1.insertEnd(l,"12");	
		l1.insertEnd(l,"13");
		l1.insertEnd(l,"14");	
		l1.insertEnd(l,"15");
		l1.insertEnd(l,"16");
		LinkedList c = LinkedList.mergeAlternate(l, l1);
		
		
		
	}

}
