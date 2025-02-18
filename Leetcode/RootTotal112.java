public class RootTotal112 {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(-2);
        root.right = new TreeNode(-3);
        root.left=null;
        System.out.println(hasPathSum(root,-5));
    }
     public static boolean hasPathSum(TreeNode root, int targetSum) {
         return hasPathSum2(root, targetSum, 0);
    }

    public static boolean hasPathSum2(TreeNode root, int targetSum,int curr) {
         if (root == null) {return false;}
        boolean left=false;
        boolean right=false;
        int sum=curr+root.val;

        if(root.left==null && root.right==null) {
            if(sum==targetSum) {
                return true;
            }
        }else
        {
            left=hasPathSum2(root.left,targetSum,sum);
            right=hasPathSum2(root.right,targetSum,sum);
        }
         return left||right;
    }
}
