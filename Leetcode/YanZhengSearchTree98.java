import com.sun.xml.internal.ws.api.client.WSPortInfo;

import java.util.ArrayList;

public class YanZhengSearchTree98 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(1);
        root.right = new TreeNode(4);
        root.right.left=new TreeNode(3);
        root.right.right=new TreeNode(6);
        System.out.println(isValidBST(root));
    }
    public static boolean isValidBST(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<>();
        saveTree(list, root);
        for (int i = 0; i < list.size()-1; i++) {
            int temp=list.get(i);
            int temp2=list.get(i+1);
            if(temp>=temp2)
            {
               return false;
            }
        }
        return true;
    }

     public static void saveTree(ArrayList<Integer> list, TreeNode root) {
        if (root == null) return  ;


        if (root.left != null)     saveTree(list,root.left);
        list.add(root.val);

        if (root.right != null)   saveTree(list,root.right);


    }
}
