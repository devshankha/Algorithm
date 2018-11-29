package Prime;




class PartitionInfo
{
	int numberOfBuckets;
	long bucketSize;
	
	PartitionInfo(	int numberOfBuckets,
					long bucketSize)
	{
		this.numberOfBuckets = numberOfBuckets;
		this.bucketSize = bucketSize;
	}
	
	public int getNumberOfBuckets() {return numberOfBuckets;}
	public long getBucketSize() {return bucketSize;}
}