import java.util.ArrayList;

public class Tree2Link114 {
     public void flatten(TreeNode root) {
         if (root == null) return;
        ArrayList<TreeNode> list = new ArrayList< >();
        preOrder(root, list);
        for (int i = 0; i < list.size()-1; i++) {
            TreeNode node = list.get(i);
            node.left = null;
            node.right = list.get(i + 1);
        }
        TreeNode node = list.get(list.size()-1);
        node.left = null;
        node.right = null;

    }

    public void preOrder(TreeNode root,ArrayList<TreeNode> list) {
         if (root == null) return;

         list.add(root);

         if (root.left != null) preOrder(root.left, list);
         if (root.right != null) preOrder(root.right, list);
         return;
    }
}
