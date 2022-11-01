package binarytree;

public class ConstructStringFromBinaryTree_606 {
    // 定义：输入以 root 的二叉树，返回描述该二叉树的字符串
    public String tree2str(TreeNode root) {
        // base case
        if (root == null) return "";
        if (root.left == null && root.right == null) {
            return root.val + "";
        }
        // 递归生成左右子树的字符串
        String leftStr = tree2str(root.left);
        String rightStr = tree2str(root.right);

        // 后序遍历代码位置
        // 根据左右子树字符串组装出前序遍历的顺序
        // 按照题目要求处理 root 只要有一边有子树的情况
        if (root.left != null && root.right == null) {
            // 省略空的右子树
            return root.val + "(" + leftStr + ")";
        }
        if (root.left == null && root.right != null) {
            // 空的左子树不能省略
            return root.val + "()" + "(" + rightStr + ")";
        }
        // 按题目要求处理 root 左右子树都不空的情况
        return root.val + "(" + leftStr + ")" + "(" + rightStr + ")";
    }

    // 官方题解
    public String tree2str2(TreeNode root){
        if (root == null) return "";
        if (root.left == null && root.right == null){
            return Integer.toString(root.val);
        }
        if (root.right == null) {
            return new StringBuffer().append(root.val).append("(").append(tree2str2(root.left)).append(")").toString();
        }
        return new StringBuffer().append(root.val).append("(").append(tree2str2(root.left)).append(")(").append(tree2str2(root.right)).append(")").toString();
    }

}
