package laiCode.tree;

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
        // only when root.key > min. we should traverse the left subtree.
        if (root.key > min) {
            getRange(root.left, min, max, list);
        }

        // 2. determine if root should be traversed.
        if (min <= root.key && root.key <= max) {
            list.add(root.key);
        }

        // 3. determine if right subtree should be traversed,
        // only when root.key < max, we should traverse the right subtree.
        if (root.key < max) {
            getRange(root.right, min, max, list);
        }
    }
}
