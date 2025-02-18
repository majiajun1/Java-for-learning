import java.util.ArrayList;

public class SearchTreeKsmall230 {

    public int kthSmallest(TreeNode root, int k) {
        ArrayList<Integer> list = new ArrayList<>();
        saveTree(list, root,k);
        return list.get(k-1);
    }


    public static void saveTree(ArrayList<Integer> list, TreeNode root,int k) {
        if (root == null) return;

        if (root.left != null) saveTree(list,root.left,k);
        list.add(root.val);
        if(list.size()>=k) return;
        if (root.right != null) saveTree(list,root.right,k);
    }

}

