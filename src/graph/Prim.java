package graph;

import java.util.List;
import java.util.PriorityQueue;

/**
 * @author: Leeyoa
 * @description:
 * @date: 2023/7/29 20:05
 */
public class Prim {
    // 核心数据结构，存储「横切边」的优先级队列
    private PriorityQueue<int[]> pq;

    // 类似 visited 数组的作用，记录哪些节点已经成为最小生成树的一部分
    private boolean[] inMST;

    // 记录最小生成树的权重和
    private int weightSum = 0;

    // graph 是邻接表表示的一幅图
    // graph[s] 记录节点 s 所有相邻的边
    // 三元组 int[]{from, to, weight} 表示一条边
    private List<int[]>[] graph;

    public Prim(List<int[]>[] graph){
        this.graph = graph;
        this.pq = new PriorityQueue<>((a,b) -> {
            // 按照边的权重从小到大排序
            return a[2] - b[2];
        });
        // 图中有 n 个节点
        int n = graph.length;
        this.inMST = new boolean[n];

        // 随便从一个切点开始切分都可以，我们从节点 0 开始
        inMST[0] = true;
        cut(0);
        // 不断进行切分，向最小生成树添加边
        while(!pq.isEmpty()){
            int[] edge = pq.poll();
            int to = edge[1];
            int weight = edge[2];
            if (inMST[to]){
                // 节点 to 已经在最小生成树中，跳过
                // 否则这条边会产生环
                continue;
            }
            weightSum += weight;
            inMST[to] = true;
            cut(to);
        }
    }
    
    // 将 s 的横切边加入 优先级队列
    private void cut(int s){
        // 遍历 s 的邻边
        for (int[] edge: graph[s]){
            int to = edge[1];
            if (inMST[to]){
                // 相邻接点 to 已经在最小生成树中，跳过
                // 否则这条边会产生换
                continue;
            }
            // 加入横切边队列
            pq.offer(edge);
        }
        
    }
    
    // 最小生成树的权重和
    public int weightSum(){
        return weightSum;
    }
    
    // 判断最小生成树是否包含图中所有的节点
    public boolean allConnected(){
        for (int i = 0; i < inMST.length; i++) {
            if (!inMST[i]){
                return false;
            }
        }
        return true;
    }
}
