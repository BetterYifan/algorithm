package 链表;

public class SwapPairs_24 {
    public ListNode swapPairs(ListNode head) {
        if (head == null) {
            return null;
        }

        ListNode virtual = new ListNode(0, head);
        ListNode dumpNode = virtual;

        while (dumpNode.next != null && dumpNode.next.next != null) {
            // 链表的临时节点有点晕，要注意好保留哪些临时节点
            ListNode tmp = dumpNode.next;
            ListNode tmp2 = dumpNode.next.next.next;

            dumpNode.next = dumpNode.next.next;
            dumpNode.next.next = tmp;
            dumpNode.next.next.next = tmp2;

            dumpNode = dumpNode.next.next;
        }

        return virtual.next;
    }

    public static void main(String[] args) {
        SwapPairs_24 swapPairs_24 = new SwapPairs_24();

        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);

        swapPairs_24.swapPairs(head);
    }
}
