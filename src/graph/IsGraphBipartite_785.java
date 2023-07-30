package graph;

/**
 * @author: Leeyoa
 * @description:
 * @date: 2023/7/28 10:35
 */
public class IsGraphBipartite_785 {

    private boolean ok = true;
    private boolean[] color;
    private boolean[] visited;

    boolean isBipartite(int[][] graph){
        int n = graph.length;
        color = new boolean[n];
        visited = new boolean[n];

        for (int v = 0; v < n; v++) {
            if (!visited[v]){
                traverse(graph,v);
            }
        }
        return ok;
    }

    void traverse(int[][] graph, int v){
        if (!ok) return;

        visited[v] = true;
        // 遍历节点 v 的所有相邻节点 neighbor
        for (int w : graph[v]){
            if (!visited[w]){
                // 相邻节点 neighbor 没有被访问过
                // 那么应该给节点 neighbor 涂上和节点 v 不同的颜色
                traverse(graph, w);
            } else{
                // 相邻节点 neighbor 已经被访问过
                // 那么应该比较节点 neighbor 和节点 v 的颜色
                // 相同，则不是二分图
                if (color[w] == color[v]){
                    ok = false;
                    return;
                }
            }
        }
    }
}
