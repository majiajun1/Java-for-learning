public class SameTree100 {
    public boolean isSameTree(TreeNode p, TreeNode q) {
       return    Digui(p,q);

    }

    public static boolean Digui(TreeNode p, TreeNode q) {

        boolean res=false;
        boolean res1=false;
        boolean res2=false;

        if (p == null && q == null) {
            return true;
        }else if (!(p!=null&&q!=null)) {
            return false;
        }

        if (p.val != q.val) {
            return false;
        }else{
            if(p.left == null && q.left == null){
                res1=true;
            }else if(p.left!=null&&q.left!=null){
                res1=Digui(p.left,q.left);
            }else
            {
                res1=false;
            }

            if(p.right == null && q.right == null){
                res2=true;
            }
            else if(p.right!=null&&q.right!=null){
                res2=Digui(p.right,q.right);
            }else
            {
                res2=false;
            }
        }



        return res1&&res2;
    }
}
