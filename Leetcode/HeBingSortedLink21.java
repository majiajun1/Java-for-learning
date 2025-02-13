public class HeBingSortedLink21 {
    public static void main(String[] args) {

    }
     public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode head = new ListNode(0);
        ListNode cur = head;
        while (list1 != null && list2 != null) {
            cur.next=new ListNode(0);
            cur=cur.next;
            if(list1.val < list2.val) {
                cur.val=list1.val;
                list1=list1.next;
            }
            else
            {
                cur.val=list2.val;
                list2=list2.next;
            }
        }
        while (list1!=null)  //list1更长
        {
            cur.next=new ListNode(0);
            cur=cur.next;
            cur.val=list1.val;
            list1=list1.next;
        }
        while (list2!=null)  //list1更长
        {
            cur.next=new ListNode(0);
            cur=cur.next;
            cur.val=list2.val;
            list2=list2.next;
        }
        return head.next;
    }
}
