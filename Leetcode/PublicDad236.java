public class PublicDad236 {
    public static void main(String[] args) {

    }
     public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) {
            return root; // 如果当前节点为空，或者是p/q，直接返回
        }

        // 在左子树中寻找p和q
        TreeNode left = lowestCommonAncestor(root.left, p, q);

        // 在右子树中寻找p和q
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        // 如果p和q分别位于左右子树，则当前节点是最近公共祖先
        if (left != null && right != null) {
            return root;
        }

        // 如果p和q都在左子树或右子树中，返回对应的子树
        return left != null ? left : right;
    }
}
