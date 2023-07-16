package binarytree;

import java.util.Stack;

public class InorderTraverse {
    public void InorderTraverse(TreeNode root){
        if (root == null)
            return;

        Stack<TreeNode> s = new Stack<>();
        TreeNode curr = root;

        while (curr != null || s.size() > 0){
            while (curr != null){
                s.push(curr);
                curr = curr.left;
            }
            curr = s.pop();
            // System.out.println(curr.val + " ");
            curr = curr.right;
        }
    }
}
