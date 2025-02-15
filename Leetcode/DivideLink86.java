import java.util.ArrayList;

public class DivideLink86 {

     public ListNode partition(ListNode head, int x) {
         if (head == null || head.next == null) return head;
        ArrayList<ListNode> left = new ArrayList<ListNode>();
        ArrayList<ListNode> right=new ArrayList<>();
        ListNode curr=head;
        while(curr!=null){
            if(curr.val<x){
                left.add(curr);
            }
            else
            {
                right.add(curr);
            }
            curr=curr.next;
        }
        if (left.isEmpty() || right.isEmpty()) return head;

        for (int i=0;i<left.size()-1;i++){
            curr=left.get(i);
            curr.next=left.get(i+1);
        }
        left.get(left.size()-1).next=right.get(0);
        for (int i=0;i<right.size()-1;i++){
            curr=right.get(i);
            curr.next=right.get(i+1);
        }
        right.get(right.size()-1).next=null;
        return left.get(0);
    }
}
