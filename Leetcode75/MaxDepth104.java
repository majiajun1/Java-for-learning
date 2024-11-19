public class MaxDepth104 {
    public static void main(String[] args) {
        TreeNode node3 = new TreeNode(3);
        TreeNode node9 = new TreeNode(9);
        TreeNode node20 = new TreeNode(20, new TreeNode(15), new TreeNode(7));
        TreeNode root = new TreeNode(3, node9, node20);
         System.out.println("树的深度是: " + maxDepth(root));
    }



    public static int maxDepth(TreeNode root) {
        // 如果当前节点为空，返回深度0
        if (root == null) {
            return 0;
        }
        // 递归计算左子树和右子树的深度
        int leftDepth = maxDepth(root.left);
        int rightDepth = maxDepth(root.right);
        // 当前树的深度为左右子树深度的最大值加1
        return Math.max(leftDepth, rightDepth) + 1;
    }
}
