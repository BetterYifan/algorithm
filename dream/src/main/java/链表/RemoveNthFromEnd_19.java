package 链表;

import java.util.List;

/**
 * 给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。
 */
public class RemoveNthFromEnd_19 {
    /**
     * 快慢指针
     *
     * @param head
     * @param n
     * @return
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode virtual = new ListNode(0, head);

        ListNode slow = virtual;
        ListNode quick = virtual;

        //先移动快指针
        for (int i = 0; i < n; i++) {
            quick = quick.next;
        }

        // 同时移动
        while (quick.next != null) {
            quick = quick.next;
            slow = slow.next;
        }

        ListNode tmp = slow.next.next;
        slow.next = tmp;

        return virtual.next;
    }
}
