/*
 * -----------------------------------------------------------------------------
 * © Swisslog AG
 * Swisslog is not liable for any usage of this source code that is not agreed on between Swisslog and the other party.
 * The mandatory legal liability remains unaffected.
 * -----------------------------------------------------------------------------
 */
package al;

import java.util.ArrayDeque;

public class SameTree100 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);


        TreeNode root2=new TreeNode(1);

        root2.right=new TreeNode(3);

        System.out.println(isSameTree(root, root2));
    }
    public static boolean isSameTree(TreeNode p, TreeNode q) {
        ArrayDeque<TreeNode> stack1 = new ArrayDeque<TreeNode>();
        ArrayDeque<TreeNode> stack2 = new ArrayDeque<>();

        if(p==null && q==null) return true;
        if((p==null && q!=null) || (p!=null && q==null)) return false;

        stack1.push(p);
        stack2.push(q);
        while (!stack1.isEmpty() && !stack2.isEmpty()) {
            int curSize1=stack1.size();
            int curSize2=stack2.size();
            if (curSize1 != curSize2) return false;
            else{
                for (int i=0; i<curSize1; i++){
                    TreeNode p1 = stack1.pop();
                    TreeNode q1 = stack2.pop();

                    if (p1.val != q1.val) return false;

                    if(p1.left!=null&&q1.left!=null)
                    {
                        stack1.addLast(p1.left);
                        stack2.addLast(q1.left);
                    }else if(p1.left==null&&q1.left==null)
                    {

                    }else
                    {
                        return false;
                    }

                    if(p1.right!=null&&q1.right!=null)
                    {
                        stack1.addLast(p1.right);
                        stack2.addLast(q1.right);
                    }else if(p1.right==null&&q1.right==null)
                    {

                    }else
                    {
                        return false;
                    }



                }

            }
        }

        if(stack1.size() != stack2.size()) return false;
        else return true;
    }
}
