package bfs;
import java.util.Queue;
import java.util.Set;

/**
 * @author: Leeyoa
 * @description:
 * @date: 2023/7/29 21:58
 */
public class BFS {

    // 计算从起点 start 到终点 target 的最近距离
    int BFS(Node start, Node target){
        Queue<Node> q; // 核心数据结构
        Set<Node> visited; // 避免走回头路

        q.offer(start); // 将起点加入队列
        visited.add(start);

        while(q not empty){
            int sz = q.size();
            // 将当前队列中的所有节点向四周扩散
            for (int i = 0; i<sz;i++){
                Node cur = q.poll();
                // 这里判断是否到达终点
                if (cur is target)
                    return step;
                // 将 cur 的相邻的节点加入队列
                for (Node x: cur.adj()){ // cur.adj() 泛指 cur 相邻的节点，比如二维数组中，是上下左右四面
                    if (x not in visited){ // visited 防止走回头路
                        q.offer(x);
                        visited.add(x);
                    }
                }
            }
        }
        // 如果走到这里，说明在图中没有找到目标节点


    }
}
