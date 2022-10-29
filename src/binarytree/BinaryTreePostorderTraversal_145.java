package binarytree;

import java.util.LinkedList;
import java.util.List;

public class BinaryTreePostorderTraversal_145 {
    List<Integer> result = new LinkedList<>();
    public List<Integer> postorderTraversal(TreeNode root) {
        traverse(root);
        return result;
    }
    void traverse(TreeNode root){
        if (root == null) return;
        traverse(root.left);
        traverse(root.right);
        result.add(root.val);
    }
}
