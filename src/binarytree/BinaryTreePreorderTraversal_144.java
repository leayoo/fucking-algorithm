package binarytree;

import java.util.LinkedList;
import java.util.List;

public class BinaryTreePreorderTraversal_144 {
    List<Integer> result = new LinkedList<>();
    public List<Integer> preorderTraversal(TreeNode root) {
        traverse(root);
        return result;
    }
    // 前序遍历
    void traverse(TreeNode root){
        if (root == null) return ;
        result.add(root.val);
        traverse(root.left);
        traverse(root.right);
    }
}
