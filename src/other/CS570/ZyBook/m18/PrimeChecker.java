package other.CS570.ZyBook.m18;

public class PrimeChecker {

  public static int isPrime(int testVal, int divVal) {       // Returns 0 if value is not prime, 1 if value is prime
    int resultVal = 0;

    if ((testVal == 0) || (testVal == 1)){        // Base case 1: 0 and 1 are not prime, testVal is not prime
      resultVal = 0;
    }
    else if (divVal == 1) {                             // Base case 2: testVal only divisible by 1, testVal is prime
      resultVal = 1;
    }
    else {
      if (testVal % divVal != 0) {
        return isPrime(testVal, (divVal-1));
      } else {
        resultVal = 0;
      }
    }
    return resultVal;
  }

  public static void main(String[] args) {
    int primeCheckVal;       // Value checked for prime

    // Check primes for values 1 to 10
    for (primeCheckVal = 1; primeCheckVal <= 10; ++primeCheckVal) {
      if ( isPrime(primeCheckVal, (primeCheckVal - 1)) == 1 ) {
        System.out.println(primeCheckVal + " is prime.");
      }
      else {
        System.out.println(primeCheckVal + " is not prime.");
      }
    }
  }
}
