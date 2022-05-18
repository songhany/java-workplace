package other.CS593;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;


public class LongestCommonSubsequence {
    public static int longest(String s,  String t)  {
        int[][] longest  =  new int[s.length() + 1][ t.length() + 1];

        for (int i = 1;  i <= s.length();  i++)  {
            for (int  j = 1;  j <= t.length();  j++)  {
                if  ( s.charAt(i - 1)  ==  t.charAt(j - 1) )  {
                    longest[i][j]  =  longest[i - 1][j-1] + 1;
                } else  {
                    longest[i][j]  =  Math.max(longest[i - 1][j], longest[i][j - 1]);
                }
            }
        }
        return  longest[s.length()][t.length()];
    }

    public static String loadFile(String name) throws FileNotFoundException {
        Scanner s = new Scanner(new FileReader(name));
        return s.nextLine();
    }

    public static void main(String[] args) throws FileNotFoundException {
        String a = loadFile(args[0]);
        String b = loadFile(args[1]);
        System.out.println("length of Longest Common Subsequence: " + longest(a, b));
    }
}
