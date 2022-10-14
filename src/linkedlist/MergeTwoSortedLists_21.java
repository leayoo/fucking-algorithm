package linkedlist;

import java.util.ArrayList;
import java.util.Collections;

class MergeTwoSortedLists_21 {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        // 虚拟头结点
        ListNode dummy = new ListNode(-1);
        ListNode p = dummy;

        ListNode p1 = list1;
        ListNode p2 = list2;

        // 迭代遍历单链表
        // 当两链表都没走完
        while (p1 != null && p2 != null) {
            // 比较两个结点
            // 如果 p1 结点数据小，则 p 指向 p1 , p,p1 后移
            if (p2.val >= p1.val) {
                p.next = p1;
                p = p.next;
                p1 = p1.next;
            } else {
                p.next = p2;
                p = p.next;
                p2 = p2.next;
            }
        }
        // 当存在链表已经走完
        // p1 没有走完
        while (p1 != null) {
            p.next = p1;
            p = p.next;
            p1 = p1.next;
        }
        // p2 没有走完
        while (p2 != null) {
            p.next = p2;
            p = p.next;
            p2 = p2.next;
        }

        return dummy.next;
    }

    // 数组转化为链表
    public ListNode arrayToListNode(Integer[] in) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        Collections.addAll(list, in);

        // 构造 ListNode 组成的链表
        ListNode dummy = new ListNode();
        ListNode head = dummy;
        for (int i = 0; i < list.size(); i++) {
            ListNode p = new ListNode(list.get(i));
            head.next = p;
            head = head.next;
        }
        return dummy.next;
    }

    // 遍历链表
    public void traverse(ListNode listNode){
        ArrayList result = new ArrayList();
        // 遍历链表
        for (ListNode p = listNode; p != null; p = p.next) {
            result.add(p.val);
        }
        System.out.println(result);
    }

    public static void main(String[] args) {
        Integer[] in1 = {1, 2, 4};
        Integer[] in2 = {1, 3, 4};

        MergeTwoSortedLists_21 mergeTwoSortedLists = new MergeTwoSortedLists_21();
        ListNode listNode1 = mergeTwoSortedLists.arrayToListNode(in1);
        ListNode listNode2 = mergeTwoSortedLists.arrayToListNode(in2);
        ListNode result = mergeTwoSortedLists.mergeTwoLists(listNode1, listNode2);
        mergeTwoSortedLists.traverse(result);
    }
}
