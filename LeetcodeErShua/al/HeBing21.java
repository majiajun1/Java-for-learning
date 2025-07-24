/*
 * -----------------------------------------------------------------------------
 * © Swisslog AG
 * Swisslog is not liable for any usage of this source code that is not agreed on between Swisslog and the other party.
 * The mandatory legal liability remains unaffected.
 * -----------------------------------------------------------------------------
 */
package al;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class HeBing21 {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {

        if(list1 == null) return list2;
        if(list2 == null) return list1;
        ListNode ans = new ListNode(0);
        ListNode anshead=ans;
        while(list1!=null && list2!=null){
            if(list1.val<list2.val){
                ans.next = new ListNode(list1.val);
                ans = ans.next;
                list1 = list1.next;
            }else
            {
                ans.next = new ListNode(list2.val);
                ans = ans.next;
                list2 = list2.next;
            }
        }
        while(list1!=null){
            ans.next = new ListNode(list1.val);
            ans = ans.next;
            list1 = list1.next;
        }
        while(list2!=null){
            ans.next = new ListNode(list2.val);
            ans = ans.next;
            list2 = list2.next;
        }



        return anshead.next;

    }
}
