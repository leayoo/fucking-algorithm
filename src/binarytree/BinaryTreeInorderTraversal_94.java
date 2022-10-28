package binarytree;

import java.util.LinkedList;
import java.util.List;

class BinaryTreeInorderTraversal_94 {
    List<Integer> result = new LinkedList<>();

    public List<Integer> inorderTraversal(TreeNode root) {
        traverse(root);
        return result;
    }

    void traverse(TreeNode root){
        if (root == null) return;

        traverse(root.left);
        result.add(root.val);
        traverse(root.right);
    }
}
