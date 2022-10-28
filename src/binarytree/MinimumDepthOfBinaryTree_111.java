package binarytree;

import java.util.*;

class MinimumDepthOfBinaryTree_111 {
    // BFS 思路
    public int minDepth(TreeNode root) {
        // 采用 BFS
        if (root == null) return 0;
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        // root 本身就是一层， depth 初始化为 1
        int depth = 1;

        while (!q.isEmpty()){
            int sz = q.size();
            /* 将队列中的所有节点向四周扩散 */
            for (int i=0;i<sz;i++){
                TreeNode cur = q.poll();
                // 判断是否到达终点
                if (cur.left==null && cur.right == null){
                    return depth;
                }
                // 将 cur 的相邻节点加入队列
                if (cur.left != null)
                    q.offer(cur.left);
                if (cur.right !=null)
                    q.offer(cur.right);
            }
            // 增加步数
            depth++;
        }
        return depth;
    }

    // 递归思路
    public int minDepth2(TreeNode root){
        if (root == null) return 0;
        // 1. 左孩子和右孩子都为空的情况，说明到达了叶子节点，直接返回 1
        if (root.left == null && root.right == null)
            return 1;
        // 2. 如果左孩子和由孩子其中一个为空，那么需要返回比较大的那个孩子的深度
        int m1 = minDepth2(root.left);
        int m2 = minDepth2(root.right);
        // 这里其中一个节点为空，说明 m1 和 m2 有一个必然为 0，所以可以返回 m1 + m2 + 1;
        if (root.left == null || root.right == null)
            return m1 + m2 + 1;

        // 3.最后一种情况，也就是左右孩子都不为空，返回最小深度 +1 即可
        return Math.min(m1, m2) + 1;
    }

    // 简化递归
    public int minDepth3(TreeNode root) {
        if(root == null) return 0;
        int m1 = minDepth3(root.left);
        int m2 = minDepth3(root.right);
        //1.如果左孩子和右孩子有为空的情况，直接返回 m1 + m2 + 1
        //2.如果都不为空，返回较小深度+1
        return root.left == null || root.right == null ? m1 + m2 + 1 : Math.min(m1, m2) + 1;
    }
}
