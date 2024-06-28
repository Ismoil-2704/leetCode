public class Problem24 {
    public static void main(String[] args) {
        ListNode head = new ListNode(2, new ListNode(1, new ListNode(4,new ListNode(3))));
        ListNode node = head;
        ListNode next = head != null && head.next != null ? head.next : head;
        ListNode prev = null;
        while (node != null) {
            if (node.next != null) {
                if (prev != null) {
                    prev.next = node.next;
                }
                prev = node;
                ListNode list = node.next.next;
                node.next.next = node;
                node.next = list;
                node = list;
            } else {
                node = null;
            }
        }
        System.out.println(next);
    }
}
