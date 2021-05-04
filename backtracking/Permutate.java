
//generate permutations of a string, this is very important,
//the code is taken from == https://www.geeksforgeeks.org/write-a-c-program-to-print-all-permutations-of-a-given-string/
//backtracking is used here, little complicated to understand, as this uses a combination of recursion and loops

public class Permutate {
	
	public String swap(String a, int i, int j)
    {
        char temp;
        char[] charArray = a.toCharArray();
        temp = charArray[i] ;
        charArray[i] = charArray[j];
        charArray[j] = temp;
        return String.valueOf(charArray);
    }
	
	private void permute(String str, int l, int r)
    {
		//System.out.println("MMMMMMMMMM");
        if (l == r) {
           System.out.println(str);
        	//System.out.println();
        	return;
        }
        
            for (int i = l; i <= r; i++)
            {
                str = swap(str,i,l);
               
                permute(str, l+1, r);
                str = swap(str,l,i);
            }
        
    }
	
	
	public static void main(String[] args) {
		 String str = "ABC";
	        int n = str.length();
	        Permutate permutation = new Permutate();
	        permutation.permute(str, 0, n-1);
		
	}

}
