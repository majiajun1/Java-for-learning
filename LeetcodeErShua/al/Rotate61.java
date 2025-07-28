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

public class Rotate61 {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        rotateRight(head,2000000000);
    }
    public static ListNode rotateRight(ListNode head, int k) {
        ArrayList<ListNode> nodes = new ArrayList<>();
        ListNode curr = head;
        while (curr != null) {
            nodes.add(curr);
            curr = curr.next;
        }
        if (k == 0||nodes.size()==0)
        {
            return head;
        }
        k %= nodes.size();
        if (k == 0) return head;
        nodes.get(nodes.size()-1).next = head;
        nodes.get(nodes.size()-1-k).next = null;

        head=nodes.get(nodes.size()-k);


        return head;
    }
}
