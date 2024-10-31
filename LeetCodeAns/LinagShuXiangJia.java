import java.lang.Math;
class ListNode {
      int val;
     ListNode next;
     ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
      }


class Solution {
        public static void main(String[] args) {
        // 创建链表 l1，表示数字 2 -> 4 -> 3
        ListNode l1 = new ListNode(2);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(3);

        // 创建链表 l2，表示数字 5 -> 6 -> 4
        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(4);

        // 打印链表以检查结果
        printList(l1);
        printList(l2);
            ListNode l3 = addTwoNumbers2(l1,l2);
        printList(l3);

        ListNode l4=new ListNode(0);
        ListNode l5=new ListNode(0);
        ListNode l6=addTwoNumbers2(l4,l5);
        printList(l6);

       ListNode l7=new ListNode(9);
       ListNode l8=new ListNode(1);
       ListNode l8head=new ListNode(2);
       l8head.next = l8;
       for(int i=0;i<9;i++)
       {
           l8.next=new ListNode(9);
           l8=l8.next;
       }
       l8=l8head.next;
       printList(l7);
       printList(l8);
       ListNode l9=addTwoNumbers2(l7,l8);
       printList(l9);


    }
    private static void printList(ListNode node) {
        while (node != null) {
            System.out.print(node.val + " ");
            node = node.next;
        }
        System.out.println();
    }
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {   //最蠢的做法  完全忽略数值类型有范围
        int WeiShu1=0;
        int WeiShu2=0;
        double total1=0;
        double total2=0;
        for(WeiShu1=0;l1!=null;WeiShu1++)
        {
            total1=total1 + l1.val*Math.pow(10,WeiShu1);
            l1=l1.next;
        }
        for(WeiShu2=0;l2!=null;WeiShu2++)
        {
            total2=total2 + l2.val*Math.pow(10,WeiShu2);
            l2=l2.next;
        }
        double total3=total1+total2;
        long total4=(long) total3;
         ListNode dummyHead = new ListNode(0);  // 使用虚拟头节点，方便操作
        ListNode current = dummyHead;
        if(total4==0)
        {
            return dummyHead;
        }

         while (total4 > 0) {

            long digit =  total4 % 10;  // 获取当前最低位数字
            current.next = new ListNode((int)digit);  // 创建新节点并链接到链表中
            current = current.next;
            total4 = total4 / 10;  // 去掉最低位数字
        }
      return dummyHead.next;

    }
    public static ListNode addTwoNumbers2(ListNode l1, ListNode l2){
            int jinwei=0;
            int temp=0;
            ListNode ans=new ListNode(0);
            ListNode anshead=new ListNode(0);
            anshead.next=ans;

            while((l1!=null)||(l2!=null))
            {

                if(l1==null)
                {
                    temp=l2.val+jinwei;
                }
                else if(l2==null){
                    temp=l1.val+jinwei;
                }
                    else temp=l1.val+l2.val+jinwei;



                jinwei=0;
                if(temp>=10)
                {
                    jinwei=1;
                    temp=temp%10;

                }
                ans.next=new ListNode(temp);

                ans=ans.next;
                if(l1!=null){
                l1=l1.next;}
                if(l2!=null){l2=l2.next;}

                if(l1==null&&l2==null&&jinwei==1)
                {ans.next=new ListNode(jinwei);}

            }
            return anshead.next.next;



    }
}