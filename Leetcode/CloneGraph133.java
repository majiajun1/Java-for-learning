import java.util.*;

public class CloneGraph133 {

   static class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
     public Node cloneGraph(Node node) {
       if(node == null) return null;

       HashMap<Node, Node> map = new HashMap<>();
       ArrayDeque<Node> queue = new ArrayDeque<>();
        map.put(node, new Node(node.val));
        queue.offer(node);
         while (!queue.isEmpty()) {
            Node cur = queue.poll(); // 取出当前节点

            for (Node neighbor : cur.neighbors) {
                // 如果邻居节点未被克隆，则克隆并加入队列
                if (!map.containsKey(neighbor)) {
                    map.put(neighbor, new Node(neighbor.val));
                    queue.offer(neighbor);
                }
                // 连接克隆节点
                map.get(cur).neighbors.add(map.get(neighbor));
            }
        }






       return map.get(node);
    }

}



