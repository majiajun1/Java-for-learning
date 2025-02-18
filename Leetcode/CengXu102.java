import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class CengXu102 {

        public List<List<Integer>> levelOrder(TreeNode root) {
            List<List<Integer>> res = new ArrayList<List<Integer>>();
            if(root == null) return res;
            CengXu(root,res);
            return res;

    }


        public static void CengXu(TreeNode root, List<List<Integer>> res) {
        ArrayDeque<TreeNode> stack = new ArrayDeque<TreeNode>();
        stack.push(root);
        while(!stack.isEmpty()) {
            int size = stack.size();
            List<Integer> level=new ArrayList<>();
            for(int i = 0; i < size; i++) {
                TreeNode node = stack.removeLast();
                level.add(node.val);
                if(node.left != null) {
                    stack.addFirst(node.left);
                }
                if(node.right != null) {
                    stack.addFirst(node.right);
                }
            }
            res.add(level);

        }
    }
}
