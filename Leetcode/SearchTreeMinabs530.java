import java.util.ArrayList;

public class SearchTreeMinabs530 {
     static int min=Integer.MAX_VALUE;

    public static void main(String[] args) {
        TreeNode root = new TreeNode(236);
        root.left = new TreeNode(104);
        root.left.right = new TreeNode(227);
        root.right = new TreeNode(701);
        root.right.right = new TreeNode(911);
        System.out.println(getMinimumDifference(root));
    }
    public static int getMinimumDifference(TreeNode root) {

        if (root == null) return 0;
        ArrayList<Integer> list = new ArrayList<Integer>();
        saveTree(list, root);
        for(int i=0; i<list.size()-1; i++){
            min=Math.min(min, Math.abs(list.get(i)-list.get(i+1)) );
        }
        return min;
    }


    public static void saveTree(ArrayList<Integer> list,TreeNode root) {
        if (root == null) return;

        if (root.left != null) saveTree(list,root.left);
        list.add(root.val);
        if (root.right != null) saveTree(list,root.right);
    }

}
