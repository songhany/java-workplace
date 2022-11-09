package lai.DP;

class ArrayHopper {
  public int minJump(int[] array) {
    int[] minJump = new int[array.length];
    minJump[0] = 0;
  
    for (int i = 1; i < array.length; i++) {
      minJump[i] = -1;  // initialized as unreachable
      for (int j = i - 1; j >= 0; j--) {
        if (j + array[j] >= i && minJump[j] != -1) {
          if (minJump[i] == -1 || minJump[i] > minJump[j] + 1) {
            minJump[i] = minJump[j] + 1;
          }
        }
      }
    }	
    return minJump[array.length - 1];
  }
}
