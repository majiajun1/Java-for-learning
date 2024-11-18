public class JiOu328 {
    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(3);
        l1.next.next.next = new ListNode(4);
        l1.next.next.next.next = new ListNode(5);
        ListNode l2 = oddEvenList(l1);
        printList(l2);

    }

    private static void printList(ListNode node) {
        while (node != null) {
            System.out.print(node.val + " ");
            node = node.next;
        }
        System.out.println();
    }

     public static ListNode oddEvenList(ListNode head) { //三元法
        if(head == null || head.next == null) return head;


        ListNode originhead=head;
        ListNode first = head;
        ListNode second = first.next;


        ListNode firstsecond=head.next;

       while (first.next!=null&& second.next!= null) {

           first.next = second.next;
           second.next = second.next.next;
           first=first.next;
           second = second.next;


       }

       first.next = firstsecond;
        return originhead;

    }
}
