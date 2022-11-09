package laiCode;

import java.util.*;

public class SpiralTraverse {
  public List<Integer> sprial(int[][] matrix) {
    List<Integer> list = new ArrayList<Integer>();
    recursiveTraverse(matrix, 0, matrix.length, list);
    return list;
  }
  
  private void recursiveTraverse(int[][] matrix, int offset, int size, List<Integer> result) {
    if (size == 0) {
      return;
    }
    if (size == 1) {
      result.add(matrix[offset][offset]);
      return;
    }
    for (int i = 0; i < size - 1; i++)
      result.add(matrix[offset][offset + i]);
    for (int i = 0; i < size - 1; i++)
      result.add(matrix[offset + i][offset + size - 1]);
    for (int i = size - 1; i >= 1; i--) 
      result.add(matrix[offset + size - 1][offset + i]);
    for (int i = size - 1; i >= 1; i--)
      result.add(matrix[offset + i][offset]);
    recursiveTraverse(matrix, offset + 1, size - 2, result);
  }

  public static void main(String[] args) {
    SpiralTraverse solution = new SpiralTraverse();
    System.out.println(solution.sprial(new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}}));
  }
}
