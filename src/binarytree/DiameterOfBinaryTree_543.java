package binarytree;

public class DiameterOfBinaryTree_543 {
    // 记录最大直径的长度
    int maxDiameter = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        // 对每个结点计算直径，求最大直径
        traverse(root);
        return maxDiameter;
    }

    // 遍历二叉树
    void traverse(TreeNode root) {
        if (root == null)
            return;
        // 对每个节点计算直径
        int leftMax = maxDepth(root.left);
        int rightMax = maxDepth(root.right);
        int myDiameter = leftMax + rightMax;
        // 更新全局最大直径
        maxDiameter = Math.max(maxDiameter, myDiameter);

        traverse(root.left);
        traverse(root.right);
    }

    // 计算二叉树的最大深度
    int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftMax = maxDepth(root.left);
        int rightMax = maxDepth(root.right);
        return Math.max(leftMax, rightMax) + 1;
    }

    /*
    凡把计算「直径」的逻辑放在后序位置，
    准确说应该是放在 maxDepth 的后序位置
     */
    int maxDiameter2 = 0;

    public int diameterOfBinaryTree2(TreeNode root) {
        maxDepth2(root);
        return maxDiameter2;
    }

    int maxDepth2(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftMax = maxDepth2(root.left);
        int rightMax = maxDepth2(root.right);
        // 后序位置，顺便计算最大直径
        int myDiameter = leftMax + rightMax;
        maxDiameter2 = Math.max(maxDiameter2, myDiameter);

        // 返回最大深度
        return 1 + Math.max(leftMax, rightMax);
    }

}
