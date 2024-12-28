public class SearchTree700 {
    public static void main(String[] args) {

    }
    public static TreeNode searchBST(TreeNode root, int val) {
        if(root == null) return null;
        if(root.val == val) return root;
        if(root.val > val) return searchBST(root.left, val);
        return searchBST(root.right, val);

    }
}
