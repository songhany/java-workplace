package laiCode;

import java.util.*;

public class Test {
  public static void main(String[] args) {
    List list = new ArrayList();
    list.add(666);
    list.add("v");
    list.add("offer");

    for (var res : list) {
      System.out.println(res);
    }
  }
}