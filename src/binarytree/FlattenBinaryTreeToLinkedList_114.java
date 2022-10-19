package binarytree;

public class FlattenBinaryTreeToLinkedList_114 {
    // 定义：输入节点 root，然后 root 为根的二叉树就会被拉平为一条链表
    public void flatten(TreeNode root) {
        // base case
        if (root == null) return;

        // 利用定义，把左右子树拉平
        flatten(root.left);
        flatten(root.right);

        // 1. 左右子树已经被拉成一条链表
        TreeNode left = root.left;
        TreeNode right = root.right;

        // 2. 将左子树作为右子树
        root.left = null;
        root.right = left;

        // 3. 将原先的右子树连接到当前右子树的末端
        TreeNode p = root;
        // p 指向当前右子树的末端
        while (p.right != null) {
            p = p.right;
        }
        // 将右子树连接到末端
        p.right = right;
    }
}
