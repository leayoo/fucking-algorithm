package other;

import linkedlist.ListNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: Leeyoa
 * @description:
 * @date: 2023/7/16 23:44
 */

//N个人围成一圈，第一个人从1开始依次进行报数。
// 当报到M时将该人杀掉。然后从被杀掉的下一个人开始，重新从1继续报数。
public class JosephusCircle {
    public int lastRemaining(int n, int m){
        List<Integer> list = new ArrayList<>();
        // 初始化队列
        for (int i = 0; i < n; i++) {
            list.add(i);
        }

        int index = 0;
        while (list.size() > 1){
            // 通过 对链表长度取模 实现环的特性
            int removeIndex = (index + m - 1)  % list.size();
            list.remove(removeIndex);
            index = removeIndex;
        }

        return list.get(0);
    }

    // 数组思路,最简单的
    // 用一个一维数组去标识这个 n 个人的状态，默认全为 1存活 0淘汰
    // 从1开始报数
    public int solution1(int n,int m){
        int result = 0;
        int count = 0; // 已经出圈的人数
        int num = 0; // 计数器
        // 用于标识出圈的人
        int[] flag = new int[n+1];
        for (int j = 1; j <= n; j++) {
            flag[j] = 1;
        }

        // 最后只剩一人，所以淘汰 n-1 人
        while (count < n-1 ){
            // 不断循环遍历 1~n
            for (int j = 1; j <= n; j++) {
                if (flag[j] == 1){
                    num++;
                }
                // 计数器数到 m 就进行淘汰
                if (num == m){
                    System.out.println("淘汰"+j);
                    count++;
                    flag[j] = 0;
                    num = 0;
                }
                if (count == n-1){
                    break;
                }

            }
        }
        for (int j = 1; j <= n; j++) {
            if (flag[j] == 1){
                System.out.println("最终存活的是"+ j);
                result = j;
            }
        }
        return result;
    }

    // 循环链表求解
    class ListNode{
        int val;
        ListNode next;
        // 初始化
        ListNode() {}
        ListNode(int val) {
            this.val = val;
        }
        ListNode(int val, ListNode next){
            this.val = val;
            this.next = next;
        }
    }

    public int solution2(int n, int m){
        ListNode dummy = new ListNode();
        ListNode p = dummy;
        // 建立单向链表
        for (int i = 1; i <= n; i++) {
            ListNode listNode = new ListNode(i);
            p.next = listNode;
            p = p.next;
        }
        // 首尾相连
        p.next = dummy.next;

        // 计数器
        int num = 0;
        // 淘汰人数
        int count = 0;
        while (count < n - 1){
            num++;
            // 移除
            if (num % m == 0){
                System.out.println("移除"+p.next.val);
                p.next = p.next.next;
                count++;
            } else {
                // 注意，移除的时候，p向前走一步
                p = p.next;
            }

        }
        return p.val;
    }



    public static void main(String[] args) {
//        System.out.println(new JosephusCircle().lastRemaining(10,3));
//        System.out.println(new JosephusCircle().solution1(10,3));
        System.out.println(new JosephusCircle().solution2(10,3));
    }
}
