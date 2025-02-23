import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;

public class HeKSortedLink23 {
     public ListNode mergeKLists(ListNode[] lists) {
         ArrayList<ListNode> list = new ArrayList<>();
         ArrayList<Integer> list1 = new ArrayList<>();
         for (ListNode node : lists) {
             while (node != null) {
                 list.add(node);
                 list1.add(node.val);
                 node=node.next;
             }
         }
         if (list.size() == 0) return null;
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

        public static ListNode mergeKLists2(ListNode[] lists) {
        if (lists == null || lists.length == 0) return null;

        // 使用最小堆 (PriorityQueue) 来维护 k 个链表的最小值
        PriorityQueue<ListNode> pq = new PriorityQueue<>((a, b) -> a.val - b.val);

        // 先把每个链表的头节点放入最小堆
        for (ListNode node : lists) {
            if (node != null) {
                pq.offer(node);
            }
        }

        // 结果链表的哨兵节点
        ListNode dummy = new ListNode(-1);
        ListNode curr = dummy;

        // 逐步从最小堆取出最小值节点，并维护堆结构
        while (!pq.isEmpty()) {
            ListNode minNode = pq.poll(); // 取出最小的节点
            curr.next = minNode;          // 连接到新链表
            curr = curr.next;             // 移动指针

            if (minNode.next != null) {
                pq.offer(minNode.next);   // 把下一个节点加入堆
            }
        }

        return dummy.next;
    }



}
