import java.util.ArrayList;
import java.util.List;

public class GoodNode14483 {
    public static void main(String[] args) {

    }

 public int goodNodes(TreeNode root) {
        // 从根节点开始，初始化路径上的最大值为根节点的值
        return dfs(root, root.val);
    }

    private int dfs(TreeNode node, int maxSoFar) {
        // 如果节点为空，返回 0，因为没有好节点
        if (node == null) {
            return 0;
        }

        // 判断当前节点是否是“好节点”
        int count = 0;
        if (node.val >= maxSoFar) {
            count = 1; // 是“好节点”，计数加 1
        }

        // 更新路径上的最大值
        maxSoFar = Math.max(maxSoFar, node.val);

        // 递归处理左子树和右子树
        count += dfs(node.left, maxSoFar);
        count += dfs(node.right, maxSoFar);

        // 返回总的“好节点”数
        return count;
    }

}
