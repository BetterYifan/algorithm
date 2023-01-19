package 链表;

public class ReverseList_206 {
    public ListNode reverseList(ListNode head) {
        return reverseNode(head, null);
    }

    public ListNode reverseNode(ListNode cur, ListNode prev) {
        if (cur == null) {
            return prev;
        }
        ListNode tmp = cur.next;
        cur.next = prev;
        return reverseNode(tmp, cur);
    }
}
