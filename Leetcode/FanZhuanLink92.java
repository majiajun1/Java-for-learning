import java.util.ArrayList;

public class FanZhuanLink92 {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        int left=1;
        int right=4;
        reverseBetween(head, left, right);
    }



    public static ListNode reverseBetween(ListNode head, int left, int right) {
        ArrayList<ListNode> list = new ArrayList<>();
        ListNode cur = head;
        while (cur != null) {
            list.add(cur);
            cur = cur.next;
        }
        if (list.size() == 1||left == right) {
            return head;
        }
        int leftindex=left-1;
        int rightindex=right-1;
        SwapNode(list, leftindex, rightindex);
        for (int i = 0; i <list.size()-1; i++) {
            ListNode temp=list.get(i);
            temp.next = list.get(i+1);
        }
        ListNode temp=list.get(list.size()-1);
        temp.next = null;
        head=list.get(0);
        return head;

    }

    public static void SwapNode(ArrayList<ListNode> list,int left, int right)
    {
        int index1=left;
        int index2=right;
        while(index1<index2)
        {
            ListNode temp=list.get(index1);
            list.set(index1,list.get(index2));
            list.set(index2,temp);
            index1++;
            index2--;
        }

    }

}
