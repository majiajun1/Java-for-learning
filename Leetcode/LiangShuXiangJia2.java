public class LiangShuXiangJia2 {
    public static void main(String[] args) {

    }
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int jinwei=0;
        ListNode liindex1=l1;
        ListNode liindex2=l2;
        ListNode ans=new ListNode(0);
        ListNode anshead=ans;
        while (liindex1!=null && liindex2!=null){

            ans.next=new ListNode(0);
            ans=ans.next;
            int sum=liindex1.val+liindex2.val+jinwei;
            if(sum<10){
                jinwei=0;
            }else
            {
                jinwei=1;
                sum=sum%10;
            }
             ans.val=sum;

             liindex1=liindex1.next;
             liindex2=liindex2.next;


        }
        if (liindex1!=null) //l1比l2长
        {

            while(liindex1!=null){
                ans.next=new ListNode(0);
             ans=ans.next;
            int sum=liindex1.val+jinwei;
             if(sum<10){
                jinwei=0;
            }else
            {
                jinwei=1;
                sum=sum%10;
            }

             ans.val=sum;

             liindex1=liindex1.next;
        }
            if(jinwei==1)
            {
                ans.next=new ListNode(0);
                ans=ans.next;
                ans.val=1;
                ans.next=null;
                jinwei=0;
            }
        }
                if (liindex2!=null) //l2比l1长
        {

            while(liindex2!=null){
                ans.next=new ListNode(0);
             ans=ans.next;
            int sum=liindex2.val+jinwei;
             if(sum<10){
                jinwei=0;
            }else
            {
                jinwei=1;
                sum=sum%10;
            }

             ans.val=sum;

             liindex2=liindex2.next;
        }
            if(jinwei==1)
            {
                ans.next=new ListNode(0);
                ans=ans.next;
                ans.val=1;
                ans.next=null;
                jinwei=0;
            }
        }
                if(jinwei==1)
                {
                    ans.next=new ListNode(1);
                }
                return anshead.next;
    }

}
