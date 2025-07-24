/*
 * -----------------------------------------------------------------------------
 * © Swisslog AG
 * Swisslog is not liable for any usage of this source code that is not agreed on between Swisslog and the other party.
 * The mandatory legal liability remains unaffected.
 * -----------------------------------------------------------------------------
 */
package al;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Delete82 {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) return head;
        HashMap<Integer,Integer> map = new HashMap<>();
        ListNode cur = head;
        while(cur != null) {
            map.put(cur.val, map.getOrDefault(cur.val, 0) + 1);
            cur = cur.next;
        }
        ArrayList<ListNode> list = new ArrayList<>();
        cur = head;
        while(cur != null) {
            if(map.get(cur.val) == 1) {
                list.add(cur);
            }
            cur = cur.next;
        }
        if(list.size()==0)
        {
            return null;
        }
        head=list.get(0);
        for(int i=0;i<list.size()-1;i++)
        {
            ListNode temp = list.get(i);
            temp.next = list.get(i+1);
        }
        list.get(list.size()-1).next = null;
        return head;
    }
}
