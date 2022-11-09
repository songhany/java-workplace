package lai.DP;

public class EditDistance {
  public int editDistanceDP(String one, String two) {
    int[][] distance = new int[one.length() + 1][two.length() + 1];
    for (int i = 0; i <= one.length(); i++) {
      for (int j = 0; j <= two.length(); j++) {
        if (i == 0) {
          distance[i][j] = j;
        } else if (j == 0) {
          distance[i][j] = i;
        } else if (one.charAt(i - 1) == two.charAt(j - 1)) {
          distance[i][j] = distance[i - 1][j - 1];
        } else {
          distance[i][j] = Math.min(Math.min(distance[i-1][j] + 1, distance[i][j-1] + 1), distance[i-1][j-1] + 1);
        }
      }
    }
    return distance[one.length()][two.length()];
  }

  public int editDistance(String word1, String word2) {
    if (word1.isEmpty()) return word2.length();
    if (word2.isEmpty()) return word1.length();
  
    int doNothing = Integer.MAX_VALUE;
    if (word1.charAt(0) == word2.charAt(0)) {
        doNothing = editDistance(word1.substring(1), word2.substring(1));
    }
  
    int replace = 1 + editDistance(word1.substring(1), word2.substring(1));
    int delete = 1 + editDistance(word1.substring(1), word2);
    int insert = 1 + editDistance(word1, word2.substring(1));
    return Math.min(doNothing, Math.min(Math.min(replace, delete), insert));
  }

  public static void main(String[] args) {
    EditDistance sol = new EditDistance();
    int minNumberOfOperation = sol.editDistanceDP("asbf", "sghj");
    System.out.println(minNumberOfOperation);

    minNumberOfOperation = sol.editDistanceDP("dinitrophenylhydrazine", "acetylphenylhydrazine");
    System.out.println(minNumberOfOperation);

    // minNumberOfOperation = sol.editDistance("dinitrophenylhydrazine", "acetylphenylhydrazine");  // Status: Time Limit Exceeded	
    // System.out.println(minNumberOfOperation);
  }
}
