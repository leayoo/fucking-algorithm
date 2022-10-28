package binarytree;

import java.util.HashMap;

public class ConstructBinaryTreeFromPreorderAndInorderTraversal_105 {
    HashMap<Integer, Integer> valToIndex = new HashMap<>();

    /* 主函数 */
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        for (int i = 0; i < inorder.length; i++) {
            valToIndex.put(inorder[i], i);
        }
        // 根据函数定义，用 preorder 和 inorder 构造二叉树
        return build(preorder, 0, preorder.length - 1,
                inorder, 0, inorder.length - 1);
    }

    /*
    build 函数的定义：
    若前序遍历数组为 preorder[preStart..preEnd]，
    中序遍历数组为 inorder[inStart..inEnd]
    构造二叉树，返回该二叉树的根节点
     */
    TreeNode build(int[] preorder, int preStart, int preEnd,
                   int[] inorder, int inStart, int inEnd) {
        // base case
        if (preStart > preEnd){
            return null;
        }

        // root 节点对应的值就是前序遍历数组的第一个元素
        int rootVal = preorder[preStart];
        // rootVal 在中序遍历数组中的索引
        int index = valToIndex.get(rootVal);

        TreeNode root = new TreeNode(rootVal);
        // 递归构造左右子树
        int leftSize = index - inStart;
        root.left = build(preorder, preStart + 1, preStart + leftSize,
                inorder, inStart, index - 1);
        root.right = build(preorder, preStart + leftSize + 1, preEnd,
                inorder, index + 1, inEnd);
        return root;
    }
}
