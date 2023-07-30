package graph;

import java.util.Arrays;

/**
 * @author: Leeyoa
 * @description:
 * @date: 2023/7/29 18:56
 */
public class ConnectingCitiesWithMinimumCost_1135 {
    int minimumCost(int n, int[][] connections) {
        // 城市编号为 1..n，所以初始化大小为 n+1
        UFCommon ufCommon = new UFCommon(n+1);
        Arrays.sort(connections, (a, b) -> (a[2] - b[2]));
        int mst = 0;
        for (int[] edge : connections) {
            int u = edge[0];
            int v = edge[1];
            int weight = edge[2];
            // 如果这条边会产生环，则不能加入 mst
            if (ufCommon.connected(u, v)) {
                continue;
            }
            // 若这条边不会产生环，则属于最小生成树
            mst += weight;
            ufCommon.union(u, v);
        }
        // 保证所有节点都被连通
        // 按理说 ufCommon.count() == 1 说明所有节点被连通
        // 但因为节点 0 没有被使用，所以 0 会额外占用一个连通分量
        return ufCommon.count() == 2 ? mst : -1;
    }
}
