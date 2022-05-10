package other.CS570.hw2;
/*
 * other.CS570 Homework 2
 *
 * author: Songhan Yu
 * CWID: 10470449
 */
import java.lang.Math;

public class Complexity {

  // O(n)
  public static void method0(int n) {
    int counter = 0;
    for (int i=0; i<n; i++) {
      System.out.println("Opertaion" + counter);
      counter ++;
    }
  }

  // O(n^2)
  public static void method1(int n) {
    int counter = 0;
    for (int i=0; i<n; i++) {
      for (int j=0; j<n; j++) {
        System.out.println("Opertaion" + counter);
        counter ++;
      }
    }
  }

  // O(n^3)
  public static void method2(int n) {
    int counter = 0;
    for (int i=0; i<n; i++) {
      for (int j=0; j<n; j++) {
        for (int k=0; k<n; k++) {
          System.out.println("Opertaion" + counter);
          counter ++;
        }
      }
    }
  }

  // O(logn)
  public static void method3(int n) {
    int counter=0;
    for (int i=n; i > 0; i=i/2) {
      System.out.println("Opertaion" + counter);
      counter ++;
    }
  }

  // O(nlogn)
  public static void method4(int n) {
    int counter = 0;
    for (int i=0; i < n; i++) {
      for (int j=n; j > 0; j = j/2) {
        System.out.println("Opertaion" + counter);
        counter ++;
      }
    }
  }

  // O(loglogn)
  public static void method5(int n) {
    int counter=0;

    for (int i= n; i > 1; i = (int)Math.floor(Math.sqrt(i))) {
      //System.out.println(i);
      System.out.println("Opertaion" + counter);
      counter ++;
    }
  }

  // O(2^n)
  public static int method6(int n) {
    if (n <= 1) return n;
    return method6(n - 2) + method6(n - 1);
  }


  public static void main(String[] args) {
    // method3(16);
    // method5(16);
    // method6(4);
  }
}