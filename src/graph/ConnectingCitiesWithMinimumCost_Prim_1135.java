package graph;

import java.util.LinkedList;
import java.util.List;

/**
 * @author: Leeyoa
 * @description:
 * @date: 2023/7/29 20:32
 */
public class ConnectingCitiesWithMinimumCost_Prim_1135 {
    int minimumCost(int n, int[][] connections){
        // 转化为无向图邻接表的形式
        List<int[]>[] graph = buildGraph(n, connections);
        // 执行 Prim 算法
        Prim prim = new Prim(graph);

        if (!prim.allConnected()){
            return -1;
        }

        return prim.weightSum();
    }

    List<int[]>[] buildGraph(int n, int[][] connections){
        // 图中共有 n 个节点
        List<int[]>[] graph = new LinkedList[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new LinkedList<>();
        }

        for (int[] conn : connections){
            int u = conn[0] - 1;
            int v = conn[1] - 1;
            int weight = conn[2];

            graph[u].add(new int[]{u, v , weight});
            graph[v].add(new int[]{u, v, weight});
        }
        return graph;
    }
}
