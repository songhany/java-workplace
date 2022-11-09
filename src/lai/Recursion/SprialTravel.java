package lai.Recursion;

public class SprialTravel {
  public static void main(String[] args) {
    SprialTravel sol = new SprialTravel();
    int size = 5;
    sol.sprialPrint(new int[size][size], 0, size, 1);
  }

  void sprialPrint(int[][] a, int offset, int size, int counter) {
    if (size <= 1) {
      if (size == 1) {
        a[offset][offset] = counter;
      }

      for (int i = 0; i < a.length; i++) {
        for (int j = 0; j < a[0].length; j++) {
          System.out.println(a[i][j]);
        }
      }
      return;
    }
  
    for (int i = 0; i < size - 1; i++) {  // upper row
      a[offset][i + offset] = counter++;
    }
    for (int i = 0; i < size - 1; i++) {  // right column
      a[i + offset][size - 1 + offset] = counter++;
    }
    for (int i = size - 1; i >= 1; i--) {  // down row
      a[size - 1 + offset][i + offset] = counter++;
    }
    for (int i = size - 1; i >= 1; i--) {  // left column
      a[i + offset][offset] = counter++;
    }
    sprialPrint(a, offset+1, size-2, counter);
  }

}
