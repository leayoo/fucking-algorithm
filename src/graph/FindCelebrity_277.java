package graph;

import java.util.LinkedList;

/**
 * @author: Leeyoa
 * @description:
 * @date: 2023/7/26 12:54
 */
public class FindCelebrity_277 {
    boolean knows(int i, int j){
        return true;
    }

    int findCelebrity1(int n){
        for (int cand = 0; cand < n; cand++) {
            int other;
            for (other = 0;other < n; other++) {
                if (cand == other) continue;
                // 保证其他人都认识 cand，且 cand 不认识任何其他人
                if (knows(cand, other) || !knows(other,cand)){
                    break;
                }
            }
            if (other == n){
                // 符合其他人都认识 cand，而 cand 不认识其他任何人，则找到名人
                return cand;
            }
        }
        return -1;
    }

    int findCelebrity2(int n){
        if (n == 1) return 0;
        // 将所有候选人装进队列
        LinkedList<Integer> q = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            q.addLast(i);
        }
        // 一直排除，直到只剩下一个候选人停止循环
        while (q.size() >= 2){
            // 每次取出两个候选人，排除一个
            int cand = q.removeFirst();
            int other = q.removeFirst();
            if (knows(cand, other) || !knows(other,cand)){
                // cand 不可能是名人，排除，让 other 归队
                q.addFirst(other);
            } else {
                // other 不可能是名人，排除，让 cand 队规
                q.addFirst(cand);
            }
        }

        // 现在排出得只剩一个候选人，判断他是否真的是名人
        int cand = q.removeFirst();
        for (int other = 0; other < n; other++) {
            if (other == cand){
                continue;
            }
            // 保证其他人都认识 cand, 且 cand 不认识其他人
            if (!knows(other,cand) || knows(cand,other)){
                return -1;
            }
        }
        return cand;
    }

    int findCelebrity(int n){
        // 先假设 cand 是名人
        int cand = 0;
        for (int other = 1; other < n; other++) {
            if (!knows(other,cand) || knows(cand,other)){
                cand = other;
            } else {

            }
        }

        for (int other = 0; other < n; other++) {
            if (cand == other) continue;
            if (!knows(other,cand) || knows(cand,other)){
                return -1;
            }
        }
        return cand;
    }
}
