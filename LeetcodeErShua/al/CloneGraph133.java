/*
 * -----------------------------------------------------------------------------
 * © Swisslog AG
 * Swisslog is not liable for any usage of this source code that is not agreed on between Swisslog and the other party.
 * The mandatory legal liability remains unaffected.
 * -----------------------------------------------------------------------------
 */
package al;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class CloneGraph133 {


    class Node {
        public int val;
        public List<Node> neighbors;

        public Node(int val) {
            this.val = val;
        }
    }

    HashMap<Node, Node> oldToNew=new HashMap<>();
    public Node cloneGraph(Node node) {
        if(node==null) return null;
        bfs(node);
        return oldToNew.get(node);
    }

    public void bfs(Node root) {
        ArrayDeque<Node> queue = new ArrayDeque<>(); // 建议用queue命名（BFS通常用队列）
        // 初始节点入队，并提前标记为已克隆（避免重复入队）
        queue.addLast(root);
        oldToNew.put(root, new Node(root.val)); // 提前创建根节点的克隆体

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Node cur = queue.pollFirst(); // BFS用pollFirst（队列特性：先进先出）
                Node newCur = oldToNew.get(cur); // 当前节点的克隆体

                // 遍历所有邻居
                for (Node neighborOld : cur.neighbors) {
                    if (!oldToNew.containsKey(neighborOld)) {
                        // 邻居未克隆：创建克隆体，加入映射，并入队
                        Node newNeighbor = new Node(neighborOld.val);
                        oldToNew.put(neighborOld, newNeighbor);
                        queue.addLast(neighborOld); // 仅未克隆的邻居入队
                    }
                    // 无论邻居是否已克隆，都将其克隆体加入当前克隆节点的邻居列表
                    newCur.neighbors.add(oldToNew.get(neighborOld));
                }
            }
        }
    }

}
