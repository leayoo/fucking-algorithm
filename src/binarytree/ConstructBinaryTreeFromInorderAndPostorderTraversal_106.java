package binarytree;

import java.util.HashMap;

public class ConstructBinaryTreeFromInorderAndPostorderTraversal_106 {
    // 存储 inorder 中值到索引的映射
    HashMap<Integer, Integer> valToIndex = new HashMap<>();

    TreeNode buildTree(int[] inorder, int[] postorder) {
        for (int i = 0; i < inorder.length; i++) {
            valToIndex.put(inorder[i], i);
        }
        return build(inorder, 0, inorder.length - 1,
                postorder, 0, postorder.length - 1);
    }

    /*
    build 函数的定义:
    后序遍历数组为 postorder[postStart..postEnd]
    中序遍历数组为 inorder[inStart..inEnd]
    构造二叉树，返回该二叉树的根节点
     */
    TreeNode build(int[] inorder, int inStart, int inEnd,
                   int[] postorder, int postStart, int postEnd) {
        // base case
        if (inStart > inEnd) {
            return null;
        }

        // 确定根节点的值， root 节点对应的值就是后序遍历数组的最后一个元素
        int rootVal = postorder[postEnd];
        // rootVal 在中序遍历数组中的索引
        int index = valToIndex.get(rootVal);

        // 确定根节点
        TreeNode root = new TreeNode(rootVal);
        // 左子树的节点个数
        int leftSize = index - inStart;
        // 递归构造左右子树
        root.left = build(inorder, inStart, index - 1,
                postorder, postStart, postStart + leftSize - 1);
        root.right = build(inorder, index + 1, inEnd,
                postorder, postStart + leftSize, postEnd);
        return root;
    }
}
