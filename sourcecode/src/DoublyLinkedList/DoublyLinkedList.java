package List;



class Link {
	  public int iData;
	  public Link next;
	  public Link previous;

	  public Link(int id) {
	    iData = id;
	  }

	  public String toString() {
	    return "{" + iData + "} ";
	  }
	}

	public class DoublyLinkedList {
		 private Link first;
		  private Link last;

		  public DoublyLinkedList() {
		    first = null;
		    last = null;
		  }

		  public boolean isEmpty() {
		    return first == null;
		  }
		  public void insertFirst(int dd) {
			    Link newLink = new Link(dd);
			    if (isEmpty()){
			      last = newLink;
			    }else{
			      first.previous = newLink;
			    }
			    newLink.next = first;
			    first = newLink;
			  }
		  public void insertLast(int dd) {
			    Link newLink = new Link(dd);
			    if (isEmpty()){
			      first = newLink;
			    }else {
			      last.next = newLink;
			      newLink.previous = last;
			    }
			    last = newLink;
			  }
		  public boolean insertAfter(int key, int dd) {
			    Link current = first;
			    while (current.iData != key) {
			      current = current.next;
			      if (current == null){
			        return false;
			      }
			    }
			    Link newLink = new Link(dd);

			    if (current == last) {
			      newLink.next = null;
			      last = newLink;
			    } else {
			      newLink.next = current.next;

			      current.next.previous = newLink;
			    }
			    newLink.previous = current;
			    current.next = newLink;
			    return true;
			  }
		  public void display() {
			 /*   String str = "List (first-->last): ";
			    Link current = first;
			    while (current != null) {
			      str += current.toString();
			      current = current.next;
			    }
			    System.out.println("");
			    //System.out.print("List (last-->first): ");

			    current = last;
			    while (current != null) {
			      str += current.toString();
			      current = current.previous;
			    }
			    return str;*/
			  String str = null;
			  Link current = first;
			    while (current != null) {
			      str = current.toString();
			      System.out.print(str+" ");
			      current = current.next;
			    }
			  }
			
		  
		  public static void main(String[] args) {
			  DoublyLinkedList theList = new DoublyLinkedList();
			  theList.insertFirst(22);
			  theList.insertLast(34);
			  theList.insertLast(58);
			  theList.insertLast(134);
			  theList.insertFirst(212);
			  theList.display();
			 // System.out.println(theList);
		}

	}
