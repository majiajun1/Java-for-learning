import java.util.*;
public class FanZhuan206andMaxNuanSheng2130 {
    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(3);
        l1.next.next.next = new ListNode(4);
        l1.next.next.next.next = new ListNode(5);
       // ListNode ans=reverseList(l1);
       //
        // printList(l1);
        ListNode l2=new ListNode(5);
        l2.next=new ListNode(4);
        l2.next.next=new ListNode(2);
        l2.next.next.next=new ListNode(1);
        int ans1=pairSum(l2);
        printList(l2);
        System.out.println(ans1);
    }
     private static void printList(ListNode node) {
        while (node != null) {
            System.out.print(node.val + " ");
            node = node.next;
        }
        System.out.println();
    }

    public static ListNode reverseList(ListNode head) {
        if(head == null || head.next == null) return head;
        ListNode temp = head;
        ListNode temp2=head.next;
        ListNode temp3=temp2.next;
        head.next=null;
        while (temp2!= null) {
            temp2.next=temp;
            temp=temp2;
            temp2=temp3;
            if(temp3!=null)
            {
                temp3=temp3.next;
            }

        }
        return temp;

    }

    public static int pairSum(ListNode head) {
         int length = 0;
        ListNode current = head;
        while (current != null) {
            length++;
            current = current.next;
        }

        // 第二步：创建数组并将链表的值存入数组
        int[] result = new int[length];
        current = head; // 重新指向头节点
        int index = 0;
        while (current != null) {
            result[index++] = current.val;
            current = current.next;

        }
        index--;
        int tempmax=0;
        int temp=0;
        for (int i = 0; i < length/2; i++) {

            temp = result[i] +result[index--];
            if(temp>tempmax)
            {
                tempmax=temp;
            }
        }
        return tempmax;
    }



}
