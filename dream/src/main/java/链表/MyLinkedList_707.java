package 链表;

public class MyLinkedList_707 {

    /**
     * 注意new的时候默认添加一个节点
     * 在判断边界的时候，是[0, size]，即<0 ｜｜ >= size
     */
    private int size;

    private ListNode head;

    public MyLinkedList_707() {
        size = 0;
        head = new ListNode(0);
    }

    // index从0开始
    public int get(int index) {
        if (index < 0 || index >= size) {
            return -1;
        }
        ListNode cur = head;
        for (int i = 0; i <= index; i++) {
            cur = cur.next;
        }
        return cur.val;
    }

    public void addAtHead(int val) {
        addAtIndex(0, val);
    }

    public void addAtTail(int val) {
        addAtIndex(size, val);
    }

    public void addAtIndex(int index, int val) {
        if (index > size) {
            return;
        }
        if (index < 0) {
            index = 0;
        }
        ListNode prev = head;
        for (int i = 0; i < index; i++) {
            prev = prev.next;
        }
        ListNode add = new ListNode(val);
        add.next = prev.next;
        prev.next = add;
        size++;
    }

    public void deleteAtIndex(int index) {
        if (index < 0 || index >= size) {
            return;
        }
        size--;
        if (index == 0){
            head = head.next;
            return;
        }

        ListNode prev = head;
        for (int i = 0; i < index; i++) {
            prev = prev.next;
        }
        ListNode next = prev.next;
        prev.next = next.next;
    }
}
