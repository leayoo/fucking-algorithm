package graph;


/**
 * @author: Leeyoa
 * @description:
 * @date: 2023/7/29 16:17
 */
public class NumberOfConnectedComponentsInAnUndirectedGraph_323 {
    int countComponents(int n, int[][] edges){
        UFCommon ufCommon = new UFCommon(n);
        for (int[] e :edges){
            ufCommon.union(e[0],e[1]);
        }
        return ufCommon.count();
    }
}
