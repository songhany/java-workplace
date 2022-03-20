package laiBasic;

public class ShortCircuit {
    public static void main(String[] args) {
        int i = (int)'0';
        System.out.println(i);

        if (g() & f()) {
            System.out.println("1");
        } else {
            System.out.println("2");
        }
    }

    public static boolean f() {
        return true;
    }

    public static boolean g() {
        return false;
    }
}
