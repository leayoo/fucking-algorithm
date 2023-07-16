package bst;

public class BinarySearchTreeToGreaterSumTree_1038 {
    TreeNode convertBST(TreeNode root){
        traverse(root);
        return root;
    }
    // 记录累加和
    int sum = 0;
    void traverse(TreeNode root){
        if (root == null){
            return;
        }
        traverse(root.right);
        // 维护累加和
        sum += root.val;
        // 将 BST 转化成累加树
        root.val = sum;
        traverse(root.left);
    }
}
