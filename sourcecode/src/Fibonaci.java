
public class Fibonaci {
	int fib(int n)
	{
	   if ( n <= 1 )
	      return n;
	   //System.out.println(fib(n-1) + fib(n-2));
	   return fib(n-1) + fib(n-2);
	}
	public static void main(String[] args) {
		Fibonaci f = new Fibonaci();
		int k =f.fib(1);
		System.out.println(k);
	}

}
