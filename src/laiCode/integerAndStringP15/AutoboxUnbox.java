package laiCode.integerAndStringP15;

public class AutoboxUnbox {
    public static void main(String[] args) {
        Integer a = 5;  // autoboxing
        int b = 5;      // primitive
        System.out.println(a > b);      // false, unboxing -> a.intValue() > b
        System.out.println(a + 2);      // 7
        System.out.println(a * 3);      // 15
        System.out.println(a == b);     // true, unboxing

        Integer c = 5;
        System.out.println(a > c);      // false,  a.intValue() > c.intValue()
        System.out.println(a >= c);     // true,   a.intValue() >= c.intValue()
        System.out.println(a == c);     // true,  "Intern pool" -128 ~ 127

        a = 128;
        c = 128;
        System.out.println(a > c);      // false
        System.out.println(a >= c);     // true
        System.out.println(a == c);     // false. not in the range of intern pool

        // 只有 compile time 就决定的东西才会指向 Intern pool
        // 如果 runtime 才 new 出来的东西，不可能在 intern pool
        String s1 = "abc";
        String s2 = "abc";
        System.out.println(s1 == s2);   // true, "Intern pool"

        s2 = new String("abc");     // Runtime build, it isn't in Intern pool
        System.out.println(s1 == s2);       // false
        System.out.println(s1.equals(s2));  // true

        String sa = "a";
        String sb = "b";
        String sab = "a" + "b";     // Compile time concat. String sab = "ab".  It is in "Intern pooL'

        System.out.println(sab == "a" + "b");   // true
        System.out.println(sab == sa + b);      // false, sa.concat("b") in Runtime. Since "sa" is variable, variable can change, but compiler don't have context, so compiler don't know what value "sa" is
        System.out.println(sab == sa + sb);     // false, sa.concat(sb) in Runtime.
    }
}
