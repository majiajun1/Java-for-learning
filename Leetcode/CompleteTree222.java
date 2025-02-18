import java.util.ArrayList;

public class CompleteTree222 {
    public int countNodes(TreeNode root) {
        ArrayList<TreeNode> list = new ArrayList< >();
        if(root == null) return 0;
        Digui(root, list);
        return list.size();
    }


    public void Digui(TreeNode root, ArrayList<TreeNode> list) {
        if (root == null) return;
        list.add(root);
        Digui(root.left, list);
        Digui(root.right, list);

    }
}
