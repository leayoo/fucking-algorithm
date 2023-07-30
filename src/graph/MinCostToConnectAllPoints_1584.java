package graph;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author: Leeyoa
 * @description:
 * @date: 2023/7/29 19:06
 */
public class MinCostToConnectAllPoints_1584 {
    public int minCostConnectPoints(int[][] points) {
        int n = points.length;
        // 生成所有边及权重
        List<int[]> edges = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            for (int j = i+1; j < n; j++) {
                int xi = points[i][0],yi = points[i][1];
                int xj = points[j][0],yj = points[j][1];

                edges.add(new int[]{
                        i, j, Math.abs(xi - xj) + Math.abs(yi - yj)
                });
            }
        }
        // 将边按照权重从小到大排序
        Collections.sort(edges, (a, b) -> {
            return a[2] - b[2];
        });

        // 执行 Kruskal 算法
        int mst = 0;
        UFCommon ufCommon = new UFCommon(n);
        for (int[] edge : edges){
            int u = edge[0];
            int v = edge[1];
            int weight = edge[2];
            // 若这条边会产生环，则不能加入
            if (ufCommon.connected(u,v))
                continue;
            // 若不会产生换，则属于最小生成树
            mst += weight;
            ufCommon.union(u,v);
        }
        return mst;
    }
}
