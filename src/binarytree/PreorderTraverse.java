package binarytree;

import java.util.LinkedList;
import java.util.List;

// 二叉树前序遍历的两种思路
public class PreorderTraverse {
    List<Integer> res = new LinkedList<>();

    // 返回前序遍历结果, 递归遍历思路
    List<Integer> preorderTraverse(TreeNode root){
        traverse(root);
        return res;
    }

    // 二叉树遍历函数
    void traverse(TreeNode root){
        if (root==null){
            return;
        }
        // 前序位置
        res.add(root.val);
        traverse(root.left);
        traverse(root.right);
    }

    // 「分解问题」的思路
    List<Integer> preorderTraverse2(TreeNode root){
        List<Integer> res = new LinkedList<>();
        if (root == null){
            return res;
        }
        // 前序遍历的结果， root.val 在第一个
        res.add(root.val);
        // 利用函数定义，后面接着左子树的前序遍历结果
        res.addAll(preorderTraverse2(root.left));
        // 利用函数定义，后面接着右子树的前序遍历结果
        res.addAll(preorderTraverse2(root.right));
        return res;
    }
}

