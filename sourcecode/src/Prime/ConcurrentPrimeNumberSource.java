package Prime;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

//Note that this iterator is not thread safe
//as this was not a mandated requirement of 
//the solution.
//However a portion of this iterator does need to be
//thread-safe, specifically the counter which 
//tracks the number of still active tasks, and the 
//search results collection
//
//The collection is secured as a thread-safe list. The iterator
//uses a barrier to ensure that the hasNext method returns 
//the right result. Essentially, when the searchResults 
//have been exhausted, the calling thread waits at a barrier
//until search tasks complete and re-open the barrier.
public class ConcurrentPrimeNumberSource implements PrimeNumberSource
{
	private ThreadGate barrier;
	
	private List<BigInteger> resultsBuffer;
	private int resultsBufferAccessIndex;	
	
	protected ConcurrentPrimeNumberSource(int searchThreadsCount)
	{		
		barrier = new ThreadGate(searchThreadsCount);	
		resultsBuffer = 
				Collections.synchronizedList(new ArrayList<BigInteger>());
		resultsBufferAccessIndex = -1;
	}
	
	
	
	public synchronized BigInteger nextPrime() 
	{
		BigInteger result;
		int resultIndex = resultsBufferAccessIndex++;
		try
		{			
			//if results are exhausted, and not already closed
			//then shut the gate to future threads
			if (!barrier.isClosed() && 
					(resultIndex == resultsBuffer.size()))
				barrier.close();

			
			barrier.await(); 
			
			result = resultsBuffer.get(resultIndex);
		}
		catch (InterruptedException exce)
		{
			throw new RuntimeException("Search interrupted.");
		}
		catch (IndexOutOfBoundsException exce)
		{
			//search exhausted
			result = null;
		}		
		
		return result;
	}
	
	protected void searchThreadCompleted() {barrier.threadCompleted();}
		
	protected void addResultToBuffer(BigInteger result)
	{
		resultsBuffer.add(result);
		barrier.open();
	}
}