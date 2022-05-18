package other.CS593;

/*
    HW1: Fermat with Infinite Precision Arithmetic
    Author: Songhan Yu  10470449
    Cite: https://stevens.zoom.us/rec/play/IqCo9R2BiXZkIuFZMP_bqTWpaGOwhRwQGcFu1c18YYC-4EVrOGmkfOxX3NC4KxlAONDPLrtSqb3y7y6K.EIDaKFXllvdY-tAQ
 */
/*  BigInteger power(BigInteger base, BigInteger exp)
        x^n if n=17, we have x^17 = x^10001 = x*x*x*x*...
                                  = x * x^16
                                  = x * x^8 * x^8
                                  = x * (x^4*x^4) * (x^4*x^4)
        n    x     prod
        17   2      2
        8    4      2
        4    16     2
        2    256    2
        1    65536  2^65536
 */
import java.util.*;
import java.math.BigInteger;

public class Fermet {
    private static Random random = new Random();

    public static BigInteger powerMod(BigInteger base, BigInteger exp, BigInteger mod) {  // http://www.java2s.com/example/java-utility-method/number-power/powermod-long-base-long-exp-long-mod-fd072.html
        BigInteger prod = BigInteger.ONE;  // prod <- 1
        while (!exp.equals(BigInteger.ZERO)) {  // loop condition: exp != 0
            if (exp.testBit(0)) {  // If rightmost binary bit of exponent is 1， ❤which means exponent is odd, then we need multiply one more base x, like x^17(decimal) = x^10001(binary) = x * x^16 . https://www.jianshu.com/p/734eca571be6. For example x^17(decimal) = x^10001(binary) will return true
                prod = prod.multiply(base).mod(mod);  // prod = (prod * x) % mod.
            }
            // for x^n (n is Even)
            base = base.multiply(base).mod(mod);  // x = x^x % mod. mod is for preventing Overflow
            exp = exp.divide(BigInteger.TWO);     // n = n/2
        }
        return prod;
    }

    /*
        Fermet Little Theorem:
        If 'p' is prime, then for all integers 'a' such that 2 <= a <= p-1, a**(p-1) % p = 1.
        Idea is to chose a random 'a' from the above mentioned range, and return "PRIME" if remainder is 1 for each time.
        This is a probabilistic method: It returns true for all primes, it may return true for composites (non-primes).

        Fermat(p, k)
          for i ← 1 to k
            a ← random(2, p-1)
            if powermod(a, p-1, p) != 1
              return false
            end
          end
          return true (probably?)
        end
     */
    public static String fermat(BigInteger prime, int k) {  // k is number of times that we check prime with random witness 'a'
        BigInteger pMinusOne = prime.subtract(BigInteger.ONE);  // calculate exponent p-1
        for (int i = 1; i < k; i++) {
            BigInteger a = new BigInteger(prime.bitCount(), random);  // generate a random BigInteger as witness, witness number 'a' is in the range (1, prime)
            while (a.compareTo(BigInteger.ONE) <= 0 || a.compareTo(prime) >= 0 ) {  // ❤ witness number 'a' must be in range 2 <= a <= p-1
                a = new BigInteger(prime.bitCount(), random);
            }
            // System.out.println("witness 'a' is " + a);
            // If p is prime, then for a witness: 1 < a < prime, we have a^(p-1) mod p == 1
            // If a^(p-1) mod p != 1, p is NOT PRIME
            // If a^(p-1) mod p == 1, p is PROBABLY PRIME
            if (powerMod(a, pMinusOne, prime).compareTo(BigInteger.ONE) != 0) {
                return "NOT PRIME";
            }
        }
        return "PRIME";
    }

    public static void main(String[]args) {
//        System.out.println("====== powerMod BigIntegerTest case1: prime 5 ====== ");
//        BigInteger a1 = new BigInteger("1");
//        BigInteger a2 = new BigInteger("2");
//        BigInteger a3 = new BigInteger("3");
//        BigInteger a4 = new BigInteger("4");
//        BigInteger p = new BigInteger("5");  // 5 is prime
//        BigInteger pMinusOne = p.subtract(BigInteger.ONE);
//        System.out.println(powerMod(a1, pMinusOne, p));  // 1^(prime-1) % prime = 1.  a1 = 1 is a witnesses
//        System.out.println(powerMod(a2, pMinusOne, p));  // 2^(prime-1) % prime = 1.  a2 = 2 is a witnesses
//        System.out.println(powerMod(a3, pMinusOne, p));  // 3^(prime-1) % prime = 1.  a3 = 3 is a witnesses
//        System.out.println(powerMod(a4, pMinusOne, p));  // 4^(prime-1) % prime = 1.  a4 = 4 is a witnesses
//
//
//        System.out.println("====== powerMod BigIntegerTest case2: Carmichael number 561 ====== ");
//        p = new BigInteger("561"); // Carmichael number 561, false positive
//        pMinusOne = p.subtract(BigInteger.ONE);
//        BigInteger f1 = new BigInteger("1");
//        BigInteger f2 = new BigInteger("2");
//        BigInteger f3 = new BigInteger("3");  // 561 = 3 * 187
//        BigInteger f4 = new BigInteger("4");
//        BigInteger f5 = new BigInteger("11");  // 561 = 11 * 51
//        BigInteger f6 = new BigInteger("17");  // 561 = 17 * 33
//        BigInteger f7 = new BigInteger("560");
//        System.out.println(powerMod(f1, pMinusOne, p));  // a1 = 1 is a fraud
//        System.out.println(powerMod(f2, pMinusOne, p));  // 2^(prime-1) % prime = 1.  a2 = 2 is a fraud
//        System.out.println(powerMod(f3, pMinusOne, p));  // 561 = 3 * 187. 561 is not prime
//        System.out.println(powerMod(f4, pMinusOne, p));
//        System.out.println(powerMod(f5, pMinusOne, p));  // 561 = 11 * 51. 561 is not prime
//        System.out.println(powerMod(f6, pMinusOne, p));  // 561 = 17 * 33. 561 is not prime
//        System.out.println(powerMod(f7, pMinusOne, p));


        System.out.println("====== fermat BigIntegerTest: ====== ");

        BigInteger p1 = new BigInteger("3");
        System.out.println("3 is " + fermat(p1, 2));

//        p1 = new BigInteger("4");
//        System.out.println("4 is " + fermat(p1, 8));
//        p1 = new BigInteger("17");
//        System.out.println(fermat(p1, 2));

        p1 = new BigInteger("5");
        System.out.println("5 is " + fermat(p1, 2));

        p1 = new BigInteger("6");
        System.out.println("6 is " + fermat(p1, 2));

        p1 = new BigInteger("7");
        System.out.println("7 is " + fermat(p1, 2));

        p1 = new BigInteger("11");
        System.out.println("11 is " + fermat(p1, 2));

        p1 = new BigInteger("12");
        System.out.println("12 is " + fermat(p1, 2));

        p1 = new BigInteger("13");
        System.out.println("13 is " + fermat(p1, 2));

        p1 = new BigInteger("1000");
        System.out.println("1000 is " + fermat(p1, 4));

        p1 = new BigInteger("3559");
        System.out.println("3559 is " + fermat(p1, 4));  // 3559 is prime

        p1 = new BigInteger("3571");
        System.out.println("3571 is " + fermat(p1, 4));  // 3571 is prime

        p1 = new BigInteger("6060273481239478123749812");
        System.out.println("6060273481239478123749812 is " + fermat(p1, 10));
    }
}
