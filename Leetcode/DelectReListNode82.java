import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class DelectReListNode82 {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(2);
//        head.next.next.next = new ListNode(2);
//        head.next.next.next.next = new ListNode(3);
//        head.next.next.next.next.next = new ListNode(4);
//        head.next.next.next.next.next.next = new ListNode(5);
        deleteDuplicates(head);
    }

    public static ListNode deleteDuplicates(ListNode head) {
         if (head == null || head.next == null) return head;

         HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
         ListNode temp = head;
         while (temp != null) {

             map.put(temp.val, map.getOrDefault(temp.val, 0) + 1);
             temp = temp.next;
             }

     while(head!=null&&map.get(head.val) >1) {
             head = head.next;
        }
     if(head==null) return head;
         temp = head;

         while(temp.next != null) {
             if(map.get(temp.next.val) == 1) {
                 temp=temp.next;
             }else
             {
                 ListNode pointer = temp.next;
                 while(pointer!=null&&  map.get(pointer.val) > 1) {
                     pointer = pointer.next;
                 }
                 temp.next = pointer;
               }
             if(temp==null)
             {
                 break;
             }

         }
          return head;
    }

}

