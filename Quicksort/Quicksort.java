
public class Quicksort {
	public static void printArray(int[] arr){
		  System.out.println("\nPrinting array contents:");
		  for(int i=0; i<arr.length; i++ ) {
		   System.out.print(arr[i]+" ");
		  }
		  System.out.println("\n");
		 }
	static int partition (int arr[],int left, int right){
		int pivot = arr[right];
		int pivotpos = right;
		while (true){
			while (arr[left] < pivot)
				left++;
			while ( right >= 0 && arr[right] >= pivot)
				right--;
			if (left < right) {
				swap (arr,left,right);
				//printArray(arr);
			}
			else break;
			
		}
		swap(arr,left,pivotpos);
		return left;
	}
	static void swap (int arr[], int left, int right) {
		int x= arr[left];
		int y = arr[right];
		int temp =y;
		arr[right]=x;
		arr[left]= y;
		
	}
	static void quickSort(int arr[], int left, int right)
	 {
	  int index = partition(arr, left, right);
	  
	  if(left< index-1)
	  {
	   quickSort(arr,left,index-1);
	  }
	  if( index < right-1) 
	  {
	   quickSort(arr,index+1,right);
	  }
	 }
	public static void main(String[] args) {
		int arr[] ={9,13,12,7,11,6,54,92,17,4,98};
		//int arr[] ={4,7,1,9,11,3};
		printArray(arr);
		quickSort(arr, 0, arr.length-1);
		printArray(arr);
		
	
	}

}
