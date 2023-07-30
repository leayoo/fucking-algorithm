package graph;

import java.util.LinkedList;
import java.util.List;

/**
 * @author: Leeyoa
 * @description:
 * @date: 2023/7/28 11:11
 */
public class PossibleBipartition_886 {
    boolean ok = true;
    boolean[] color;
    boolean[] visited;
    boolean possibleBipartition(int n, int[][] dislikes){
        color = new boolean[n+1];
        visited = new boolean[n+1];

        // 转换成邻接表表示图结构
        List<Integer>[] graph = buildGraph(n, dislike);

        for (int v = 1; v <= n; v++) {
            if (!visited[v]){
                traverse(graph, v);
            }
        }
        return ok;
    }

    void traverse(List<Integer>[] graph, int v){
        if (!ok) return;
        visited[v] = true;
        for (int w:graph[v]){
            if (!visited[w]){
                color[w] = !color[v];
                traverse(graph, w);
            } else {
                if (color[w] == color[v]){
                    ok = false;
                    return;
                }
            }
        }
    }

    private List<Integer>[] buildGraph(int n, int[][] dislikes){
        List<Integer>[] graph = new LinkedList[n+1];
        for (int i = 1; i <= n; i++) {
            graph[i] = new LinkedList<>();
        }
        for (int[] edge: dislikes){
            int v = edge[1];
            int w = edge[0];
            // 无向图相当于双向图
            graph[v].add(w);
            graph[w].add(v);
        }
        return graph;
    }
}
