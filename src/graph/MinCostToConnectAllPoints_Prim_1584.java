package graph;

import java.util.LinkedList;
import java.util.List;

/**
 * @author: Leeyoa
 * @description:
 * @date: 2023/7/29 20:40
 */
public class MinCostToConnectAllPoints_Prim_1584 {
    int minCostConnectPoints(int[][] points){
        int n = points.length;
        List<int[]>[] graph = buildGraph(n, points);
        return new Prim(graph).weightSum();
    }

    // 构造无向图
    List<int[]>[] buildGraph(int n, int[][] points){
        List<int[]>[] graph = new LinkedList[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new LinkedList<>();
        }
        // 生成所有边及权重
        for (int i = 0; i < n; i++) {
            for (int j = i+1; j < n; j++) {
                int xi = points[i][0],yi = points[i][1];
                int xj = points[j][0],yj = points[j][1];
                int weight = Math.abs(xi - xj)+Math.abs(yi-yj);
                // 用 points 中的索引表示坐标点
                graph[i].add(new int[]{i, j, weight});
                graph[j].add(new int[]{i, j, weight});
            }
        }
        return graph;
    }
}
