package bfs;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

class OpenTheLock_752 {
    public int openLock(String[] deadends, String target) {
        // 记录所有需要跳过的死亡密码
        Set<String> deads = new HashSet<>();
        for (String s : deadends)
            deads.add(s);
        // 记录已经穷举过的密码，防止走回头路
        Set<String> visited = new HashSet<>();
        Queue<String> q = new LinkedList<>();
        // 从起点开始启动广东优先搜索
        int step = 0;
        q.offer("0000");
        visited.add("0000");

        while(!q.isEmpty()){
            int sz = q.size();
            // 将当前队列中的所有节点向周围扩散
            for (int i = 0; i<sz;i++){
                String cur = q.poll();
                // 判断是否到达终点
                if (deads.contains(cur))
                    continue;
                if (cur.equals(target))
                    return step;

                // 将每一个节点的相邻节点加入队列
                for (int j=0;j<4;j++){
                    String up = plusOne(cur,j);
                    if (!visited.contains(up)){
                        q.offer(up);
                        visited.add(up);
                    }

                    String down = minusOne(cur,j);
                    if (!visited.contains(down)){
                        q.offer(down);
                        visited.add(down);
                    }
                }
            }
            // 增加步数
            step++;
        }
        return -1;
    }

    // 将 s[j] 向上拨动一次
    String plusOne(String s, int j) {
        char[] ch = s.toCharArray();
        if (ch[j] == '9')
            ch[j] = '0';
        else
            ch[j] += 1;
        return new String(ch);
    }
    // 将 s[j] 向下拨动一次
    String minusOne(String s, int j){
        char[] ch = s.toCharArray();
        if (ch[j]=='0')
            ch[j] = '9';
        else
            ch[j] -=1;
        return new String(ch);
    }
    // BFS 框架，打印出所有可能的密码
    void BFS(String target){
        Queue<String> q = new LinkedList<>();
        q.offer("0000");

        while(!q.isEmpty()){
            int sz = q.size();
            // 将当前队列中的所有节点向周围扩散
            for (int i = 0; i<sz;i++){
                String cur = q.poll();
                // 判断是否到达终点
                System.out.println(cur);
                // 将每一个节点的相邻节点加入队列
                for (int j=0;j<4;j++){
                    String up = plusOne(cur,j);
                    String down = minusOne(cur,j);
                    q.offer(up);
                    q.offer(down);
                }
            }
            // 增加步数
        }
    }

    // 双向 BFS
    int openLock2(String[] deadends, String target){
        Set<String> deads = new HashSet<>();
        for (String s : deadends) deads.add(s);
        // 用集合不用队列，可以快速判断元素是否存在
        Set<String> q1 = new HashSet<>();
        Set<String> q2 = new HashSet<>();
        Set<String> visited = new HashSet<>();

        int step = 0;
        q1.add("0000");
        q2.add(target);

        while(!q1.isEmpty() && !q2.isEmpty()){
            // 哈希集合在遍历的过程中不能修改，用 temp 存储扩散结果
            Set<String> temp = new HashSet<>();

            for (String cur :q1){
                // 判断是否到达终点
                if (deads.contains(cur))
                    continue;
                if (q2.contains(cur))
                    return step;

                visited.add(cur);

                // 将一个节点的未遍历相邻节点加入集合
                for (int j=0;j<4;j++){
                    String up = plusOne(cur,j);
                    if (!visited.contains(up))
                        temp.add(up);
                    String down = minusOne(cur,j);
                    if (!visited.contains(down))
                        temp.add(down);
                }
            }
            // 增加步数
            step++;
            // temp 相当于 q1
            // 这里交换 q1 q2， 下一轮 while 就是扩散 q2
            q1 = q2;
            q2 = temp;
        }
        return -1;
    }
}
