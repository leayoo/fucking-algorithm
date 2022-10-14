package linkedlist;

public class ListNode {
    int val;
    ListNode next;
    // 初始化
    ListNode() {}
    ListNode(int val) {
        this.val = val;
    }
    ListNode(int val, ListNode next){
        this.val = val;
        this.next = next;
    }
}
