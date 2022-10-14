package linkedlist;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ReversePrint_Offer06 {
    // 记录链表长度
    int len = 0;
    // 结果数组
    int res[];
    // 结果数组中的指针
    int p = 0;

    public int[] reversePrint(ListNode head) {
        traverse(head);
        return res;
    }

    // 递归遍历单链表
    void traverse(ListNode head) {
        if (head == null){
            // 到达链表尾部，此时知道了链表的总长度
            // 创建结果数组
            res = new int[len];
            return;
        }
        len++;
        traverse(head.next);
        // 后序位置，可以倒序操作链表
        res[p] = head.val;
        p++;
    }

    // 用「分解问题」的思路写递归解法
    // 因为 Java 的 int[] 数组不支持 add 相关的操作，所以我们把返回值修改成 List
    // 定义：输入一个单链表，返回该链表翻转的值，示例 1->2->3
    List<Integer> reversePrint2(ListNode head) {
        // base case
        if (head==null){
            return new LinkedList<>();
        }

        // 把子链表翻转的结果算出来，示例 [3, 2]
        List<Integer> subProblem = reversePrint2(head.next);
        subProblem.add(head.val);
        return subProblem;
    }


}
