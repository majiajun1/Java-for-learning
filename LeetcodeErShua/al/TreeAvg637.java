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
import java.util.List;

public class TreeAvg637 {
    public List<Double> averageOfLevels(TreeNode root) {
        ArrayDeque<TreeNode> stack = new ArrayDeque<>();
        stack.push(root);
        List<Double> res = new ArrayList<>();
        while (!stack.isEmpty()) {
            int size = stack.size();

            double sum = 0;
            for (int i = 0; i < size; i++) {
                TreeNode node = stack.pop();
                sum += node.val;
                if (node.left != null) {
                    stack.addLast(node.left);
                }
                if (node.right != null) {
                    stack.addLast(node.right);
                }
            }
            double avg = sum / size;
            res.add(avg);
        }
        return res ;
    }
}
