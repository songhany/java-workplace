package other.CS570.hw1;
/*
 * other.CS570 Homework 1
 *
 * author: Songhan Yu
 * CWID: 10470449
 */
import java.util.*;

public class BinaryNumber {
    private int data[];
    private boolean overflow = false;

    // 2.1 Basic operations
    public BinaryNumber(int length) {
        data = new int[length];
        for (int i=0; i<length; i++) {
            data[i] = 0;
        }
    }

    public BinaryNumber(String str) {  //creating a binary number given a string
        data = new int[str.length()];
        for (int i=0; i<str.length(); i++) {
            data[i] = Character.getNumericValue(str.charAt(i));
        }
    }

    public int getLength() {  // determining the length of a binary number.
        return data.length;
    }

    public int getDigit(int index) {  // obtaining a digit of a binary number given an index
        if (index > data.length - 1) {
            System.out.println("Index is out of bounds");
            return -1;
        }
        return data[index];
    }

    public int toDecimal() {
        // little-endian format
        int decimal = 0;
        for (int i=0; i<data.length; i++) {
            decimal = (int) (decimal + data[i] * Math.pow(2, i));
        }
        return decimal;
    }

    private int[] reallocate(int[] original, int newlength) {
        int [] newData = Arrays.copyOf(original, newlength);
        for (int i= (newlength-original.length), j=0; j< original.length; i++, j++) {
            newData[i] = newData[j];
        }
        for (int j=0; j< (newlength-original.length); j++) {
            newData[j] = 0;
        }
        return newData;
    }

    public void shiftR(int amount) {
        int newlength = data.length + amount;
        data = reallocate(data, newlength);
    }

    // 2.2 Addition of Binary Numbers
    public void add(BinaryNumber aBinaryNumber) {
        if (data.length != aBinaryNumber.getLength()) {
            System.out.println("The length of two binary number is not the same.");
        } else {
            int value;
            for (int i=0; i<data.length; i++) {
                if (overflow) {  // 10110  11101
                    value = data[i] + aBinaryNumber.data[i] + 1;
                } else {
                    value = data[i] + aBinaryNumber.data[i];
                }

                // initialize overflow to false after every addition
                clearOverflow();

                //
                if (value > 1) {
                    overflow = true;
                    if (value == 3) {
                        data[i] = 1;
                    } else if (value == 2) {
                        data[i] = 0;
                    }
                } else if (value == 1) {
                    data[i] = 1;
                }
                if (i == data.length - 1) {
                    if (overflow) {
                        data = Arrays.copyOf(data, data.length + 1);
                        data[data.length-1] = 1;
                        break;
                    }
                }
            }
        }
    }

    public void clearOverflow() {
        this.overflow = false;
    }

    public String toString() {
        String retStr = "";
        for (int i=0; i<data.length; i++) {
            retStr += Integer.toString(data[i]);
        }
        return retStr;
    }

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




