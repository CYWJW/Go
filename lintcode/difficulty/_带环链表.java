package simple;

public class _带环链表 {
    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
            this.next = null;
        }
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode next = new ListNode(-1);
        head.next = next;
        ListNode node = detectCycle(head);
        System.out.println(node);


    }

    public static ListNode detectCycle(ListNode head) {
        // write your code here
        if (head == null || head.next == null) {
            return null;
        }
        int num = 1;

        ListNode sortNode = head;
        ListNode longNode = head;
        try {
            sortNode = sortNode.next;
            longNode = longNode.next.next;
            while (sortNode != longNode) {
                sortNode = sortNode.next;
                longNode = longNode.next.next;
                num++;
            }
        } catch (Exception e) {
            return null;
        }

        sortNode = head;
        for (int i = 0; i < num; i++) {
            sortNode = sortNode.next;
        }
        while (head != sortNode) {
            head = head.next;
            sortNode = sortNode.next;
        }
        return head;
    }

}
