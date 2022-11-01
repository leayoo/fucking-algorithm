package binarytree;

public class DiameterOfBinaryTree_543_2 {
    // 思路：二叉树的直径就相当于左右子树的最大深度之和
    // 所以，直接的想法就是对每个节点计算左右子树的最大深度，得出每个节点的直径，从而求最大的。
    int maxDiameter = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        maxDepth(root);
        return maxDiameter;
    }

    int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftMax = maxDepth(root.left);
        int rightMax = maxDepth(root.right);
        // 后序遍历位置顺便计算最大直径
        // 更新最大直径，所以注意是 max(maxDiameter, leftMax + rightMax)，是将左右子树最大深度相加
        maxDiameter = Math.max(maxDiameter, leftMax + rightMax);
        // 返回的是 最大深度，所以注意是 max(leftMax, rightMax)，是将左右子树最大深度相互比较
        return 1 + Math.max(leftMax, rightMax);
    }
}
