// SetOfStacks, this program is almost taken from Cracking coding interviews

import java.util.ArrayList;
import java.util.List;

class Stack {
	int top;
	int arr[];
	int elements;
	public Stack(int s) {
		arr = new int[s];
		top = -1;		
	}
	void push(int element) {
		arr[++top]= element;
		elements++;
		
	}
	int pop() {
		elements--;
		return arr[top--];
	}
	public boolean isEmpty() {
		return elements==0;
	}
	public boolean isFull() {
		return elements == arr.length-1;
	}
}
public class SetOfStacks {
	List<Stack> stacks = new ArrayList<Stack>();
	int capacity;
	
	public Stack getLastStack( ) {
		if (stacks.size()==0)
			return null;
		return stacks.get(stacks.size()-1);
	}
	

	
	public void push(int element) {
		Stack last = getLastStack();
		if (last != null && !last.isFull()) {
			last.push(element);
		} else {
			Stack s = new Stack(capacity);
			s.push(element);
			stacks.add(s);
		}

	}
	
	public int pop() {
		Stack last = getLastStack();
		if (last == null)
			throw new RuntimeException();
		int v = last.pop();
		if (last.isEmpty())
			stacks.remove(stacks.size()-1);
		return v;
		
		
		
	}
	

}
