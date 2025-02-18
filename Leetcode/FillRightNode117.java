import java.util.ArrayDeque;

public class FillRightNode117 {
     public Node connect(Node root) {
         ArrayDeque<Node> stack = new ArrayDeque<>();
         if (root == null) return root;

         stack.push(root);
         while (!stack.isEmpty()) {
             int size = stack.size();
             for (int i = 0; i < size; i++) {
                 Node node = stack.pop();
                 if(i==size-1) {node.next=null;}
                 else
                 {
                     node.next=stack.peek();
                 }
                 if (node.left != null) stack.addLast(node.left);
                 if (node.right != null) stack.addLast(node.right);

             }
         }

         return root;


    }
}
