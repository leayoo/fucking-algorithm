package linkedlist;

/**
 * @author: Leeyoa
 * @description:
 * @date: 2023/7/14 10:37
 */
public class MergeTwoSortedList_21_2 {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        // 虚拟头节点
        ListNode dummy = new ListNode();
        // 指针 p, 指向 p
        ListNode p = dummy;

        ListNode p1 = list1;
        ListNode p2 = list2;

        // base case
        while (p1 != null && p2 != null) {
            // 比较大小
            if (p1.val >= p2.val) {
                p.next = p2;
                p = p2;
                p2 = p2.next;
            } else {
                p.next = p1;
                p = p1;
                p1 = p1.next;
            }
        }
        // 剩下的结点接入
        while (p1 != null) {
            p.next = p1;
            p = p1;
            p1 = p1.next;
        }

        while (p2 != null) {
            p.next = p2;
            p = p2;
            p2 = p2.next;
        }

        return dummy.next;
    }
}
