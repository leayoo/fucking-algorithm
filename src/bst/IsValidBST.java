package bst;

/**
 * @author: Leeyoa
 * @description:
 * @date: 2023/7/19 12:08
 */
public class IsValidBST {

    // 经典错误
    boolean isValidBST1(TreeNode root){
        if (root == null) return true;
        if (root.left != null && root.left.val >= root.val)
            return false;
        if (root.right != null && root.right.val <= root.val)
            return false;
        return isValidBST1(root.left) && isValidBST1(root.right);
    }

    boolean isValidBST(TreeNode root){
        return isValidBST(root, null, null);
    }

    boolean isValidBST(TreeNode root, TreeNode min, TreeNode max){
        if (root == null) return true;
        if (min != null && min.val >= root.val)
            return false;
        if (max != null && max.val <= root.val)
            return false;
        return isValidBST(root.left, min, root) && isValidBST(root.right, root, max);
    }
}
