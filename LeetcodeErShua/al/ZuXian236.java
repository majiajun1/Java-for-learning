package al;

import java.util.HashMap;
import java.util.HashSet;


public class ZuXian236 {
    HashMap<TreeNode,TreeNode> dad=new HashMap<>();
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        dfs(root);
        HashSet<TreeNode> set=new HashSet<>();
        set.add(root);
        set.add(p);
       while (dad.containsKey(p)) {
           set.add(dad.get(p));
           p=dad.get(p);
       }

       while (!set.contains(q)) {
           q=dad.get(q);
       }
       return q;
    }

    void dfs(TreeNode root) {
        if(root==null) return;

        if(root.left!=null)
        {
            dad.put(root.left,root);
        }
        dfs(root.left);

        if(root.right!=null)
        {
            dad.put(root.right,root);
        }
        dfs(root.right);
    }
}
