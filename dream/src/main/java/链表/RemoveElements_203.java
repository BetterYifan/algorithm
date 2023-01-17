package 链表;

/**
 * 给你一个链表的头节点 head 和一个整数 val ，请你删除链表中所有满足 Node.val == val 的节点，并返回 新的头节点 。
 */
public class RemoveElements_203 {

    public ListNode removeElements(ListNode head, int val) {
        // 移除头部节点，保证第一个元素不为val
        while (head != null && head.val == val) {
            head = head.next;
        }

        // 链表的值全为val
        if (head == null) {
            return null;
        }

        ListNode cur = head;
        ListNode next = head.next;

        while (next != null) {
            if (next.val == val) {
                cur.next = next.next;
            } else {
                cur = next;
            }
            next = next.next;
        }

        return head;
    }
}
