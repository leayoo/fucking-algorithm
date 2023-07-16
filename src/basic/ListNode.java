package basic;

/**
 * @author: Leeyoa
 * @description:
 * @date: 2023/7/14 10:33
 */

// Definition for singly-linked list
public class ListNode{
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) {
        this.val = val;
    }
    ListNode(int val, ListNode next){
        this.val = val;
        this.next = next;
    }
}