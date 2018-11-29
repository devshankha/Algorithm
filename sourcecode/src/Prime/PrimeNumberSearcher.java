package Prime;

import java.math.BigInteger;

public interface PrimeNumberSearcher 
{
   PrimeNumberSource  findPrimeNumbers(	BigInteger lowerBound,
		   								BigInteger upperBound);
}