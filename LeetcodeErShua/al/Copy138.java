/*
 * -----------------------------------------------------------------------------
 * © Swisslog AG
 * Swisslog is not liable for any usage of this source code that is not agreed on between Swisslog and the other party.
 * The mandatory legal liability remains unaffected.
 * -----------------------------------------------------------------------------
 */
package al;



import java.util.HashMap;

public class Copy138 {
    public Node copyRandomList(Node head) {
        HashMap<Node, Node> map = new HashMap<Node, Node>();
        Node cur = head;
        while (cur != null) {
            Node newNode = new Node(cur.val);
            map.put(cur, newNode);
            cur = cur.next;
        }
        cur=head;
        while (cur != null) {
            Node cuenew = map.get(cur);
            cuenew.next = map.get(cur.next);
            cuenew.random = map.get(cur.random);
            cur=cur.next;
        }
        return map.get(head);
    }
}
