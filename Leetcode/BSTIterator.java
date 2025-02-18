import java.util.ArrayList;

public class BSTIterator {

    ArrayList<TreeNode> list;
    int index;
    public BSTIterator(TreeNode root) {
         list=new ArrayList<>();
         DiGui(root,list);
         index=0;

    }

    public int next() {

        return list.get(index++).val;
    }

    public boolean hasNext() {
        if(index==list.size()) return false;
        else return true;
    }



    public void DiGui(TreeNode root,ArrayList<TreeNode> list) {
        if(root==null) return;
        if(root.left!=null) DiGui(root.left,list);
        list.add(root);
        if(root.right!=null) DiGui(root.right,list);


    }


}
