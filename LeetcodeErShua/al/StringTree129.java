/*
 * -----------------------------------------------------------------------------
 * © Swisslog AG
 * Swisslog is not liable for any usage of this source code that is not agreed on between Swisslog and the other party.
 * The mandatory legal liability remains unaffected.
 * -----------------------------------------------------------------------------
 */
package al;

import java.util.ArrayDeque;
import java.util.ArrayList;

public class StringTree129 {
    int sum = 0;
    public int sumNumbers(TreeNode root) {
         sum=0;
        if(root==null) return 0;
        StringBuilder stringBuilder=new StringBuilder();
        diGui(root,stringBuilder);

        return sum;
    }




    public void diGui(TreeNode root, StringBuilder builder) {

        if (root == null) return ;
        StringBuilder builder2=new StringBuilder(builder);
        builder2.append(root.val);
        if(root.left==null && root.right==null) {
            sum+=Integer.parseInt(builder2.toString());
        }else
        {
            diGui(root.left,builder2);
            diGui(root.right,builder2);
        }



    }
}
