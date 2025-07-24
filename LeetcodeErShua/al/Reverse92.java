/*
 * -----------------------------------------------------------------------------
 * © Swisslog AG
 * Swisslog is not liable for any usage of this source code that is not agreed on between Swisslog and the other party.
 * The mandatory legal liability remains unaffected.
 * -----------------------------------------------------------------------------
 */
package al;

import java.util.ArrayList;
import java.util.List;

public class Reverse92 {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (head == null || left == right) return head;

        ListNode current = head;

        ArrayList<ListNode> list = new ArrayList<>();

        while (current != null) {
            list.add(current);
            current = current.next;
        }

        int realLeft = left - 1;
        int realRight = right - 1;



        for(int i = realRight; i > realLeft; i--) {
            current=list.get(i);
            current.next=list.get(i-1);
        }

        if (realLeft == 0) {
            head=list.get(realRight);
        }else
        {
            list.get(realLeft-1).next=list.get(realRight);
        }

        if(realRight<list.size()-1)
        {
            list.get(realLeft).next=list.get(realRight+1);
        }else
        {
            list.get(realLeft).next=null;
        }
        return head;
    }
}
