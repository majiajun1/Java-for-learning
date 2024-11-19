import java.util.*;

public class SimiliarTree872 {
    public static void main(String[] args) {

        TreeNode node9 = new TreeNode(9);
        TreeNode node20 = new TreeNode(20, new TreeNode(15), new TreeNode(7));
        TreeNode root = new TreeNode(3, node9, node20);
        List<Integer> ans=getLeaves(root);
        System.out.println(ans);

    }
    public static boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<Integer> ans1=getLeaves(root1);
        List<Integer> ans2=getLeaves(root2);
        return ans1.equals(ans2);
    }
   public static List<Integer> getLeaves(TreeNode root) {
        List<Integer> leaves = new ArrayList<>();
        // 调用递归函数收集叶子节点
        collectLeaves(root, leaves);
        return leaves;
    }
     private static void collectLeaves(TreeNode node, List<Integer> leaves) {  //根左右
        if (node == null) return; // 空节点直接返回

        // 如果没有子节点，则当前节点是叶子节点
        if (node.left == null &&node.right==null) {
            leaves.add(node.val);
            return;
        }

        // 遍历所有子节点
         if(node.left != null) {
             collectLeaves(node.left, leaves);
         }
         if(node.right != null) {
             collectLeaves(node.right, leaves);
         }

    }

}
