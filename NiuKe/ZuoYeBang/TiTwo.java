package ZuoYeBang;

import javax.print.DocFlavor;
import java.util.*;

public class TiTwo {
       TreeNode max,min=null;
       int maxVal=Integer.MIN_VALUE,minVal=Integer.MAX_VALUE;

        public   int getDis (TreeNode root) {
            // write code here
            if(root==null) return 0;

            findMaxMinLeaves(root);
            if(min==null) return 0;
            TreeNode publicFather=findPublicFather(root,max,min);
            int distToMax=CalculateDistance(p)
        }

    public void findMaxMinLeaves(TreeNode node){
            if(node==null) return;
            if(node.left==null&&node.right==null){
                if(node.val >maxVal)
                {maxVal=node.val;
                max=node;}
                if(minVal>node.val)
                {
                    minVal=node.val;
                    min=node;
                }
            }
            findMaxMinLeaves(node.left);
            findMaxMinLeaves(node.right);
    }

    public TreeNode findPublicFather(TreeNode root,TreeNode p,TreeNode q){
        if(root==null||root==p||root==q) return root;
        TreeNode left=findPublicFather(root.left,p,q);
        TreeNode right=findPublicFather(root.right,p,q);
        if(left!=null&&right!=null)
        {
            return root;
        }
        return left!=null?left:right;

    }

    public int CalculateDistance(TreeNode source,TreeNode target){
        if(source==null) return -1;
        if(target==null) return 0;

        int leftDistance=CalculateDistance(source.left,target);
        if(leftDistance>=0) return leftDistance+1;
        int rightDistance=CalculateDistance(source.right,target);
        if(rightDistance>=0) return rightDistance+1;

        return -1;
    }

}


class TreeNode {
    int val = 0;
     TreeNode left = null;
     TreeNode right = null;
     public TreeNode(int val) {
      this.val = val;
    }
   }