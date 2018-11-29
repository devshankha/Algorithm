package Heap;

import java.util.Arrays;
class MyHeap {
	int arr[];
	int currentsize;
	MyHeap(int[] a){
		arr = a;
		currentsize = arr.length;
		
	}
	 private int kthChild(int i,int k){
	        return 2*i  +k;
	    }
	    
	private int maxChild(int i) {
        int leftChild = kthChild(i, 1);
        int rightChild = kthChild(i, 2);
          
        return arr[leftChild]>arr[rightChild]?leftChild:rightChild;
    }
	void modify(){
		for (int j= arr.length/2-1;j >=0;j--)
			trickleDown(j);
	}
	
	void trickleDown(int index) {
		
		int temp = arr[index];

		while (temp < arr[maxChild(index)]) {
			// System.out.println("Printing the value of "+temp+" "+arr[maxChild(index)]);

			arr[index] = arr[maxChild(index)];

			index = maxChild(index);
			if (2*index+1 >= currentsize)
				break;

		}
		arr[index]= temp;

	}
	
}

class HeapSort {
	static int[]heapsort(int arr[]){
		Heap s1 = new Heap(arr.length);
		for (int l=0; l < arr.length;l++){
			s1.insert(arr[l]);
		}
		int perm[]= new int[arr.length];
		for (int l=0; l < arr.length;l++){
			perm[l]=s1.remove();
		}
		return perm;
		
		
	}
}

public class Heap {
	private int[] arr;
    private int size;
    private int currentsize;
    Heap(int s){
    	size = s;
    	arr = new int[size];
    	currentsize = 0;
    	Arrays.fill(arr, 0);
    	
    }
    
    public boolean isEmpty(){
        return currentsize==0;
    }
    
    public boolean isFull(){
        return currentsize == size;
    }
    
    private int parent(int i){
        return (i-1)/2;
    }
    
    private int kthChild(int i,int k){
        return 2*i  +k;
    }
    
	private int maxChild(int i) {
        int leftChild = kthChild(i, 1);
        int rightChild = kthChild(i, 2);
          
        return arr[leftChild]>arr[rightChild]?leftChild:rightChild;
    }
	
	void display() {
		for (int i = 0; i < size; i++)
			System.out.print(arr[i] + " ");
	}
	 /**
     *  This will delete element at index x
     *  Complexity: O(log N)
     *
     */
	public int remove() {
		int root = arr[0];
		arr[0] = arr[currentsize-1];
		arr[--currentsize]= 0;
		trickleDown(0);
		return root;
	}      
	
	void trickleDown(int index) {
		//the commented out algo also works
		/*int child;
		int temp = arr[index];
		while (kthChild(index, 1) < currentsize) {
			child = maxChild(index);
			if (temp < arr[child]) {
				arr[index] = arr[child];
			} else
				break;

			index = child;
		}
		arr[index] = temp;*/
		int temp = arr[index];

		while (temp < arr[maxChild(index)]) {
			// System.out.println("Printing the value of "+temp+" "+arr[maxChild(index)]);

			arr[index] = arr[maxChild(index)];

			index = maxChild(index);
			if (2*index+1 >= currentsize)
				break;

		}
		arr[index]= temp;

	}
      
    /**
     *  This will insert new element in to heap
     *  Complexity: O(log N)
     *  As worst case scenario, we need to traverse till the root
     */  
    boolean insert(int n){
    	if (currentsize == size)
    		return false;
    	arr[currentsize++]= n;
    	trickleUp(currentsize-1);
    	return true;
    }
  
    void trickleUp(int index){
    	int temp = arr[index];
        while(index>0 && temp > arr[parent(index)]){
            arr[index] = arr[parent(index)];
            index = parent(index);
        }
        arr[index] = temp;
    	
    }
    public static void main(String[] args) {
		Heap s1 = new Heap(8);
		s1.insert(3);
		s1.insert(9);
		s1.insert(2);
		s1.insert(7);
		s1.insert(5);
		s1.insert(8);
		s1.insert(1);
		
		System.out.println();
		int sm[]={9,5,3,4,7,8,1};
		//System.out.println(Arrays.toString(sm));
		int fd[]=HeapSort.heapsort(sm);
		System.out.println(Arrays.toString(sm));
		MyHeap sd = new MyHeap(sm);
		sd.modify();
		System.out.println(Arrays.toString(sd.arr));
	
	
	
		
	}
    

}
