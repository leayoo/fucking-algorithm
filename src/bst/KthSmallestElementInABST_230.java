package bst;

public class KthSmallestElementInABST_230 {
    public int kthSmallest(TreeNode root, int k) {
        // 利用 BST 的中序遍历特性
        traverse(root, k);
        return res;
    }
    // 记录结果
    int res = 0;
    // 记录当前元素的排名
    int rank = 0;
    void traverse(TreeNode root, int k){
        if (root == null){
            return ;
        }
        traverse(root.left, k);
        rank++;
        if (rank == k){
            res = root.val;
            return ;
        }
        traverse(root.right, k);
    }
}
