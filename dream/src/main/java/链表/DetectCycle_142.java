package 链表;

/**
 * 给定一个链表的头节点  head ，返回链表开始入环的第一个节点。 如果链表无环，则返回 null。
 */
public class DetectCycle_142 {

    // 快慢指针，慢指针结束了，快指针还未结束
    public ListNode detectCycle(ListNode head) {
        ListNode slow = head;
        ListNode quick = head;

        while (quick != null && quick.next != null) {
            slow = slow.next;
            quick = quick.next.next;

            // 此时在环内相遇
            if (slow == quick) {
                ListNode index = head;
                ListNode index2 = slow;

                //相遇即入口
                while (index != index2) {
                    index = index.next;
                    index2 = index2.next;
                }
                return index;
            }
        }
        return null;
    }
}
