import java.util.*;
public class Rightvision199 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode right = new TreeNode(2);
        root.left = right;
        List<Integer> ans=rightSideView(root);
        System.out.println(ans);

    }

     public static List<Integer> rightSideView(TreeNode root) {
        Deque<TreeNode> deque = new LinkedList<>();
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;
        deque.add(root);
        while (!deque.isEmpty()) {
            int size = deque.size();
            while (size-- > 0) {
                TreeNode node = deque.poll();
                if (node.left != null) deque.add(node.left);
                if (node.right != null) deque.add(node.right);
                if (size > 0) continue;
                res.add(node.val);
            }
        }


        return res;
    }


}


