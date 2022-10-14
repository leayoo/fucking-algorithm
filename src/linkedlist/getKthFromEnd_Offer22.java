package linkedlist;

class getKthFromEnd_Offer22 {
    public ListNode getKthFromEnd(ListNode head, int k){
        ListNode p = head;
        ListNode q = head;
        while (k!=0){
            p = p.next;
            k--;
        }
        while (p!=null){
            p = p.next;
            q = q.next;
        }
        return q;
    }
}
