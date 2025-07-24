/*
 * -----------------------------------------------------------------------------
 * © Swisslog AG
 * Swisslog is not liable for any usage of this source code that is not agreed on between Swisslog and the other party.
 * The mandatory legal liability remains unaffected.
 * -----------------------------------------------------------------------------
 */
package al;

import java.util.HashSet;

public class Ring141 {
    public boolean hasCycle(ListNode head) {
        HashSet<ListNode> set = new HashSet<ListNode>();
        if (head == null || head.next == null) return false;
        ListNode pointer = head;
        while (pointer!= null) {
            if (set.contains(pointer))  {
                return true;
            }else
            {
                set.add(pointer);
            }
            pointer = pointer.next;
        }
        return false;
    }
}
