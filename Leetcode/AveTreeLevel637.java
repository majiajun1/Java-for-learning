import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

public class AveTreeLevel637 {


    public List<Double> averageOfLevels(TreeNode root) {
        ArrayList<Double> res = new ArrayList<Double>();
        if(root == null) return res;
        CengXu(root, res);
        return res;
    }

    public static void CengXu(TreeNode root, List<Double> res) {
        ArrayDeque<TreeNode> stack = new ArrayDeque<TreeNode>();
        stack.push(root);
        while(!stack.isEmpty()) {
            int size = stack.size();
            Double sum = 0.0;
            for(int i = 0; i < size; i++) {
                TreeNode node = stack.removeLast();
                sum += node.val;
                if(node.left != null) {
                    stack.addFirst(node.left);
                }
                if(node.right != null) {
                    stack.addFirst(node.right);
                }
            }
            res.add(sum/(double)size);
        }
    }
}
