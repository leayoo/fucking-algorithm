package graph;

import java.util.*;

/**
 * @author: Leeyoa
 * @description:
 * @date: 2023/7/30 2:16
 */
public class PathWithMaximumProbability_1514 {
    double maxProbability(int n, int[][] edges, double[] succProb, int start, int end) {
        List<double[]>[] graph = new LinkedList[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new LinkedList<>();
        }
        // 构造邻接表结构表示图
        for (int i = 0; i < edges.length; i++) {
            int from = edges[i][0];
            int to = edges[i][1];
            double weight = succProb[i];
            // 无向图就是双向图：先把 int 统一转成 double ，待会在转回来
            graph[from].add(new double[]{(double) to, weight});
            graph[to].add(new double[]{(double) from, weight});
        }
        return dijkstra(start, end, graph);
    }

    class State{
        int id;
        double probFromStart;

        State(int id, double probFromStart){
            this.id = id;
            this.probFromStart = probFromStart;
        }

    }

    double dijkstra(int start, int end, List<double[]>[] graph){
        double[] probTo = new double[graph.length];

        Arrays.fill(probTo, -1);
        probTo[start] = 1;

        Queue<State> pq = new PriorityQueue<>((a,b) -> {
            return Double.compare(b.probFromStart, a.probFromStart);
        });

        pq.offer(new State(start,1));

        while(!pq.isEmpty()){
            State curState = pq.poll();
            int curNodeID = curState.id;
            double curProbFromStart = curState.probFromStart;

            if (curNodeID == end){
                return curProbFromStart;
            }

            if (curProbFromStart < probTo[curNodeID]){
                continue;
            }

            for (double[] neighbor : graph[curNodeID]){
                int nextNodeID = (int)neighbor[0];

                double probToNextNode = probTo[curNodeID] * neighbor[1];
                if (probTo[nextNodeID] < probToNextNode){
                    probTo[nextNodeID] = probToNextNode;
                    pq.offer(new State(nextNodeID, probToNextNode));
                }
            }
        }
        return 0.0;
    }
}
