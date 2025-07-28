/*
 * -----------------------------------------------------------------------------
 * © Swisslog AG
 * Swisslog is not liable for any usage of this source code that is not agreed on between Swisslog and the other party.
 * The mandatory legal liability remains unaffected.
 * -----------------------------------------------------------------------------
 */
package al;

import java.util.Scanner;

public class FenGe86 {
    public ListNode partition(ListNode head, int x) {
        ListNode l1head = new ListNode(-100000);
        ListNode l2head = new ListNode(-100000);
        ListNode curr = head;
        ListNode l1curr = l1head;
        ListNode l2curr = l2head;
        while (curr != null) {
            if (curr.val < x) {
                l1curr.next = curr;
                l1curr = l1curr.next;
            }else
            {
                l2curr.next = curr;
                l2curr = l2curr.next;
            }
            curr = curr.next;
        }
        l2curr.next = null;
        l1curr.next = l2head.next;
        return l1head.next;
    }
}
