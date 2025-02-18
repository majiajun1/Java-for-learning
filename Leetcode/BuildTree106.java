import java.util.HashMap;
import java.util.Map;

public class BuildTree106 {
    private Map<Integer, Integer> inorderMap = new HashMap<>();
    private int postIndex; // 记录后序遍历的索引
    public  TreeNode buildTree(int[] inorder, int[] postorder) {

        for (int i = 0; i < inorder.length; i++) {
            inorderMap.put(inorder[i], i);
        }
         postIndex = postorder.length - 1;
         return build(postorder, 0, inorder.length-1);

    }



     private TreeNode build(int[] postorder, int inStart, int inEnd) {  //用递归去切  +
        // 函数作用是找切点  没得切了就是叶节点

        if (inStart > inEnd) {
            return null;
        }

        // 取当前子树的根节点（后序遍历的最后一个元素）   //后序貌似用来找根节点的
        int rootVal = postorder[postIndex];
        TreeNode root = new TreeNode(rootVal);
        postIndex--; // 递减索引，指向下一个根节点

        // 在中序遍历数组中找到根节点的位置
        int rootIndex = inorderMap.get(rootVal);

        // **先构建右子树，再构建左子树**（因为后序遍历是 [左 → 右 → 根]）
        root.right = build(postorder, rootIndex + 1, inEnd);  //用中序数组来切
        root.left = build(postorder, inStart, rootIndex - 1);

        return root;
    }
}
