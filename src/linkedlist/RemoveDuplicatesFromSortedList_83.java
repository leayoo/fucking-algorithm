package linkedlist;

import java.util.*;

public class RemoveDuplicatesFromSortedList_83 {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode p = head;
        // 思路：如果 p 的 next 与 p 相同，则 p 指向 p.next.next; 否则 p 下移
        if (p == null) {
            return head;
        }
        // 迭代遍历单链表
        while (p.next != null) {
            if (p.next.val == p.val) {
                // 存在 p.next.next 为空的情况，为空时，p 指向 null
                if (p.next.next != null) {
                    p.next = p.next.next;
                } else {
                    p.next = null;
                }
            } else {
                p = p.next;
            }
        }
        return head;
    }

    // 数组转化为链表
    public ListNode arrayToListNode(Integer[] in){
        ArrayList<Integer> list = new ArrayList<Integer>();
        Collections.addAll(list, in);

        // 构造 ListNode 组成的链表
        ListNode dummy = new ListNode();
        ListNode head = dummy;
        for (int i=0;i<list.size();i++){
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
        RemoveDuplicatesFromSortedList_83 removeDuplicatesFromSortedList = new RemoveDuplicatesFromSortedList_83();
        Integer[] in = {1,1,2};
        ListNode listNode = removeDuplicatesFromSortedList.arrayToListNode(in);
        removeDuplicatesFromSortedList.deleteDuplicates(listNode);
        removeDuplicatesFromSortedList.traverse(listNode);
    }
}
