package linkedlist;

import java.util.ArrayList;
import java.util.Collections;

public class LinkedListUtils {
    // 数组转化为链表
    public ListNode arrayToListNode(Integer[] in){
        ArrayList<Integer> list = new ArrayList<Integer>();
        Collections.addAll(list, in);

        // 构造 ListNode 组成的链表
        ListNode dummy = new ListNode();
        ListNode head = dummy;
        for (int i=0;i<list.size();i++){
            ListNode p = new ListNode(list.get(i));
            head.next = p;
            head = head.next;
        }
        return dummy.next;
    }

    // 遍历链表
    public void traverse(ListNode listNode){
        ArrayList result = new ArrayList();
        // 遍历链表
        for (ListNode p = listNode; p != null; p = p.next) {
            result.add(p.val);
        }
        System.out.println(result);
    }
}
