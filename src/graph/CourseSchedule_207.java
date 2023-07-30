package graph;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author: Leeyoa
 * @description:
 * @date: 2023/7/26 15:31
 */
public class CourseSchedule_207 {
    // DFS 版本
    // 记录遍历过的节点，防止走回头路
    boolean[] visited;

    // 记录一次递归栈中的节点
    boolean[] onPath;

    // 记录图中是否有环
    boolean hasCycle = false;

    boolean canFinish(int numCourses, int[][] prerequisites) {
        List<Integer>[] graph = buildGraph(numCourses, prerequisites);

        visited = new boolean[numCourses];
        onPath = new boolean[numCourses];

        for (int i = 0; i < numCourses; i++) {
            // 遍历图中所有节点
            traverse(graph, i);
        }
        // 只要没有循坏依赖就可以完成所有课程
        return !hasCycle;
    }

    // 图论的DFS算法遍历框架，无非是从二叉树遍历拓展 + visited数组
    // 防止重复遍历同一个节点
    void traverse(List<Integer>[] graph, int s) {
        if (onPath[s]) {
            // 发现环
            hasCycle = true;
        }
        if (visited[s] || hasCycle) {
            // 如果发现环，则退出遍历
            return;
        }
        // 有回溯算法的味道了
        // 前序遍历位置
        // 将节点 s 标记为已遍历
        visited[s] = true;
        // 进入，开始遍历节点 s
        onPath[s] = true;
        for (int t : graph[s]) {
            traverse(graph, t);
        }
        // 离开，节点 s 遍历完成
        onPath[s] = false;
    }

    List<Integer>[] buildGraph(int numCourses, int[][] prerequiresites) {
        List<Integer>[] graph = new LinkedList[numCourses];
        for (int i = 0; i < numCourses; i++) {
            graph[i] = new LinkedList<>();
        }
        for (int[] edge : prerequiresites) {
            int from = edge[1], to = edge[0];
            graph[from].add(to);
        }
        return graph;
    }

    // BFS 版本
    public boolean canFinishBFS(int numCourses, int[][] prerequisites) {
        List<Integer>[] graph = buildGraph(numCourses, prerequisites);
        // 构建入度数组
        int[] indegree = new int[numCourses];
        for (int[] edge : prerequisites) {
            int from = edge[1], to = edge[0];
            indegree[to]++;
        }

        // 根据入度初始化队列中的节点
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0) {
                // 节点 i 没有入度，即没有依赖的节点
                // 可以作为拓扑排序的起点，加入队列
                q.offer(i);
            }
        }

        // 记录遍历的节点个数
        int count = 0;
        // 开始执行 BFS 循环
        while (!q.isEmpty()) {
            // 弹出节点 cur, 并将它指向的节点的入度减一
            int cur = q.poll();
            count++;
            for (int next : graph[cur]) {
                indegree[next]--;
                if (indegree[next] == 0) {
                    // 如果入度变为0，说明 next 依赖的节点都已被遍历
                    q.offer(next);
                }
            }
        }
        // 如果所有节点都被遍历过，说明不成环
        return count == numCourses;
    }
}

