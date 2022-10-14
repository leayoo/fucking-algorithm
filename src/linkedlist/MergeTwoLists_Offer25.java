package linkedlist;

public class MergeTwoLists_Offer25 {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode();
        ListNode q = dummy;
        dummy.next = q;
        ListNode p1 = l1, p2 = l2;
        if (l1 == null) return l2;
        if (l2 == null) return l1;
        while (p1 != null && p2 != null) {
            if (p1.val >= p2.val) {
                q.next = p2;
                p2 = p2.next;
                q = q.next;
            } else {
                q.next = p1;
                p1 = p1.next;
                q = q.next;
            }
        }
        while (p2 != null) {
            q.next = p2;
            p2 = p2.next;
            q = q.next;
        }
        while (p1 != null) {
            q.next = p1;
            p1 = p1.next;
            q = q.next;
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        Integer[] l1 = {1, 2, 4};
        Integer[] l2 = {1, 3, 4};
        LinkedListUtils linkedListUtils = new LinkedListUtils();
        ListNode listnode1 = linkedListUtils.arrayToListNode(l1);
        ListNode listNode2 = linkedListUtils.arrayToListNode(l2);
        MergeTwoLists_Offer25 mergeTwoLists_offer25 = new MergeTwoLists_Offer25();
        ListNode result = mergeTwoLists_offer25.mergeTwoLists(listnode1, listNode2);
        linkedListUtils.traverse(result);
    }
}
