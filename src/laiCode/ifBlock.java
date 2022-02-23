package laiCode;

public class ifBlock {
    public void DFS(int n, int l, int r, StringBuilder solu) {
        if (l == n && r == n) {
            System.out.println(solu);
            return;
        }
        // Case1:
        if (l < n) {
            solu.append("if {");
            DFS(n, l+1, r, solu);
            solu.deleteCharAt(solu.length() - 1);
        }
        // Case2:
        if (l > r) {
            solu.append('}');
            DFS(n, l, r+1, solu);
            solu.deleteCharAt(solu.length() - 1);
        }
    }

    public static void main(String[] args) {
        ifBlock sol = new ifBlock();
    }
}
