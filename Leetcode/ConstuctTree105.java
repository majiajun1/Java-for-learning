import java.util.HashMap;
import java.util.Map;

public class ConstuctTree105 {
    private Map<Integer, Integer> inorderMap = new HashMap<>();

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        // 填充中序遍历的哈希表
        for (int i = 0; i < inorder.length; i++) {
            inorderMap.put(inorder[i], i);
        }

        // 从前序数组和中序数组构建树
        return build(preorder, 0, preorder.length - 1, 0);
    }

    // 递归方法来构建二叉树
    private TreeNode build(int[] preorder, int preStart, int preEnd, int inStart) {
        //preorder：前序遍历的数组。
        //inorder：中序遍历的数组。
        //preStart, preEnd：当前子树在前序遍历中的索引范围。
        //inStart：当前子树在中序遍历中的起始位置。
        //rootIndex：当前根节点在中序遍历中的位置。
        if (preStart > preEnd) {
            return null;
        }

        // 当前根节点值
        int rootVal = preorder[preStart];
        TreeNode root = new TreeNode(rootVal);

        // 在中序数组中找到根节点的位置
        int rootIndex = inorderMap.get(rootVal);

        // 计算左子树的长度
        int leftSize = rootIndex - inStart;

        // 构建左子树
        root.left = build(preorder, preStart + 1, preStart + leftSize, inStart);

        // 构建右子树
        root.right = build(preorder, preStart + leftSize + 1, preEnd, rootIndex + 1);

        return root;
    }
}
