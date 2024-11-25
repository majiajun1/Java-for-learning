public class DeleteSearchTree450 {
    public static void main(String[] args) {

    }
    public TreeNode deleteNode(TreeNode root, int key) {
        return delete(root,key);
    }
    public TreeNode delete(TreeNode root, int key){
        if(root == null){
            return null;
        }


        if(root.val > key){
            //go left;
            root.left = delete(root.left,key);
        }
        else if(root.val < key){
            //go right;
            root.right = delete(root.right,key);
        }
        else {
            if(root.left == null && root.right == null){
                return null;
            }
            else if(root.left == null){
                return root.right;
            }
            else if(root.right == null){
                return root.left;
            }
            else
            {
                TreeNode temp = minNode(root.right);
                root.val = temp.val; //copy
                root.right = delete(root.right,temp.val);
            }
            // delete current node
        }
        return root;
    }

    public static TreeNode minNode(TreeNode root){  //找右字数最小
            if(root == null){
                return null;
            }
            while(root.left != null){
                root = root.left;
            }
            return root;
    }

}
