package Prime;

import java.math.BigInteger;
import java.util.logging.Logger;


public class PrimeSearchThread implements Runnable
{
	private long lowerBound;
	private long upperBound;
	private ConcurrentPrimeNumberSource numberSource;
		
	public PrimeSearchThread(	BigInteger lowerBound, 
								BigInteger upperBound,
								ConcurrentPrimeNumberSource numberSource) 
	{
		this.lowerBound = lowerBound.longValue();
		this.upperBound = upperBound.longValue();
		this.numberSource = numberSource;
	}
	
	public void run() 
	{
		BigInteger lastSearchResult, 
					searchResult= BigInteger.valueOf(lowerBound);		
		do			
		{
			lastSearchResult = searchResult;
			try
			{
				searchResult = 
					PrimeUtil.findFirstPrime( lastSearchResult.longValue()+1, 
												upperBound);
				if (searchResult!=null)
					numberSource.addResultToBuffer(searchResult);
				else break;				
			}
			catch (Throwable t)
			{
				Logger.getAnonymousLogger().severe(
						"Method findPrime(int,int) resulted in a runtime error");
				t.printStackTrace(System.err);				
				//continue where search left off?
			}
		}while (searchResult!=lastSearchResult);
		
		numberSource.searchThreadCompleted();		
	}
}