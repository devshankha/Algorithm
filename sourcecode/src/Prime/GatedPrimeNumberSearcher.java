package Prime;

import java.math.BigInteger;

//This solution attempts to discover the number
//of available processors on the system, and create 
//n buckets of near even weight 
public class GatedPrimeNumberSearcher implements PrimeNumberSearcher 
{
	private int numberOfProcessors;
	
	public GatedPrimeNumberSearcher() 
	{
		numberOfProcessors = 
				Runtime.getRuntime().availableProcessors();		
	}
	
	public PrimeNumberSource findPrimeNumbers(	BigInteger aLowerBound, 
												BigInteger aUpperBound) 
	{
		if (aUpperBound.longValue()<=aLowerBound.longValue())
			throw new IllegalArgumentException(
					"Upperbound must be greater than lowerbound");
		long lowerBound = aLowerBound.longValue(), 
				upperBound = aUpperBound.longValue();
		
		final ConcurrentPrimeNumberSource result;
		
		PartitionInfo partitionInfo = getPartitionInfo(lowerBound, 
														upperBound);
		result = new ConcurrentPrimeNumberSource(partitionInfo.getNumberOfBuckets());
		
		Thread searchThread;
		long shiftingLowerBound = lowerBound,
			shiftingUpperBound = partitionInfo.getBucketSize();		
		while (shiftingUpperBound <= upperBound)
		{
			searchThread =new Thread(
					new PrimeSearchThread(BigInteger.valueOf(shiftingLowerBound),
											BigInteger.valueOf(shiftingUpperBound),
											result));
			
			searchThread.start();
			
			shiftingLowerBound = shiftingUpperBound;
			shiftingUpperBound+= partitionInfo.getBucketSize();
			
		}

		return result;
	}
	
	private PartitionInfo getPartitionInfo(long lowerBound, long upperBound)
	{
		PartitionInfo result;
		
		int proposedBucketCount = numberOfProcessors;
		long bucketSize = (upperBound-lowerBound) / proposedBucketCount;
		
		result = new PartitionInfo(proposedBucketCount, bucketSize);
		
		return result;
	}

}
