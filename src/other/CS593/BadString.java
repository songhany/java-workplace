package other.CS593;

public class BadString {
    public static void main(String[] args) {
        double start, end;

        // Time: 1 + 2 + 3 + ... + N = N(N+1)/2  ->   O(N^2)
        start = System.currentTimeMillis();
        String s = "";
        for (int i = 0; i < 100000; i++) {
            s = s + i;  // "0" + "1" + "01"  "012"  ... "01234567890"
        }
        end = System.currentTimeMillis();
        System.out.println("Using + took " + (end - start) + " milliseconds");


        // StringBuilder
        start = System.currentTimeMillis();
        StringBuilder sb = new StringBuilder(1000);
        for (int i = 0; i < 100000; i++) {
            sb.append(i);
        }
        end = System.currentTimeMillis();
        System.out.println("StringBuilder took " + (end - start) + " milliseconds");
    }
}
