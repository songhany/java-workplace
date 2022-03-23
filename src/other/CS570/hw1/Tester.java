package other.CS570.hw1;

public class Tester {
    public static void main(String[] args) {
        BinaryNumber b1 = new BinaryNumber("10110");
        BinaryNumber b2 = new BinaryNumber("11100");
        BinaryNumber b3 = new BinaryNumber("11101");
        BinaryNumber b4 = new BinaryNumber("10110");
        BinaryNumber b5 = new BinaryNumber(5);

        System.out.println(b1.toString());
        System.out.println(b1.getLength());
        System.out.println(b1.toDecimal());

        System.out.println(b2.toString());
        System.out.println(b2.getLength());
        System.out.println(b2.toDecimal());

        System.out.println(b3.toString());
        System.out.println(b3.getLength());
        System.out.println(b3.toDecimal());

        System.out.println(b1.getDigit(0));
        System.out.println(b1.getDigit(1));
        System.out.println(b1.getDigit(2));
        System.out.println(b1.getDigit(3));
        System.out.println(b1.getDigit(4));
        System.out.println(b1.getDigit(5));
        System.out.println(b1.getDigit(6));

        b1.shiftR(3);
        System.out.println(b1.toString());

        b1.add(b2);
        System.out.println(b1);

        b4.add(b2);
        System.out.println(b4);  // 00101

        b4.add(b3);
        System.out.println(b4);  // 001001

        //System.out.println(b5.toString());
    }
}
