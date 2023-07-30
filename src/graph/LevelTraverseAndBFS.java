package graph;

import binarytree.TreeNode;

import java.util.*;

/**
 * @author: Leeyoa
 * @description:
 * @date: 2023/7/29 23:02
 */
public class LevelTraverseAndBFS {

    // 输入一颗二叉树的根节点，层序遍历这颗二叉树
    void levelTraverse(TreeNode root) {
        if (root == null) return 0;
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        int depth = 1;
        // 从上到下遍历二叉树的每一层
        while (!q.isEmpty()) {
            int sz = q.size();
            // 从左到有遍历每一层的每个节点
            for (int i = 0; i < sz; i++) {
                TreeNode cur = q.poll();
                System.out.println("节点 " + cur + " 在第 " + depth + " 层");

                // 将下一层节点放入队列
                if (cur.left != null) {
                    q.offer(cur.left);
                }
                if (cur.right != null) {
                    q.offer(cur.right);
                }
            }
            depth++;
        }
    }

    // 输入一棵多叉树的根节点，层序遍历这颗多叉树
    void levelTraverseD(TreeNode root) {
        if (root == null) return 0;
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        int depth = 1;
        // 从上到下遍历二叉树的每一层
        while (!q.isEmpty()) {
            int sz = q.size();
            // 从左到有遍历每一层的每个节点
            for (int i = 0; i < sz; i++) {
                TreeNode cur = q.poll();
                System.out.println("节点 " + cur + " 在第 " + depth + " 层");

                // 将下一层节点放入队列
                for (TreeNode child : cur.children) {
                    q.offer(child);
                }
            }
            depth++;
        }
    }

    // BFS，Node 为图中的节点
    int BFS(Node start) {
        Queue<Node> q; // 核心数据结构
        Set<Node> visited; // 避免走回头路

        q.offer(start); // 将起点加入队列
        visited.add(start);

        int step = 0;
        while (q not empty){
            int sz = q.size();
            for (int i = 0; i < sz; i++) {
                Node cur = q.poll();
                System.out.println("从 " + start + " 到 " + cur + " 的最短距离是 " + step);
                // 将 cur 的相邻节点加入队列
                for (Node x : cur.adj()){
                    if (x not in visited){
                        q.offer(x);
                        visited.add(x);
                    }
                }
            }
            step++;
        }
    }


    // 二叉树为例子，没有 for 循环的情况下，维护 depth 变量
    public class StateForBinaryTree {
        int depth;
        TreeNode node;

        StateForBinaryTree(TreeNode node, int depth){
            this.depth = depth;
            this.node = node;
        }
    }

    void levelTraverseWithoutFor(TreeNode root){
        if (root == null) return;
        Queue<StateForBinaryTree> q = new LinkedList<>();
        q.offer(new StateForBinaryTree(root, 1));

        // 遍历二叉树的每一个节点
        while (!q.isEmpty()){
            StateForBinaryTree cur = q.poll();
            TreeNode cur_node = cur.node;
            int cur_depth = cur.depth;
            System.out.println("节点 " + cur_node + " 在第 " + cur_depth + " 层");

            // 将子节点放入队列
            if (cur_node.left != null){
                q.offer(new StateForBinaryTree(cur_node.left, cur_depth+1));
            }
            if (cur_node.right != null){
                q.offer(new StateForBinaryTree(cur_node.right, cur_depth+1));
            }
        }
    }

    class State{
        // 图节点的 id
        int id;

        // 从 start 节点到当前节点的距离
        int distFromStart;

        State(int id, int distFromStart){
            this.id = id;
            this.distFromStart = distFromStart;
        }

    }
    // Dijkstra 算法框架
    // 输入一幅图和一个起点 start, 计算 start 到其他节点的最短路径权重
    // 可以理解成一个带 dp table（或者说备忘录）的BFS算法
    int[] dijkstra(int start, List<Integer>[] graph){
        // 图中节点的个数
        int V = graph.length;
        // 记录最短路径的权重，你可以理解为 dp table
        // 定义：distTo[i] 的值就是节点 start 到节点 i 的最短路径权重
        int[] distTo = new int[V];
        // 求最小值，所以 dp table 初始化为正无穷
        Arrays.fill(distTo, Integer.MAX_VALUE);
        // base case，start 到 start 的最短距离就是 0
        distTo[start] = 0;
        // 优先级队列，distFromStart 较小的排在前面
        Queue<State> pq = new PriorityQueue<>((a,b) ->{
            return a.distFromStart - b.distFromStart;
        });

        // 从起点 start 开始进行 BFS
        pq.offer(new State(start, 0));

        while (!pq.isEmpty()){
            State curState = pq.poll();
            int curNodeID = curState.id;
            int curDistFromStart = curState.distFromStart;

            if (curDistFromStart > distTo[curNodeID]){
                // 已经有一条更短的路径到达 curNode 节点了
                continue;
            }

            // 将 curNode 的相邻节点装入队列
            for (int nextNodeID : adj(curNodeID)){
                // 看看从 curNode 达到 nextNode 的距离是否会更短
                int distToNextNode = distTo[curNodeID] + weight(curNodeID,nextNodeID);
                if (distTo[nextNodeID] > distToNextNode){
                    // 更新 dp table
                    distTo[nextNodeID] = distToNextNode;
                    // 将这个节点以及距离放入队列
                    pq.offer(new State(nextNodeID, distToNextNode));
                }
            }
        }
        return distTo;
    }

    // 返回节点 from 到节点 to 之间的边的权重
    int weight(int from, int to);

    // 输入节点 s 返回 s 的相邻节点
    List<Integer> adj(int s);




}
