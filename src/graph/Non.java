package graph;

/**
 * @author: Leeyoa
 * @description:
 * @date: 2023/7/28 10:28
 */
public class Non {
    boolean[] visited;

    void traverse(Graph graph, boolean[]visited, int v){
        visited[v] = true;
        // 遍历节点 v 的所有相邻节点 neighbor
        for (int neighbor : graph.neighbors(v)){
            if (!visited[neighbor]){
                // 相邻节点 neighbor 没有被访问过
                // 那么应该给节点 neighbor 涂上和节点 v 不同的颜色
                traverse(graph, visited, neighbor);
            } else{
                // 相邻节点 neighbor 已经被访问过
                // 那么应该比较节点 neighbor 和节点 v 的颜色
                // 相同，则不是二分图

            }
        }
    }
}
