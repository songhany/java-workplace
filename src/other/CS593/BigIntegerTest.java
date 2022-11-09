package other.CS593;

import java.math.BigInteger;

public class BigIntegerTest {  // https://www.jianshu.com/p/734eca571be6
    public static void main(String[] args) {
        BigInteger big= new BigInteger("148"); //这次我们直接给个148

        boolean bigBool_1 = big.testBit(1); //判断148中是否存在2的2次幂
        System.out.println(bigBool_1);  //false
        bigBool_1 = big.testBit(3); //判断148中是否存在2的3次幂
        System.out.println(bigBool_1);  //false
        bigBool_1 = big.testBit(5); //判断148中是否存在2的5次幂
        System.out.println(bigBool_1);  //false
        bigBool_1 = big.testBit(6); //判断148中是否存在2的6次幂
        System.out.println(bigBool_1);  //false
        bigBool_1 = big.testBit(8); //判断148中是否存在2的9幂
        System.out.println(bigBool_1);  //false
        bigBool_1 = big.testBit(9); //判断148中是否存在2的9次幂
        System.out.println(bigBool_1);  //false

        System.out.println("==============");
        // 148 的二进制表示为 “10010100”， 对应 2 4 7 位分别为1
        bigBool_1 = big.testBit(2); //判断148中是否存在2的2次幂
        boolean bigBool_2 = big.testBit(4); //判断148中是否存在2的4次幂
        boolean bigBool_3 = big.testBit(7); //判断148中是否存在2的7次幂

        System.out.println(bigBool_1);  //true
        System.out.println(bigBool_2); //true
        System.out.println(bigBool_3); //true
    }
}
