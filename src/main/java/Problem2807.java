public class Problem2807 {
    public static void main(String[] args) {
        ListNode head = new ListNode(18, new ListNode(6,new ListNode(10,new ListNode(3))));
        ListNode seconds = head;
        int divisor = 1000;
        while (head != null){
            int val = head.val;
            if (head.next != null){
                int val2 = head.next.val;
                if (val % divisor == 0 && val2 % divisor == 0){
                    ListNode next = head.next;
                    head.next = new ListNode(divisor,next);
                    head = head.next.next;
                    divisor = 1000;
                }else {
                    divisor --;
                }
            }else {
                head = null;
            }
        }
        System.out.println(seconds);
    }

}
