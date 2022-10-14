package linkedlist;

public class GetIntersectionNode_Offer52 {
    ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode p = headA;
        ListNode q = headB;

        while (p != null && q != null) {
            // 要先进行 ！= 判断
            if (p != q) {
                q = q.next;
                p = p.next;
            } else {
                return p;
            }
            if (p == null && q != null) p = headB;
            if (q == null && p != null) q = headA;
        }
        return null;
    }

    public static void main(String[] args) {
        Integer[] l1 = {4,1,8,4,5};
        Integer[] l2 = {5,0,1,8,4,5};
        LinkedListUtils linkedListUtils = new LinkedListUtils();
        ListNode listNode1 = linkedListUtils.arrayToListNode(l1);
        ListNode listNode2 = linkedListUtils.arrayToListNode(l2);
        GetIntersectionNode_Offer52 getIntersectionNode_offer52 = new GetIntersectionNode_Offer52();
        getIntersectionNode_offer52.getIntersectionNode(listNode1, listNode2);
    }
}
