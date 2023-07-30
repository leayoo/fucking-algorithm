package bst;

/**
 * @author: Leeyoa
 * @description:
 * @date: 2023/7/19 12:38
 */
public class DeleteNode {
    TreeNode deleteNode(TreeNode root, int key){
        if (root.val == key){
            // 找到了，进行删除
            // 没有子节点或只有一个子节点的情况
            if (root.left == null) return root.right;
            if (root.right == null) return root.left;
            // 有两个子节点
            TreeNode minNode = getMin(root.right);
            root.val = minNode.val;
            root.right = deleteNode(root.right, minNode.val);
        } else if (root.val > key){
            deleteNode(root.left, key);
        } else {
            deleteNode(root.right, key);
        }
        return root;
    }

    TreeNode getMin(TreeNode node){
        // 右子树最左边的节点就是最小的节点
        while (node.left != null) node = node.left;
        return node;
    }
}
