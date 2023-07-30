package binarytree;

/**
 * @author: Leeyoa
 * @description:
 * @date: 2023/7/19 11:53
 */

// 如何把二叉树所有的节点中的值加一？
public class plusOne {
    void plusOne(TreeNode root){
        if (root == null) return;
        root.val += 1;

        plusOne(root.left);
        plusOne(root.right);
    }
}
