package test;
class Link
{
public long dData;                 // data item
public Link next;                  // next link in list
public Link previous;              // previous link in list
//-------------------------------------------------------------
public Link(long d)                // constructor
   { dData = d; }
//-------------------------------------------------------------
public void displayLink()          // display this link
   { System.out.print(dData + " "); }
//-------------------------------------------------------------
}  // end class Link
class vDoublyLinkedList
{
private Link first;               // ref to first item
private Link last;                // ref to last item
//-------------------------------------------------------------
public vDoublyLinkedList()         // constructor
   {
   first = null;                  // no items on list yet
   last = null;
   }
//-------------------------------------------------------------
public boolean isEmpty()          // true if no links
   { return first==null; }
public void deleteLast() {
	Link temp = last.previous;
	temp.next = null;
	last.previous = null;
	last = temp;
}
public void insertLast(long dd)   // insert at end of list
{
Link newLink = new Link(dd);   // make new link
if( isEmpty() )                // if empty list,
   first = newLink;            // first --> newLink
else
   {
   last.next = newLink;        // old last --> newLink
   newLink.previous = last;    // old last <-- newLink
   }
last = newLink;                // newLink <-- last
}
public void displayForward()
{
System.out.print("List (first-->last): ");
Link current = first;          // start at beginning
while(current != null)         // until end of list,
   {
   current.displayLink();      // display data
   current = current.next;     // move to next link
   }
System.out.println("");
}
}

public class AnotherLinkedList {
	public static void main(String[] args) {
		 vDoublyLinkedList theList = new vDoublyLinkedList();
		 theList.insertLast(11);       // insert at rear
	      theList.insertLast(33);
	      theList.insertLast(55);
	      theList.displayForward();
	      theList.deleteLast();
	      System.out.println();
	      theList.displayForward();
	      theList.insertLast(155);
	      theList.insertLast(30);
	      theList.displayForward();
		
	}

}
