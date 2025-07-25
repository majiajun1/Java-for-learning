/*
 * -----------------------------------------------------------------------------
 * © Swisslog AG
 * Swisslog is not liable for any usage of this source code that is not agreed on between Swisslog and the other party.
 * The mandatory legal liability remains unaffected.
 * -----------------------------------------------------------------------------
 */
package al;

import java.util.ArrayDeque;

public class FanZhuan226 {
    public TreeNode invertTree(TreeNode root) {
        if (root == null) return null;

        ArrayDeque<TreeNode> stack = new ArrayDeque<>();
        stack.push(root);
        while (!stack.isEmpty()) {

            int curSize = stack.size();
            for (int i = 0; i < curSize; i++) {
                TreeNode node = stack.pop();
                TreeNode temp = node.left;
                node.left = node.right;
                node.right = temp;

                if (node.left != null) stack.addLast(node.left);
                if (node.right != null) stack.addLast(node.right);
            }

        }
        return root;
    }
}
