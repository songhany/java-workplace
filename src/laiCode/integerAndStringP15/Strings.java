package laiCode.integerAndStringP15;

public class Strings {
    public static void main(String[] args) {
        int i = 0;

        // primitive type:
        String si = i + "";      // "0"
        si = String.valueOf(i);  // "0"
        si = Integer.toString(i);  // "0"

        // wrapper class:
        Integer integer = null;
//        si = integer.toString();  // be careful for null, could cause NullPointException
        si = String.valueOf(integer);  // null. If integer is null, si = "null"


        si = "11";
        Integer.valueOf(si);    // return Integer

        Integer.parseInt(si);   // return int
    }
}
