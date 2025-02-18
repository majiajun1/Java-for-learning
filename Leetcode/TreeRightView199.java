import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

public class TreeRightView199 {


    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.right = new TreeNode(5);
        root.right.right = new TreeNode(4);

        System.out.println(rightSideView(root));
    }

    public static List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        if (root == null) return res;
        CengXu(root, res);
        return res;
    }


    public static void CengXu(TreeNode root,List<Integer> res) {
        ArrayDeque<TreeNode> stack = new ArrayDeque<TreeNode>();
        stack.push(root);
        while(!stack.isEmpty()) {
            int size = stack.size();
            res.add(stack.peek().val);
            for(int i = 0; i < size; i++) {
                TreeNode node = stack.removeLast();
                if(node.left != null) {
                    stack.addFirst(node.left);
                }
                if(node.right != null) {
                    stack.addFirst(node.right);
                }
            }
        }
    }
}
