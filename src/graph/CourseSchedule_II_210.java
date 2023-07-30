package graph;

import java.util.*;

/**
 * @author: Leeyoa
 * @description:
 * @date: 2023/7/27 21:35
 */

// 拓展，拓扑排序的结果就是反转之后的后序遍历结果
public class CourseSchedule_II_210 {
    // 记录遍历过的节点，防止走回头路
    boolean[] visited;

    // 记录一次递归栈中的节点
    boolean[] onPath;

    // 记录图中是否有环
    boolean hasCycle = false;

    // 记录后序遍历结果
    List<Integer> postorder= new ArrayList<>();
    int[] findOrder(int numCourses, int[][] prerequisites){
        List<Integer>[] graph = buildGraph(numCourses,prerequisites);
        visited = new boolean[numCourses];
        onPath = new boolean[numCourses];

        for (int i = 0; i < numCourses; i++) {
            traverse(graph, i);
        }

        if (hasCycle){
            return new int[]{};
        }

        Collections.reverse(postorder);
        int[] res = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            res[i] = postorder.get(i);
        }
        return res;
    }

    // 图论的DFS算法遍历框架，无非是从二叉树遍历拓展 + visited数组
    // 防止重复遍历同一个节点
    void traverse(List<Integer>[] graph, int s){
        if (onPath[s]){
            // 发现环
            hasCycle = true;
        }
        if (visited[s] || hasCycle){
            // 如果发现环，则退出遍历
            return;
        }
        // 有回溯算法的味道了
        // 前序遍历位置
        // 将节点 s 标记为已遍历
        visited[s] = true;
        // 进入，开始遍历节点 s
        onPath[s] = true;
        for (int t : graph[s]){
            traverse(graph, t);
        }
        // 后序遍历位置
        // 离开，节点 s 遍历完成
        postorder.add(s);
        onPath[s] = false;
    }

    List<Integer>[] buildGraph(int numCourses, int[][] prerequiresites){
        List<Integer>[] graph = new LinkedList[numCourses];
        for (int i = 0; i < numCourses; i++) {
            graph[i] = new LinkedList<>();
        }
        for (int[] edge: prerequiresites){
            int from = edge[1],to = edge[0];
            graph[from].add(to);
        }
        return graph;
    }

    public int[] findOrdder(int numCourses, int[][] prerequisites){
        List<Integer>[] graph = buildGraph(numCourses, prerequisites);
        // 计算入度
        int[] indegree = new int[numCourses];
        for (int[] edge : prerequisites){
            int from = edge[1],to = edge[0];
            indegree[to]++;
        }

        // 根据入度初始化队列中的节点，和环检测算法相同
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0){
                q.offer(i);
            }
        }

        // 记录拓扑排序结果
        int[] res = new int[numCourses];
        // 记录遍历节点的顺序
        int count = 0;
        // 开始执行 BFS 算法
        while(!q.isEmpty()){
            int cur = q.poll();
            res[count] = cur;
            count++;
            for (int next : graph[cur]){
                indegree[next]--;
                if (indegree[next] == 0){
                    q.offer(next);
                }
            }
        }

        if (count != numCourses){
            return new int[]{};
        }

        return res;
    }
}







