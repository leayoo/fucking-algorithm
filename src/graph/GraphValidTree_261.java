package graph;

/**
 * @author: Leeyoa
 * @description:
 * @date: 2023/7/29 18:43
 */
public class GraphValidTree_261 {
    boolean validTree(int n, int[][] edges){
        UFCommon ufCommon = new UFCommon(n);
        for (int[] edge:edges){
            int u = edge[0];
            int v = edge[1];
            // 若两个节点已经在同一连通分量中，会产生环
            if (ufCommon.connected(u,v)){
                return false;
            }
            // 这条边不会产生环，可以是树的一部分
            ufCommon.union(u,v);
        }
        // 要保证最后只形成了一棵树，即只有一个连通分量
        return ufCommon.count() == 1;
    }
}
