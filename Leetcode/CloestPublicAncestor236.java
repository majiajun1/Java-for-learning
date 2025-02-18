import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class CloestPublicAncestor236 {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(5);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(6);
        root.left.right = new TreeNode(2);
        root.right.left = new TreeNode(0);
        root.right.right = new TreeNode(8);
        root.left.right.left = new TreeNode(7);
        root.left.right.right = new TreeNode(4);
        System.out.println(lowestCommonAncestor(root, root.left, root.right).val);
    }
    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        HashMap<TreeNode, TreeNode> map = new HashMap<>();



        if(root == null) return null;

        AddDigui(  map, root);
          HashSet<TreeNode> ancestors = new HashSet<>();

        // 遍历 p 的祖先路径
        while (p != null) {
            ancestors.add(p);
            p = map.get(p);
        }
        while (q != null) {
            if (ancestors.contains(q)) {
                return q; // 第一个找到的即为最近公共祖先
            }
            q = map.get(q);
        }

        return null;



    }

    public static void AddDigui( HashMap<TreeNode, TreeNode> map,TreeNode root)
    {
        if (root==null) return;

        if(root.left!=null)
        {
            map.put(root.left, root);
            AddDigui(map, root.left);
        }
        if(root.right!=null)
        {
            map.put(root.right, root);
            AddDigui(map, root.right);
        }



    }
}
