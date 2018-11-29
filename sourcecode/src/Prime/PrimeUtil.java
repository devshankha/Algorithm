package Prime;



import java.math.BigInteger;

public abstract class PrimeUtil 
{

   public static BigInteger findFirstPrime(	long lowerBound, 
		   									long upperBound) 
   {
	   BigInteger result;
	   BigInteger startPos = BigInteger.valueOf(lowerBound);	 
	   BigInteger nextProbablePrime;
	   
	   if (startPos.isProbablePrime(32)) //reasonable accuracy
		   nextProbablePrime = startPos;
	   else nextProbablePrime = startPos.nextProbablePrime();
	   
	   if (nextProbablePrime.longValue() >= upperBound)
		   result = null;
	   else result = nextProbablePrime;
	   
      return result;
   }
}
