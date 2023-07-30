package binarytree;

/**
 * @author: Leeyoa
 * @description:
 * @date: 2023/7/19 11:56
 */
public class IsSameTree {
    boolean isSameTree(TreeNode root1, TreeNode root2) {
        // base case
        if (root1 == null && root2 == null) return true;
        if (root1 == null || root2 == null) return false;
        if (root1.val != root2.val) return false;

        return
                isSameTree(root1.left, root2.left) &&
                        isSameTree(root1.right, root2.right);
    }
}
