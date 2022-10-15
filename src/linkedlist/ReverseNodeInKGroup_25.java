package linkedlist;

class ReverseNodeInKGroup_25 {
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null) return null;
        ListNode a, b;
        a = b = head;
        // base case
        for (int i = 0; i < k; i++) {
            // 不足 k 个，不需要反转
            if (b == null) return head;
            b = b.next;
        }
        // 反转前 k 个元素
        ListNode newHead = reverseAtoB(a, b);
        // 递归反转后续链表并连接起来
        // 因为 b 处是 ) 的
        a.next = reverseKGroup(b, k);
        return newHead;
    }

    // 反转以 a 为头结点的链表
    ListNode reverse(ListNode a) {
        ListNode pre, cur, nxt;
        pre = null;
        cur = a;
        nxt = a;
        while (cur != null) {
            nxt = cur.next;
            // 逐个结点反转
            cur.next = pre;
            // 更新 cur 指针位置
            pre = cur;
            cur = nxt;
        }
        // 返回反转后的头结点
        return pre;
    }

    // 「反转以 a 为头结点的链表」其实就是「反转 a 到 null 之间的结点」
    // 那么「反转 a 到 b 之间的结点」，只要更改函数签名，并把上面的代码中 null 改成 b 即可
    // [a, b)
    ListNode reverseAtoB(ListNode a, ListNode b) {
        ListNode pre, cur, nxt;
        pre = null;
        cur = a;
        nxt = a;
        // while 的终止条件改一下就行了
        while (cur != b) {
            nxt = cur.next;
            cur.next = pre;
            pre = cur;
            cur = nxt;
        }
        // 返回反转后的头结点
        return pre;
    }

    public static void main(String[] args) {
        Integer[] test = {1};
        LinkedListUtils linkedListUtils = new LinkedListUtils();
        ListNode listNode = linkedListUtils.arrayToListNode(test);

        ReverseNodeInKGroup_25 reverseNodeInKGroup_25 = new ReverseNodeInKGroup_25();
        ListNode result = reverseNodeInKGroup_25.reverseKGroup(listNode, 2);
        linkedListUtils.traverse(result);
    }
}
