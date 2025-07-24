/*
 * -----------------------------------------------------------------------------
 * © Swisslog AG
 * Swisslog is not liable for any usage of this source code that is not agreed on between Swisslog and the other party.
 * The mandatory legal liability remains unaffected.
 * -----------------------------------------------------------------------------
 */
package al;

import java.sql.ClientInfoStatus;
import java.util.ArrayList;
import java.util.List;

public class Delete19 {
    public static void main(String[] args) {
        ListNode A=new ListNode(1);
        removeNthFromEnd(A,1);
    }
    public static ListNode removeNthFromEnd(ListNode head, int n) {
        ArrayList<ListNode> nodes = new ArrayList<>();
        ListNode curr = head;

        while (curr != null) {
            nodes.add(curr);
            curr = curr.next;
        }

        int index=nodes.size()-n;
        int deleteBefore=index-1;
        if(deleteBefore >= 0)
        {
            nodes.get(deleteBefore).next=nodes.get(index).next;
        }else
        {
            head=nodes.get(index).next;
        }



        return head;
    }
}
