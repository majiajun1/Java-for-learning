import java.util.ArrayList;

public class DelectNListNode19 {
    public ListNode removeNthFromEnd(ListNode head, int n) {

        ArrayList<ListNode> list = new ArrayList<>();
        ListNode temp = head;
        while (temp != null) {
            list.add(temp);
            temp = temp.next;
        }
        if (list.size() == 1 && n == 1) {
            return null;
        }
        list.remove(list.size() - n);
        for(int i=0;i<list.size()-1;i++)
        {
            list.get(i).next = list.get(i+1);
        }
        list.get(list.size() - 1).next = null;
        return list.get(0);
    }
}
