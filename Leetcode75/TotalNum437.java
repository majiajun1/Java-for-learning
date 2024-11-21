public class TotalNum437 {

    public static void main(String[] args) {
        TreeNode node11 = new TreeNode(11);
        TreeNode node3_1 = new TreeNode(3);
        TreeNode node_2 = new TreeNode(-2);
        TreeNode node1 = new TreeNode(1);

        // 构造中间层节点
        TreeNode node3 = new TreeNode(3);
        node3.left = node3_1;
        node3.right = node_2;

        TreeNode node2 = new TreeNode(2);
        node2.right = node1;

        // 构造根的左右节点
        TreeNode node5 = new TreeNode(5);
        node5.left = node3;
        node5.right = node2;

        TreeNode node_3 = new TreeNode(-3);
        node_3.right = node11;

        // 构造根节点
        TreeNode root = new TreeNode(10);
        root.left = node5;
        root.right = node_3;

        int ans=pathSum(root,8);
        System.out.println(ans);
    }

    static   int res = 0;
    public static int pathSum(TreeNode root, int targetSum) {
        preOrder(root, targetSum);
        return res;
    }

   private static void preOrder(TreeNode cur, long sum) {
        if (cur == null) {
            return;
        }
        // 以 cur开始，进行DFS，寻找符合的答案
        exec(cur, 0, sum);
        preOrder(cur.left, sum);
        preOrder(cur.right, sum);
    }


       private static void exec(TreeNode cur, long temp, long sum) {
        if (cur == null) {
            return;
        }
        if (temp + cur.val == sum) {
            res++;
        }
        // 往下递归左边 + 回溯
        if (cur.left != null) {
            exec(cur.left, temp + cur.val, sum);
        }
        // 往下递归右边 + 回溯
        if (cur.right != null) {
            exec(cur.right, temp + cur.val, sum);
        }
    }



}
