public class RotateTree226 {
    public TreeNode invertTree(TreeNode root) {
        invertTree2(root);
        return root;
    }

    public TreeNode invertTree2(TreeNode root) {
        if (root == null) return null;
        if (root.left == null && root.right == null) {
            return root;}else
        {
            root.left = invertTree2(root.left);
            root.right = invertTree2(root.right);
        }



         TreeNode temp = root.left;
         root.left = root.right;
         root.right = temp;

        return root;
    }
}
