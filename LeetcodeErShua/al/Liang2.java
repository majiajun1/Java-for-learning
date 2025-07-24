/*
 * -----------------------------------------------------------------------------
 * © Swisslog AG
 * Swisslog is not liable for any usage of this source code that is not agreed on between Swisslog and the other party.
 * The mandatory legal liability remains unaffected.
 * -----------------------------------------------------------------------------
 */
package al;

public class Liang2 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode ans=new ListNode(0);
        ListNode anshead=ans;
        ListNode l1Pointer=l1;
        ListNode l2Pointer=l2;
        int jinwei=0;
        while(l1Pointer!=null&&l2Pointer!=null){
            int sum=l1Pointer.val+l2Pointer.val;
            sum+=jinwei;
            if(sum<10){
                ans.val=sum;
                jinwei=0;
            }else
            {
                jinwei=sum/10;
                ans.val=sum%10;
            }
            l1Pointer=l1Pointer.next;
            l2Pointer=l2Pointer.next;
            if(l1Pointer!=null||l2Pointer!=null)
            {
                ans.next=new ListNode(0);
                ans=ans.next;
            }

        }
        while(l1Pointer!=null){
            int sum=l1Pointer.val;
            sum+=jinwei;
            if(sum<10){
                ans.val=sum;
                jinwei=0;
            }else
            {
                jinwei=sum/10;
                ans.val=sum%10;
            }
            l1Pointer=l1Pointer.next;

            if(l1Pointer!=null)
            {
                ans.next=new ListNode(0);
                ans=ans.next;
            }
        }
        while(l2Pointer!=null){
            int sum=l2Pointer.val;
            sum+=jinwei;
            if(sum<10){
                ans.val=sum;
                jinwei=0;
            }else
            {
                jinwei=sum/10;
                ans.val=sum%10;
            }
            l2Pointer=l2Pointer.next;

            if(l2Pointer!=null)
            {
                ans.next=new ListNode(0);
                ans=ans.next;
            }
        }

        if(jinwei!=0)
        {
            ans.next=new ListNode(jinwei);
        }
        return anshead;
    }
}
