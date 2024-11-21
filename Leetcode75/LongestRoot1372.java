public class LongestRoot1372 {
    private int maxPath = 0; // 全局变量，记录最长交错路径长度

    public int longestZigZag(TreeNode root) {
        if (root == null) return 0;
        dfs(root, true, 0);  // 从左子树开始交错
        dfs(root, false, 0); // 从右子树开始交错
        return maxPath;
    }

    private void dfs(TreeNode node, boolean isLeft, int length) {
        if (node == null) return;

        // 更新最大路径长度
        maxPath = Math.max(maxPath, length);

        if (isLeft) {
            // 如果当前方向是左交错，尝试右交错，同时重置左交错路径
            dfs(node.right, false, length + 1); // 下一步右交错
            dfs(node.left, true, 1);            // 重置左交错路径
        } else {
            // 如果当前方向是右交错，尝试左交错，同时重置右交错路径
            dfs(node.left, true, length + 1);   // 下一步左交错
            dfs(node.right, false, 1);         // 重置右交错路径
        }
    }
}
