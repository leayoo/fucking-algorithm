package binarytree;

public class MaximumDepthOfBinaryTree_104 {
    /*
    遍历二叉树计算答案的思路
     */
    // 记录最大深度
    int res = 0;
    // 记录遍历到的节点的深度
    int depth = 0;

    // 主函数
    public int maxDepth(TreeNode root) {
        traverse(root);
        return res;
    }

    // 二叉树遍历框架
    void traverse(TreeNode root) {
        if (root == null) {
            return;
        }
        // 前序位置
        depth++;
        // 到达叶子节点，更新最大深度
        if (root.left == null && root.right == null)
            res = Math.max(res, depth);

        traverse(root.left);
        traverse(root.right);
        // 后序位置
        depth--;
    }

    /*
    分解问题计算答案的思路
     */
    int maxDepth2(TreeNode root) {
        if (root == null) {
            return 0;
        }
        // 利用定义，计算左右子树的最大深度
        int leftMax = maxDepth2(root.left);
        int rightMax = maxDepth2(root.right);
        // 整棵树的最大深度等于左右子树的最大深度取最大值，
        // 然后再加上根节点自己
        int res = Math.max(leftMax, rightMax) + 1;
        return res;
    }
}
