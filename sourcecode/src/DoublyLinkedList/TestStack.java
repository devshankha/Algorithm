package List;

import SearchTree.BTree;

public class TestStack {
	
		int top ;	
		int[] nums;
		int MAXSIZE = 10;	
		public TestStack() {		
			nums = new int[MAXSIZE];
			top = -1;
					
		}
		public static void revertStack(TestStack s) {
		    if (s.isEmpty()) {
		        return;
		    } else {
		        Integer a = s.pop();
		        revertStack(s);
		        appendStack(s, a);
		    }
		}

		public static void appendStack(TestStack s, int a) {
		    if (s.isEmpty()) {
		        s.push(a);
		        return;
		    } else {
		        Integer o = s.pop();
		        appendStack(s, a);
		        s.push(o);
		    }
		}
		void push (int b){
			
			nums[++top] = b;
		}
		int pop (){
			return nums[top--];
		}
		boolean isEmpty(){
			return top == -1;
		}
		void print () {
			for (int i=0; i <= top;i++) {
				
				System.out.print(nums[i]+" ");
			}
			
		}
		public static void main(String[] args) {
			TestStack s = new TestStack();
			s.push(1);
			s.push(2);
			s.push(3);
			s.push(4);
			s.push(5);
			s.print();
			
			System.out.println();
			
			s.revertStack(s);
			System.out.println();
			s.print();
			
		}
	}


