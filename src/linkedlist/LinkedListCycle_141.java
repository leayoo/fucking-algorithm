package linkedlist;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class LinkedListCycle_141 {
    // 如何避免一次走两步，但是不会爆空指针错误呢
    public boolean hasCycle(ListNode head) {
//        ListNode fast = head;
//        ListNode slow = head;
//        // 不存在结点时
//        if (head == null) return false;
//        // 没有环，且只存在 1~2 个结点时
//        if (fast.next==null || fast.next.next == null) {
//            return false;
//        }
//        // 存在环或存在 3 个及其以上结点时的判断
//        fast = fast.next.next;
//        slow = slow.next;
//        // 遍历链表
//        while (fast != null) {
//            if (fast == slow){
//                return true;
//            }
//            fast = fast.next.next;
//            slow = slow.next;
//        }
//        // fast 取到空值，则不存在环
//        return false;

        // 如何避免空指针报错
        // 只要取到空，则不存在环
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null) {
            // fast 的向后取到空值
            if (fast.next == null || fast.next.next == null) {
                return false;
            }
            fast = fast.next.next;
            slow = slow.next;
            // fast 未取到空值，和slow对比进行判断
            if (fast == slow) {
                return true;
            }
        }
        // fast 取到空指针
        return false;
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

    public static void main(String[] args) {
        Integer[] in = {-21, 10, 17, 8, 4, 26, 5, 35, 33, -7, -16, 27, -12, 6, 29, -12, 5, 9, 20, 14, 14, 2, 13, -24, 21, 23, -21, 5};
        LinkedListCycle_141 linkedListCycle_141 = new LinkedListCycle_141();
        ListNode listNode = linkedListCycle_141.arrayToListNode(in);
        linkedListCycle_141.hasCycle(listNode);
        System.out.println(linkedListCycle_141.hasCycle(listNode));
    }
}
