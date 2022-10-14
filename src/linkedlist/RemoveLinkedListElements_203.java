package linkedlist;

import java.util.ArrayList;
import java.util.Collections;

class RemoveLinkedListElements_203 {
    public ListNode removeElements(ListNode head, int val) {
        // 虚拟头结点
        ListNode dummy = new ListNode(-1);
        ListNode q = dummy;
        ListNode p = head;
        // 遍历链表
        while (p != null) {
            // 相同，则不加入新链表
            if (p.val == val){
                p = p.next;
                q.next = null;
            } else {
                q.next = p;
                q = q.next;
                p = p.next;
            }
        }
        return dummy.next;
    }



    public static void main(String[] args) {
        Integer[] head = {7,7,7,7};
        LinkedListUtils linkedListUtils = new LinkedListUtils();
        ListNode listNode = linkedListUtils.arrayToListNode(head);

        RemoveLinkedListElements_203 removeLinkedListElements_203 = new RemoveLinkedListElements_203();
        ListNode result = removeLinkedListElements_203.removeElements(listNode, 7);
        linkedListUtils.traverse(result);
    }
}
