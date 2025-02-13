import java.util.HashSet;

public class RoundLink141 {
    public static void main(String[] args) {

    }

    public boolean hasCycle(ListNode head) {
        HashSet<ListNode> set = new HashSet<ListNode>();
        ListNode cur=head;
        while (cur!= null) {
            if(set.contains(cur)) {
                return true;
            }else {
            set.add(cur);
            cur=cur.next;}
        }
        return false;

    }
}
