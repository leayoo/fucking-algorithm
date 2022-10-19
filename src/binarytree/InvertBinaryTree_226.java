package binarytree;

public class InvertBinaryTree_226 {
    // 遍历的思维
    public TreeNode invertTree(TreeNode root) {
        // 遍历二叉树，交换每个节点的子节点
        traverse(root);
        return root;
    }
    // 二叉树遍历函数
    void traverse(TreeNode root){
        if (root == null){
            return;
        }

        // 每个节点需要做的事就是交换它的左右子节点
        TreeNode tmp = root.left;
        root.left = root.right;
        root.right = tmp;

        //遍历框架，去便利左右子树的节点
        traverse(root.left);
        traverse(root.right);
    }

    // 分解问题的思维
    // 定义：将以 root 为根的这棵二叉树翻转，返回翻转后的二叉树根节点
    TreeNode invertTree2(TreeNode root){
        if (root == null){
            return null;
        }

        // 利用函数定义，先翻转左右子树
        TreeNode left = invertTree2(root.left);
        TreeNode right = invertTree2(root.right);

        // 交换左右子节点
        root.left = right;
        root.right = left;

        return root;
    }
}
