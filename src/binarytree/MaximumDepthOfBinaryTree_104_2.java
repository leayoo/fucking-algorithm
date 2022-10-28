package binarytree;

class MaximumDepthOfBinaryTree_104_2 {
    int result = 0, depth = 0;
    public int maxDepth(TreeNode root) {
        traverse(root);
        return result;
    }

    void traverse(TreeNode root){
        if (root == null) {
            // 到达叶子节点，更新 result
            if (depth > result) {
                result = depth;
            }
            return;
        }

        depth++;
        traverse(root.left);
        traverse(root.right);
        depth--;
    }
}
