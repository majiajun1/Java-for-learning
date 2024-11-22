import java.util.*;

public class MaxTotal1161 {

    public static void main(String[] args) {

    }

    public static int maxLevelSum(TreeNode root) {
   List<Integer> result = new ArrayList<>();
        if (root == null) {
            return 0; // 如果树为空，直接返回空列表
        }

        // 使用队列进行层序遍历
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            int levelSum = 0; // 记录当前层的元素和
            int size = queue.size(); // 当前层的节点数量

            for (int i = 0; i < size; i++) {
                TreeNode current = queue.poll();
                levelSum += current.val; // 累加当前节点的值

                // 将子节点加入队列
                if (current.left != null) {
                    queue.add(current.left);
                }
                if (current.right != null) {
                    queue.add(current.right);
                }
            }

            // 将当前层的和加入结果列表
            result.add(levelSum);
        }
        int maxValue = result.get(0);
        int maxIndex = 0;
        for (int i = 1; i < result.size(); i++) {
            if (result.get(i) > maxValue) {
                maxValue = result.get(i); // 更新最大值
                maxIndex = i;           // 更新最大值的索引
            }
        }
        return maxIndex+1;
    }

}
