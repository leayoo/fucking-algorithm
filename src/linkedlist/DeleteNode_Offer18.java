package linkedlist;

public class DeleteNode_Offer18 {
    public ListNode deleteNode(ListNode head, int val){
        ListNode dummy = new ListNode();
        dummy.next = head;

        ListNode p = head;
        ListNode q = dummy;

        while (p != null){
            if (p.val == val){
                q.next = p.next;
                return dummy.next;
            }
            p = p.next;
            q = q.next;
        }
        return head;
    }

    public static void main(String[] args) {
        Integer[] test = {-3,5,-99};
        LinkedListUtils linkedListUtils = new LinkedListUtils();
        ListNode listNode = linkedListUtils.arrayToListNode(test);

        DeleteNode_Offer18 deleteNode_offer18 = new DeleteNode_Offer18();
        ListNode result = deleteNode_offer18.deleteNode(listNode, -3);
        linkedListUtils.traverse(result);
    }
}
