package lai.CrossTraning3;

import java.util.*;

public class LargestRectangleInHistogram {
  public static void main(String[] args) {
    System.out.println(largest(new int[]{2, 1, 1, 3, 3, 4}));
  }

  public static int largest(int[] array) {
    int result = 0;
    Deque<Integer> stack = new LinkedList<Integer>();
    for (int i = 0; i <= array.length; i++) {
      int cur = i == array.length ? 0 : array[i];
      while (!stack.isEmpty() && array[stack.peekFirst()] >= cur) {
        int height = array[stack.pollFirst()];
        int left = stack.isEmpty() ? 0 : stack.peekFirst() + 1;
        result = Math.max(result, height * (i - left));
      }
      stack.offerFirst(i);
    }
    return result;
  }
}
