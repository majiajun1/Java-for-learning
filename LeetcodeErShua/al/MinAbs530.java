/*
 * -----------------------------------------------------------------------------
 * © Swisslog AG
 * Swisslog is not liable for any usage of this source code that is not agreed on between Swisslog and the other party.
 * The mandatory legal liability remains unaffected.
 * -----------------------------------------------------------------------------
 */
package al;

public class MinAbs530 {

        private int ans = Integer.MAX_VALUE;
        private int pre = Integer.MIN_VALUE / 2; // 防止减法溢出

        public int getMinimumDifference(TreeNode root) {
            dfs(root);
            return ans;
        }

        private  void dfs(TreeNode node) {
            if (node == null) {
                return;
            }
            dfs(node.left);
            ans = Math.min(ans, node.val - pre);
            pre = node.val;
            dfs(node.right);
        }


}
