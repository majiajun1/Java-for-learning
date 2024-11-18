public class FanZhuan206andMaxNuanSheng2130 {
    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(3);
        l1.next.next.next = new ListNode(4);
        l1.next.next.next.next = new ListNode(5);
        ListNode ans=reverseList(l1);
        printList(ans);
    }
     private static void printList(ListNode node) {
        while (node != null) {
            System.out.print(node.val + " ");
            node = node.next;
        }
        System.out.println();
    }

    public static ListNode reverseList(ListNode head) {
        if(head == null || head.next == null) return head;
        ListNode temp = head;
        ListNode temp2=head.next;
        ListNode temp3=temp2.next;
        head.next=null;
        while (temp2!= null) {
            temp2.next=temp;
            temp=temp2;
            temp2=temp3;
            if(temp3!=null)
            {
                temp3=temp3.next;
            }

        }
        return temp;

    }

    public static int pairSum(ListNode head) {

    }
}
