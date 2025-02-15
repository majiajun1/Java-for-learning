import java.util.*;

public class DuiChengTree101 {

   public static boolean isSymmetric(TreeNode root) {
        if (root == null) return true;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root.left);   // 将左子树头结点加入队列
        queue.offer(root.right);  // 将右子树头结点加入队列

        while (!queue.isEmpty()) {
            TreeNode leftNode = queue.poll();
            TreeNode rightNode = queue.poll();

            if (leftNode == null && rightNode == null) {
                continue;  // 两个子节点都为空，跳过本轮循环
            }

            // 左右子树有一个为空，或者值不相等，返回 false
            if (leftNode == null || rightNode == null || leftNode.val != rightNode.val) {
                return false;
            }

            // 依次加入对称位置的节点
            queue.offer(leftNode.left);
            queue.offer(rightNode.right);
            queue.offer(leftNode.right);
            queue.offer(rightNode.left);
        }

        return true;
    }


}
