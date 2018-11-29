package Prime;


import java.math.BigInteger;


public class PrimeNumberReader extends Thread 
{
	private PrimeNumberSource source;
	public PrimeNumberReader(PrimeNumberSource source)
	{
		this.source = source;
	}
	
	@Override
	public void run() 
	{
		BigInteger nextVal=null;
		
		do
		{
			nextVal = source.nextPrime();
			if (nextVal!=null)
				System.out.println(nextVal + ", ");
			else break;
		}while (true);		
	}
}
