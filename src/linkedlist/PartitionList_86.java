package linkedlist;

/**
 * @author: Leeyoa
 * @description:
 * @date: 2023/7/15 23:45
 */
public class PartitionList_86 {
    public ListNode partition(ListNode head, int x) {
        ListNode p = head;

        ListNode dummy1 = new ListNode();
        ListNode dummy2 = new ListNode();
        ListNode p1 = dummy1;
        ListNode p2 = dummy2;

        if (p == null){
            return null;
        }

        while (p != null) {
            if (p.val < x){
                p1.next = p;
                p1 = p1.next;
            } else {
                p2.next = p;
                p2 = p2.next;
            }
            p = p.next;
        }

        // 放较大值的链表最后需要断开，防止形成环
        p2.next = null;
        p1.next = dummy2.next;
        return dummy1.next;
    }

//    public ListNode partition(ListNode head, int x) {
//        ListNode dummy1=new ListNode(0),dummy2=new ListNode(0);//哨兵，分别是小于链和大于等于链
//        ListNode cur,p1,p2,next;
//        for(cur=head,p1=dummy1,p2=dummy2;cur!=null;cur=next){
//            next=cur.next;
//            cur.next=null;//需要断联，不然会形成环
//            if(cur.val<x) {
//                p1.next=cur;
//                p1=p1.next;
//            }else {
//                p2.next=cur;
//                p2=p2.next;
//            }
//        }
//        if(p1==dummy1) return dummy2.next;//说明小于链没有东西，直接返回大于链
//        p1.next=dummy2.next;//小于链尾连大于链头
//        return dummy1.next;
//    }
}
