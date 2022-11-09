package Tree;

import java.util.ArrayList;
import java.util.List;

public class GetRange {
    public List<Integer> getRange(TreeNode root, int min, int max) {
        List<Integer> list = new ArrayList<>();
        getRange(root, min, max, list);
        return list;
    }

    private void getRange(TreeNode root, int min, int max, List<Integer> list) {
        if (root == null) {
            return;
        }

        // 1. determine if left subtree should be traversed,
        // only when root.val > min. we should traverse the left subtree.
        if (root.val > min) {
            getRange(root.left, min, max, list);
        }

        // 2. determine if root should be traversed.
        if (min <= root.val && root.val <= max) {
            list.add(root.val);
        }

        // 3. determine if right subtree should be traversed,
        // only when root.val < max, we should traverse the right subtree.
        if (root.val < max) {
            getRange(root.right, min, max, list);
        }
    }


    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }
}
