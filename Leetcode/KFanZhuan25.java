import java.util.ArrayList;

public class KFanZhuan25 {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
//        head.next.next = new ListNode(3);
//        head.next.next.next = new ListNode(4);
//        head.next.next.next.next = new ListNode(5);
        reverseKGroup(head,2);
    }

      public  static ListNode reverseKGroup(ListNode head, int k) {
        ArrayList<ListNode> list = new ArrayList<>();
        ListNode cur = head;
        while (cur != null) {
            list.add(cur);
            cur = cur.next;
        }
        if (list.size() == 1) {
            return head;
        }
        int left=0;
        int right=0;
        if(k<list.size()){
             right=left+k-1;
        }else
        {
             right=list.size()-1;
        }
        while(right<list.size())
        {
            SwapNode(list,left,right);
            left=left+k;
            right=right+k;
        }
        for (int i=0;i<list.size()-1;i++)
        {
            list.get(i).next=list.get(i+1);
        }
        list.get(list.size()-1).next=null;
        return list.get(0);

    }




    public static void SwapNode(ArrayList<ListNode> list, int left, int right)
    {
        int index1=left;
        int index2=0;
        if(right<list.size()){
            index2=right;
        }else
        {
            index2=list.size()-1;
        }

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
