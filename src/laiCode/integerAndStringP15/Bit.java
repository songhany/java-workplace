package laiCode.integerAndStringP15;

public class Bit {  // check 'Integer' is stored in computer with two's complement
    public static void printBinary(int value) {
        System.out.println(value + " : ");
        StringBuilder builder = new StringBuilder();
        for (int shift = 31; shift >= 0; shift--) {
            builder.append((value >>> shift) & 1);
        }
        System.out.println(builder);
        System.out.println();
    }

    public static void main(String[] args) {
        // unsigned integer: 0 ~ 2^32 - 1
        int a = 0;
        printBinary(a);

        // positive number
        a = 5;
        printBinary(a);

        // negative number
        a = -5;
        printBinary(a);

        a = Integer.MIN_VALUE;  // -2^31 = -2147483648
        printBinary(a);

        a = Integer.MAX_VALUE;     // 2^31 - 1 = 2147483647
        printBinary(a);

        // Integer Overflow/Underflow
        // Integer.MAX_VALUE + 1 = Integer.MIN_VALUE
        // Integer.MIN_VALUE - 1 = Integer.MAX_VALUE
        a = Integer.MAX_VALUE + 1;  // Integer.MAX_VALUE + 1 = Integer.MIN_VALUE
        printBinary(a);

        a = Integer.MIN_VALUE - 1;  // Integer.MIN_VALUE - 1 = Integer.MAX_VALUE
        printBinary(a);


        // all "1"
        a = -1;
        printBinary(a);  // 11111111111111111111111111111111

        // Signed Shift - leftmost bit depends on previous leftmost bit
        int b = a >> 5;
        printBinary(b);

        // Unsigned Shift - leftmost bit "0"
        b = a >>> 5;
        printBinary(b);
    }
}
