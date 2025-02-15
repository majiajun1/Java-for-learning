import java.util.ArrayList;

public class RotateLink61 {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        rotateRight(head,1);
    }
     public static ListNode rotateRight(ListNode head, int k) {
        ArrayList<ListNode> list = new ArrayList<>();
        if(head == null || k==0)
        {
            return head;
        }
        ListNode curr = head;
        while (curr != null) {
            list.add(curr);
            curr = curr.next;
        }
        k = k % list.size();
        if(k == 0)
        {
            return head;
        }
        ListNode newHead = list.get(list.size()-k);
        ListNode back = list.get(list.size()-1);
        back.next = head;
        ListNode cur=list.get(list.size()-k-1);
        cur.next = null;
        return newHead;

    }
}
