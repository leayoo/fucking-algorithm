package binarytree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

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

    // 非递归形式遍历二叉树
    public List<Integer> preorderTraversal(TreeNode root){
        List<Integer> resultList = new ArrayList<>();
        Stack<TreeNode> treeStack = new Stack<>();

        // 如果空树则返回
        if (root == null)
            return resultList;

        treeStack.push(root);
        while(!treeStack.isEmpty()){
            TreeNode tempNode = treeStack.pop();
            if(tempNode != null){
                resultList.add(tempNode.val);
                // 先序遍历，先压入右节点，再左节点，取出时顺序刚好相反。
                treeStack.push(tempNode.right);
                treeStack.push(tempNode.left);
            }
        }
        return resultList;
    }
}

