/*
 * -----------------------------------------------------------------------------
 * © Swisslog AG
 * Swisslog is not liable for any usage of this source code that is not agreed on between Swisslog and the other party.
 * The mandatory legal liability remains unaffected.
 * -----------------------------------------------------------------------------
 */
package al;

import java.util.ArrayDeque;

public class Tree104 {
    public int maxDepth(TreeNode root) {
        ArrayDeque<TreeNode> stack = new ArrayDeque<TreeNode>();
        int depth = 0;
        if (root == null) return depth;
        stack.addLast(root);
        while (!stack.isEmpty()) {
            depth++;
            int curSize = stack.size();

            for (int i = 0; i< curSize; i++) {
                TreeNode node = stack.pop();
                if (node.left != null) stack.addLast(node.left);
                if (node.right != null) stack.addLast(node.right);

            }
        }
        return depth;
    }
}
