import java.util.ArrayList;
import java.util.HashMap;

public class RandomLinkCopy138 {
    public static void main(String[] args) {


    }
    public Node copyRandomList(Node head) {
        if (head == null) return null;

        // 创建 HashMap 记录旧节点 -> 新节点的映射
        HashMap<Node, Node> oldToNew = new HashMap<>();

        // 第一轮遍历：复制所有节点
        Node cur = head;
        while (cur != null) {
            oldToNew.put(cur, new Node(cur.val));
            cur = cur.next;
        }

        // 第二轮遍历：复制 next 和 random 指针
        cur = head;
        while (cur != null) {
            Node clonedNode = oldToNew.get(cur);
            clonedNode.next = oldToNew.get(cur.next);  // 复制 next 指针
            clonedNode.random = oldToNew.get(cur.random);  // 复制 random 指针
            cur = cur.next;
        }

        // 返回复制的新链表的头节点
        return oldToNew.get(head);
    }
}
