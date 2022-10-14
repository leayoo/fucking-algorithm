package linkedlist;

public class ReverseList_Offer24 {
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode last = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return last;
    }

    public static void main(String[] args) {
        LinkedListUtils linkedListUtils = new LinkedListUtils();
        ListNode listNode = linkedListUtils.arrayToListNode(new Integer[]{1, 2, 3, 4, 5});
        ReverseList_Offer24 reverseList_offer24 = new ReverseList_Offer24();
        ListNode result = reverseList_offer24.reverseList(listNode);
        linkedListUtils.traverse(result);

    }
}
