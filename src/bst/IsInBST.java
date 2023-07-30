package bst;

/**
 * @author: Leeyoa
 * @description:
 * @date: 2023/7/19 12:17
 */
public class IsInBST {

    // 最简单的思路
    boolean isInBST1(TreeNode root, int target){
        if (root == null) return false;
        if (root.val == target) return true;
        return isInBST1(root.left, target)
                || isInBST1(root.right, target);
    }

    // 改造一下，其实不用两棵树都搜索
    boolean isInBST(TreeNode root, int target){
        if (root == null) return false;
        if (root.val > target){
            isInBST(root.left, target);
        } else if (root.val < target){
            isInBST(root.right, target);
        } else if (root.val == target)
            return true;
        return false;
    }
}
