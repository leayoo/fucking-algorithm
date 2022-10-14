package linkedlist;

import java.util.List;

public class PalindromeLinkedList_234 {
    // 最简单的方法: 把原始链表反转存入一条新的链表，然后反转整条链表后，比较两条链表
    public boolean isPalindrome(ListNode head) {
        // 把原始链表反转存入一条新的链表
        ListNode dummy = new ListNode();
        ListNode last = dummy;
        ListNode p = head;
        while (p != null) {
            ListNode listNode = new ListNode(p.val);
            last.next = listNode;
            last = last.next;
            p = p.next;
        }

        ListNode traverse = traverse(head);
        ListNode q = dummy.next;
        while (traverse != null) {
            if (q.val != traverse.val) {
                return false;
            }
            q = q.next;
            traverse = traverse.next;
        }
        return true;
    }

    // 反转链表
    public ListNode traverse(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode last = traverse(head.next);
        head.next.next = head;
        head.next = null;

        return last;
    }

    // 方法 2 链表兼具递归结构，也可以有前序遍历和后序遍历
    // 如果我想正序打印链表中的 val 值，可以在前序遍历位置写代码；
    // 反之，如果想倒序遍历链表，就可以在后序遍历位置操作：
    // 通过递归和后序遍历，模仿双指针实现回文判断的功能
    ListNode left;
    boolean isPalindrome2(ListNode head) {
        left = head;
        return traverse2(head);
    }

    boolean traverse2(ListNode right){
        // base case
        if (right == null)
            return true;

        boolean res = traverse2(right.next);
        // 后序遍历代码
        res = res && (right.val == left.val);
        left = left.next;
        return res;
    }

    // 方法三，优化空间复杂度
    // 1、先通过 双指针技巧 中的快慢指针来找到链表的中点：
    // 2、如果fast指针没有指向null，说明链表长度为奇数，slow还要再前进一步：
    boolean isPalindrome3(ListNode head){
        ListNode slow, fast;
        slow = fast = head;
        while (fast != null && fast.next !=null){
            slow = slow.next;
            fast = fast.next.next;
        }

        if (fast!=null){
            slow = slow.next;
        }

        ListNode left = head;
        ListNode right = reverse3(slow);
        while (right!=null){
            if (left.val != right.val)
                return false;
            left = left.next;
            right = right.next;
        }
        return true;
    }
    // 这个反转写的还挺优雅的
    ListNode reverse3(ListNode head){
        ListNode pre = null, cur = head;
        while(cur != null) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }


    public static void main(String[] args) {
        Integer[] in = {1, 2, 2, 1};
        LinkedListUtils linkedListUtils = new LinkedListUtils();
        ListNode listNode = linkedListUtils.arrayToListNode(in);
        PalindromeLinkedList_234 palindromeLinkedList_234 = new PalindromeLinkedList_234();
        boolean result = palindromeLinkedList_234.isPalindrome3(listNode);
        System.out.println(result);
    }
}
