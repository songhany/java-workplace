package CPE593;

/*
    HW1: Fermat with Infinite Precision Arithmetic
    Author: Songhan Yu
    Cite: https://www.titanwolf.org/Network/q/78ac6100-f596-4199-b1c3-9c3b6387f961/y
 */

/*
Fermet Little Theorem:
If 'p' is prime, then for all integers 'a' such that 2 <= a <= p-1, a**(p-1) % p = 1.
Idea is to chose a random 'a' from the above mentioned range, and return True if remainder is 1 for each time.
This is a probabilistic method: It returns true for all primes, it may return true for composites (non-primes).
*/
import java.util.*;
import java.math.BigInteger;

public class Fermet {
    private static Random random = new Random();

    public static String powerMod(BigInteger base, BigInteger exp, BigInteger mod) {  // http://www.java2s.com/example/java-utility-method/number-power/powermod-long-base-long-exp-long-mod-fd072.html
        BigInteger prod = BigInteger.ONE;
        while (!exp.equals(BigInteger.ZERO)) {
            if (exp.testBit(0)) {
                prod = prod.multiply(base).mod(mod);
            }
            // for x^n
            base = base.multiply(base).mod(mod);  // x = x^x % mod
            exp = exp.divide(BigInteger.TWO);     // n = n/2
        }
        return prod.equals(BigInteger.ONE) ? "PRIME" : "NOT PRIME";
    }

    public static String fermatTest(BigInteger prime, int k) {
        BigInteger pMinusOne = prime.subtract(BigInteger.ONE);  // calculate exponent p-1
        for (int i = 0; i < k; ++i) {
            BigInteger a;
            do {
                a = new BigInteger(prime.bitCount(), random);
            } while (a.compareTo(prime) >= 0 || a.compareTo(BigInteger.ONE) <= 0);
//            System.out.println(a);
            // invariant: 1 < a < prime
            //			if (a.modPow(pMinusOne), prime).compareTo(BigInteger.ONE) != 1)
            if (a.modPow(pMinusOne, prime).compareTo(a) != 0)
                return "NOT PRIME";
        }
        return "PRIME";
    }

    public static void main(String[]args) {
        System.out.println("====== powerMod test case1: prime 5 ====== ");
        BigInteger a1 = new BigInteger("1");
        BigInteger a2 = new BigInteger("2");
        BigInteger a3 = new BigInteger("3");
        BigInteger a4 = new BigInteger("4");
        BigInteger p = new BigInteger("5");  // 5 is prime
        BigInteger pMinusOne = p.subtract(BigInteger.ONE);
        System.out.println(powerMod(a1, pMinusOne, p));  // 1^(prime-1) % prime = 1.  a1 = 1 is a witnesses
        System.out.println(powerMod(a2, pMinusOne, p));  // 2^(prime-1) % prime = 1.  a2 = 2 is a witnesses
        System.out.println(powerMod(a3, pMinusOne, p));  // 3^(prime-1) % prime = 1.  a3 = 3 is a witnesses
        System.out.println(powerMod(a4, pMinusOne, p));  // 4^(prime-1) % prime = 1.  a4 = 4 is a witnesses


        System.out.println("====== powerMod test case2: Carmichael number 561 ====== ");

        p = new BigInteger("561"); // Carmichael number 561, false positive
        pMinusOne = p.subtract(BigInteger.ONE);
        BigInteger f1 = new BigInteger("1");
        BigInteger f2 = new BigInteger("2");
        BigInteger f3 = new BigInteger("3");  // 561 = 3 * 187
        BigInteger f4 = new BigInteger("4");
        BigInteger f5 = new BigInteger("11");  // 561 = 11 * 51
        BigInteger f6 = new BigInteger("560");
        System.out.println(powerMod(f1, pMinusOne, p));  // a1 = 1 is a fraud
        System.out.println(powerMod(f2, pMinusOne, p));  // 2^(prime-1) % prime = 1.  a2 = 2 is a fraud
        System.out.println(powerMod(f3, pMinusOne, p));  // 561 = 3 * 187. 561 is not prime
        System.out.println(powerMod(f4, pMinusOne, p));
        System.out.println(powerMod(f5, pMinusOne, p));  // 561 = 11 * 51. 561 is not prime
        System.out.println(powerMod(f6, pMinusOne, p));


        System.out.println("====== fermatTest test1:  ====== ");
        BigInteger p1 = new BigInteger("5");
        System.out.println(fermatTest(p1, 2));

        System.out.println("====== fermatTest test2:  ====== ");
        p1 = new BigInteger("6");
        System.out.println(fermatTest(p1, 2));
//        p1 = new BigInteger("17");
//        System.out.println(fermatTest(p1, 2));

        System.out.println("====== fermatTest test3:  ====== ");
        p1 = new BigInteger("42");
        System.out.println(fermatTest(p1, 2));

        System.out.println("====== fermatTest test4:  ====== ");
        p1 = new BigInteger("11");
        System.out.println(fermatTest(p1, 8));

        System.out.println("====== fermatTest test5:  ====== ");
        p1 = new BigInteger("609778173989967850000000000023");
        System.out.println(fermatTest(p1, 8));
    }
}
