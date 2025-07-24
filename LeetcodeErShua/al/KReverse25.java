/*
 * -----------------------------------------------------------------------------
 * © Swisslog AG
 * Swisslog is not liable for any usage of this source code that is not agreed on between Swisslog and the other party.
 * The mandatory legal liability remains unaffected.
 * -----------------------------------------------------------------------------
 */
package al;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class KReverse25 {
    public static void main(String[] args) {
        ListNode a = new ListNode(1);
        a.next = new ListNode(2);

        reverseKGroup(a,2);
    }
    public static ListNode reverseKGroup(ListNode head, int k) {
        ArrayList<ListNode> list = new ArrayList<>();

        ListNode curr = head;
        while (curr != null) {
            list.add(curr);
            curr = curr.next;
        }
        if(k>list.size())
        {
            k = k % list.size();
        }

        if (list.size()<=1) {
            return head;
        }
        int left=0;
        int right=k;
        while(right<=list.size()){
           /* for(int i = right; i > left; i--) {
              ListNode current=list.get(i);
              current.next=list.get(i-1);
            }*/
            Collections.reverse(list.subList(left,right));
            left=left+k;
            right=left+k;
        }
        for(int i=0;i<list.size()-1;i++){
            curr=list.get(i);
            curr.next=list.get(i+1);
        }
        list.get(list.size()-1).next=null;

        return list.get(0);
    }
}
