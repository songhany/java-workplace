package laiBasic;

public class Midterm {
    public static void main(String[] args) {
        int a=2, b=4, c=8;
        double r0 = (double) (a + b /c);
        System.out.println(r0);   // 2.0

        double r1 = a + (double)( b / c );
        System.out.println(r1);  // 2.0

        double r2 = a + ((double)b) / c ;
        System.out.println("4.0 / 8 = " + 4.0 / 8);  //❤ 0.5
        System.out.println(r2);  // 2.5

        double r3 = a + 1.0 * b / c ;
        System.out.println(r3);  // 2.5
    }
}
