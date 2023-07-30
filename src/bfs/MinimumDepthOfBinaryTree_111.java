package bfs;

import binarytree.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author: Leeyoa
 * @description:
 * @date: 2023/7/29 22:06
 */
public class MinimumDepthOfBinaryTree_111 {
    int minDepth(TreeNode root){
        if (root == null) return 0;
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        // root 本身就是一层， depth 初始化为 1
        int depth = 1;

        while(!q.isEmpty()){
            int sz = q.size();
            // 将当前队列中的所有节点向四周扩散
            for (int i = 0; i < sz; i++) {
                TreeNode cur = q.poll();
                // 判断是否到达重点
                if (cur.left == null && cur.right == null){
                    return depth;
                }
                if (cur.left!=null)
                    q.offer(cur.left);
                if (cur.right!=null)
                    q.offer(cur.right);
            }
            depth++;
        }
        return depth;
    }
}
