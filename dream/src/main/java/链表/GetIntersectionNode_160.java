package 链表;

/**
 * 给你两个单链表的头节点 headA 和 headB ，请你找出并返回两个单链表相交的起始节点。如果两个链表不存在相交节点，返回 null 。
 */
public class GetIntersectionNode_160 {
    // 长的链表先往后走
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode curA = headA;
        ListNode curB = headB;

        int lenA = 1, lenB = 1;

        while (curA.next != null) {
            curA = curA.next;
            lenA++;
        }
        while (curB.next != null) {
            curB = curB.next;
            lenB++;
        }

        curA = headA;
        curB = headB;

        if (lenB > lenA) {
            int gap = lenB - lenA;
            while (gap > 0) {
                curB = curB.next;
                gap--;
            }
        } else {
            int gap = lenA - lenB;
            while (gap > 0) {
                curA = curA.next;
                gap--;
            }
        }

        while (curA != null) {
            if (curA == curB) {
                return curA;
            }
            curA = curA.next;
            curB = curB.next;
        }

        return null;
    }

    public static void main(String[] args) {
        ListNode head2 = new ListNode(1);
        ListNode head1 = new ListNode(2, head2);

        ListNode cur = head1;
        cur = cur.next;

        System.out.println(cur.val);
        System.out.println(cur.hashCode());
        System.out.println(head1.val);
        System.out.println(head1.hashCode());
    }
}
