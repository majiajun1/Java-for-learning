public class MaxDepthTree104 {
    public int maxDepth(TreeNode root) {
        if(root == null) return 0;
        return DiGuiCengXu(root,1);
    }

    public static int DiGuiCengXu(TreeNode root,int depth)
    {
        int right=depth;
        int left=depth;
        if(root.right != null ){
         right=DiGuiCengXu(root.right,depth+1);}
        if(root.left != null ){
            left=DiGuiCengXu(root.left,depth+1);
        }


        return Math.max(right,left);
    }
}
