package laiCode.dfs;

// Time Complexity：O(2^(2n) * n^2)   For the dfs recurison,  time complexity is O(2^(2n)), for each combination print, the print method takes O(n^2)
// Space Complexity：O(2n)    2n is the height of the recursion tree
public class ValidIfBlock {
    public void printValidBlocks(int n) {
        if (n <= 0) {
            return;
        }
        char[] cur = new char[2 * n];
        dfs(cur, n, n, 0);
    }

    private void dfs(char[] cur, int left, int right, int index) {
        if (left == 0 && right == 0) {
            printBlock(cur);
            return;
        }
        if (left > 0) {
            cur[index] = '{';
            dfs(cur, left - 1, right, index + 1);
        }
        if (right > left) {
            cur[index] = '}';
            dfs(cur, left, right - 1, index + 1);
        }
    }

    private void printBlock(char[] cur) {
        int space = 0;
        for (int i = 0; i < cur.length; i++) {
            if (cur[i] == '{') {
                printIndent(space);
                System.out.println("if {");
                space += 2;
            } else {
                space -= 2;
                printIndent(space);
                System.out.println("}");
            }
        }
        System.out.println();
    }

    private void printIndent(int space) {
        for (int i = 0; i < space; i++) {
            System.out.print(' ');
        }
    }

    public static void main(String[] args) {
        ValidIfBlock sol = new ValidIfBlock();
        sol.printValidBlocks(3);
    }
}
