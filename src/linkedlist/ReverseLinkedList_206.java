package linkedlist;

class ReverseLinkedList_206 {
    /*
    反转整个链表
     */
    // 方法一，反转链表，头插法插入即可
    public ListNode reverseList(ListNode head) {
        // 虚拟头结点
        ListNode dummy = new ListNode();

        ListNode temp = new ListNode();
        ListNode p = head;
        // 遍历链表
        while (p != null) {
            temp = p;
            p = p.next;
            // 头插法插入
            temp.next = dummy.next;
            dummy.next = temp;
        }
        return dummy.next;
    }

    // 方法二，递归
    public ListNode reverseList2(ListNode head) {
        // base case
        if (head == null || head.next == null) {
            return head;
        }
        // 递归
        ListNode last = reverseList2(head.next);
        head.next.next = head;
        head.next = null;
        return last;
    }

    /*
    反转链表前 N 个节点
     */
    ListNode successor = null;

    ListNode reverseN(ListNode head, int n) {
        // base case 变为 n == 1，反转一个元素，就是它本身，同时要记录后驱结点
        if (n == 1) {
            // 记录第 n + 1 个结点
            successor = head.next;
            return head;
        }
        // 以 head.next 为起点，需要反转前 n - 1 个结点
        ListNode last = reverseN(head.next, n - 1);

        head.next.next = head;
        // 让反转之后的 head 结点和后面的结点连接
        head.next = successor;
        return last;
    }

    /*
    反转链表的一部分
     */
    ListNode reverseBetween(ListNode head, int m, int n) {
        // base case
        if (m == 1) {
            return reverseN(head, n);
        }
        // 前进到反转的起点触发 base case
        head.next = reverseBetween(head.next, m - 1, n - 1);
        return head;
    }

    public static void main(String[] args) {
        Integer[] head = {1, 2, 3, 4, 5};
        LinkedListUtils linkedListUtils = new LinkedListUtils();
        ListNode listNode = linkedListUtils.arrayToListNode(head);

        ReverseLinkedList_206 reverseLinkedList_206 = new ReverseLinkedList_206();
        ListNode result = reverseLinkedList_206.reverseList2(listNode);
        linkedListUtils.traverse(result);
    }
}
