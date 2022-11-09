package Interview;

import java.util.Scanner;

public class IsStringPalindrome {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String A = sc.next();
        /* Enter your code here. Print output to STDOUT. */
        StringBuilder sb = new StringBuilder();
        sb.append(A.toCharArray());
        String reversedString = sb.reverse().toString();
        System.out.println(A.compareTo(reversedString) == 0 ? "Yes" : "No");
    }
}