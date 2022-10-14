package linkedlist;

import java.util.List;

class IntersectionOfTwoLinkedLists_160 {
    // 最简单版本
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        // headA 和 headB 向后遍历
        ListNode p1 = headA;
        ListNode p2 = headB;
        while (p1 != null && p2 != null) {
            p1 = p1.next;
            p2 = p2.next;
        }
        // 如果 headA 走向了终点或 headB 走向了终点，则开始遍历另一链表
        if (p1 == null) {
            p1 = headB;
        }
        if (p2 == null) {
            p2 = headA;
        }
        while (p1 != null && p2 != null) {
            p1 = p1.next;
            p2 = p2.next;
        }
        if (p1 == null) {
            p1 = headB;
        }
        if (p2 == null) {
            p2 = headA;
        }
        while (p1 != p2) {
            p1 = p1.next;
            p2 = p2.next;
        }
        return p1;
    }

    // 上面写的太不优雅了
    public ListNode getIntersectionNode2(ListNode headA, ListNode headB) {
        ListNode p1 = headA, p2 = headB;
        while (p1 != p2) {
            // p1 走一步，如果走到 A 链表末尾，转到 B 链表
            if (p1 == null) p1 = headB;
            else p1 = p1.next;
            // p2 走一步，如果走到 B 链表末尾，转到 A 链表
            if (p2 == null) p2 = headA;
            else p2 = p2.next;
        }
        return p1;
    }
}
