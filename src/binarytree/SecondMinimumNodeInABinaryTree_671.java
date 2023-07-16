package binarytree;

public class SecondMinimumNodeInABinaryTree_671 {
    // 定义：输入一颗二叉树，返回这颗二叉树中第二小的节点值
    public int findSecondMinimumValue(TreeNode root) {
        // 叶子节点
        if (root.left == null && root.right == null) {
            return -1;
        }
        // 左右节点中不同于 root.val 的那个值可能是第二小的值
        int left = root.left.val;
        int right = root.right.val;
        // 如果左右子节点都等于 root.val，则去左右子树递归寻找第二小的值
        if (root.val == root.left.val) {
            left = findSecondMinimumValue(root.left);
        }
        if (root.val == root.right.val) {
            right = findSecondMinimumValue(root.right);
        }
        if (left == -1) {
            return right;
        }
        if (right == -1) {
            return left;
        }
        // 如果左右子树都找到一个第二小的值，更小的那个是整棵树的第二小元素
        return Math.min(left, right);

    }
}
