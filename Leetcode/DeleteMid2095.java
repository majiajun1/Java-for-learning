import java.sql.ClientInfoStatus;

public class DeleteMid2095 {
    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(3);
        l1.next.next.next = new ListNode(4);
        ListNode ans=deleteMiddle(l1);
        printList(ans);

    }
     private static void printList(ListNode node) {
        while (node != null) {
            System.out.print(node.val + " ");
            node = node.next;
        }
        System.out.println();
    }

    public static ListNode deleteMiddle(ListNode head) {
            ListNode starttemp=head;

            int count=0;
            while(head!=null){
                count++;
                head=head.next;
            }
        if(count==1)
        {
            return null;
        }
            count=count/2;
            head=starttemp;
            int i=0;
            while(i!=count-1&&head.next!=null)
            {
                i++;
                starttemp=starttemp.next;

            }
            starttemp.next=starttemp.next.next;
            return head;

    }
}
