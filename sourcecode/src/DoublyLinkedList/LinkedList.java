package List;
public class LinkedList {
	private String value;
	private LinkedList next;
	
	public LinkedList(String value) {		
		this.value = value;
		this.next = null;
	}
	public void insertEnd( String value){
		LinkedList temp = this;
		while (temp.next != null)
			temp = temp.next;
		temp.next = new LinkedList(value);
		
		
	}
	public void deleteEnd(){
		
	}
	public void display(LinkedList p){
		while ( p != null) {
			System.out.print(p.value+"----> ");
			p= p.next;
		}
		
	}
	public LinkedList recReverse(LinkedList p) {
		if (p == null || p.next == null)
			return p;
		LinkedList temp = p.next;
		p.next = null;
		LinkedList count = recReverse(temp);
		temp.next = p;
		
		return count;	
		
	}

	public static void main(String[] args) {
		LinkedList l = new LinkedList("1");
		l.insertEnd("2");	
		l.insertEnd("3");	
		l.insertEnd("4");	
		l.display(l);
		System.out.println();
		l = l.recReverse(l);
		l.display(l);
		
	}

}
