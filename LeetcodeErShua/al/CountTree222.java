package al;

import java.util.ArrayList;

public class CountTree222 {
      int count=0;
        public int countNodes(TreeNode root) {
            DFS(root);
         return count;
    }

    void DFS(TreeNode root) {
            if (root == null)
                return;
            else
            {
                count++;
            }

            DFS(root.left);

            DFS(root.right);
    }
}
