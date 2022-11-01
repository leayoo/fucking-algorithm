package binarytree;

public class SumOfLeftLeaves_404 {
    int sum = 0;
    public int sumOfLeftLeaves(TreeNode root) {
        traverse(root);
        return sum;
    }

    // 遍历
    void traverse(TreeNode root){
        if (root == null){
            return;
        }

        // 找到左侧的叶子节点，记录累加值
        if (root.left !=null && root.left.left == null && root.left.right == null){
            sum += root.left.val;
        }

        traverse(root.left);
        traverse(root.right);
    }
}
