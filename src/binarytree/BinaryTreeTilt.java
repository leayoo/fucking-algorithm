package binarytree;


public class BinaryTreeTilt {
    // 后续位置的妙用
    // sum 函数记录二叉树的节点和，在后续位置顺便计算二叉树的「坡度」
    int res = 0;

    public int findTilt(TreeNode root) {
        sum(root);
        return res;
    }

    // 定义：输入一棵二叉树，返回这棵二叉树所有元素的和
    int sum(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int leftSum = sum(root.left);
        int rightSum = sum(root.right);
        // 后续位置
        res += Math.abs(leftSum - rightSum);
        return leftSum + rightSum + root.val;
    }

}
