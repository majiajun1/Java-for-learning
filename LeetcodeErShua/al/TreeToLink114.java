/*
 * -----------------------------------------------------------------------------
 * © Swisslog AG
 * Swisslog is not liable for any usage of this source code that is not agreed on between Swisslog and the other party.
 * The mandatory legal liability remains unaffected.
 * -----------------------------------------------------------------------------
 */
package al;

import java.util.ArrayDeque;

public class TreeToLink114 {


    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(5);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.right.right = new TreeNode(6);
        flatten(root);
    }

  static    ArrayDeque<TreeNode> stack = new ArrayDeque<>();
    public static void flatten(TreeNode root) {
        if (root == null) return;
        stack.push(root);
        DiGui(root.left);
        DiGui(root.right);
        int curSize = stack.size();
        TreeNode last=null;
        for(int i = 0; i < curSize; i++) {
            TreeNode node = stack.pollFirst();
            if(last!=null)
            {
                last.right = node;
                last.left = null;
            }else
            {
                node.left = null;
            }
            last = node;

        }
    }

    public static void DiGui(TreeNode root) {
        if(root == null) return;

         stack.addLast(root);
         DiGui(root.left);

         DiGui(root.right);

    }
}
