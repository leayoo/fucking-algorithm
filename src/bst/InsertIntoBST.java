package bst;

/**
 * @author: Leeyoa
 * @description:
 * @date: 2023/7/19 12:28
 */
public class InsertIntoBST {

    TreeNode insertIntoBST(TreeNode root, int val){
        // 找到空位置插入新节点
        if (root == null) return new TreeNode(val);

        if (root.val < val)
            root.right = insertIntoBST(root.right, val);
        if (root.val > val)
            root.left = insertIntoBST(root.left, val);
        return root;
    }
}
