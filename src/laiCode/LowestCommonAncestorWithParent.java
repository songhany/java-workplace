package laiCode;
/*
Clarify：
	1、TreeNode have parent
	2、node：
		① both node in one tree   ->  must find one ancestor，
		② one in, another not in  ->  return null，
		③ duplicate nodes         ->  assume no duplicate，
		④ null OR empty

	input：  TreeNode one,  TreeNode two
    output： TreeNode
* */

public class LowestCommonAncestorWithParent {
    public TreeNodeWithParent findLCA(TreeNodeWithParent one, TreeNodeWithParent two) {
        int l1 = findDepth(one);
        int l2 = findDepth(two);
        return l1 >= l2 ? merge(one, two, l1 - l2) :
                          merge(two, one, l2 - l1);
    }

    private int findDepth(TreeNodeWithParent node) {
        int depth = -1;
        while (node != null) {
            depth++;
            node = node.parent;
        }
        return depth;
    }

    private TreeNodeWithParent merge(TreeNodeWithParent longer, TreeNodeWithParent shorter, int diff) {
        while (diff > 0) {
            longer = longer.parent;
            diff--;
        }
        while (longer != shorter) {
            longer = longer.parent;
            shorter = shorter.parent;
        }
        return longer;
    }

    static class TreeNodeWithParent {
        int key;
        TreeNodeWithParent left;
        TreeNodeWithParent right;
        TreeNodeWithParent parent;

        public TreeNodeWithParent(int key, TreeNodeWithParent parent) {
            this.key = key;
            this.parent = parent;
        }
    }
}

