import java.util.*;

public class SortLink148 {
     public ListNode sortList(ListNode head) {
         if(head==null)
        {
            return null;
        }
         ArrayList<ListNode> list = new ArrayList<>();
         ArrayList<Integer> list1 = new ArrayList<>();
         while (head != null) {
             list.add(head);
             list1.add(head.val);
             head = head.next;
         }
         Collections.sort(list1);
                 for (int i = 0; i < list.size(); i++) {
            list.get(i).val = list1.get(i); // 直接修改 list 里面 ListNode 的 val
        }
                 for (int i = 0; i < list.size() - 1; i++) {
            list.get(i).next = list.get(i + 1);
        }
                 list.get(list.size() - 1).next = null;
                 return list.get(0);

    }
}
