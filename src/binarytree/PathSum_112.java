package binarytree;

public class PathSum_112 {
    boolean result = false;
    int sum = 0;
    // 递归思路
    public boolean hasPathSum(TreeNode root, int targetSum) {
        traverse(root, targetSum);
        return result;
    }

    // 遍历二叉树
    void traverse(TreeNode root, int targetSum){
        if (root == null) return ;
        sum = sum + root.val;
        // 如果到达叶子节点，并且总和为 target 返回 true
        if (root.left == null && root.right == null && sum == targetSum){
            result = true;
            return ;
        }
        traverse(root.left, targetSum);
        traverse(root.right, targetSum);
        sum = sum - root.val;
    }

    // 分解问题思路
    // 定义：输入一个根节点，返回该根节点到叶子节点是否存在一条和为 targetSum 的路径
    public boolean hasPathSum2(TreeNode root, int targetSum){
        // base case
        if (root == null){
            return false;
        }
        if (root.left == root.right && root.val == targetSum){
            return true;
        }
        return hasPathSum2(root.left, targetSum - root.val) || hasPathSum2(root.right, targetSum - root.val);
    }
}
