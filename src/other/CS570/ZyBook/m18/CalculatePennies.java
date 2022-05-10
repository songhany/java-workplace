package other.CS570.ZyBook.m18;

import java.util.Scanner;

public class CalculatePennies {

  public static long doublePennies(long numPennies, int numDays) {    // Returns number of pennies if pennies are doubled numDays times
    long totalPennies;

    /* Your solution goes here  */
    if (numDays == 0) {
      return numPennies;
    }

    return doublePennies((numPennies * 2), numDays - 1);
  }

  // Program computes pennies if you have 1 penny today,
// 2 pennies after one day, 4 after two days, and so on
  public static void main (String [] args) {
    Scanner scnr = new Scanner(System.in);
    long startingPennies;
    int userDays;

    startingPennies = scnr.nextLong();
    userDays = scnr.nextInt();
    System.out.println("Number of pennies after " + userDays + " days: " + doublePennies(startingPennies, userDays));
  }
}
