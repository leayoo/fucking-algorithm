package binarytree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class AverageOfLevelsInBinaryTree_637 {
    ArrayList<Double> res = new ArrayList<>();

    public List<Double> averageOfLevels(TreeNode root) {
        // 层序遍历二叉树
        if (root == null) return res;
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        // 从上到下遍历二叉树的每一层
        while (!q.isEmpty()) {
            int sz = q.size();
            double sum = 0.0;
            for (int i = 0; i < sz; i++) {
                TreeNode cur = q.poll();
                sum += cur.val;
                // 从左到右遍历每一层的每个节点
                if (cur.left != null) {
                    q.offer(cur.left);
                }
                if (cur.right != null) {
                    q.offer(cur.right);
                }
            }
            double average = sum / (double) sz;
            res.add(average);
        }
        return res;
    }
}
