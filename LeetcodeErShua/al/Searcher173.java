package al;

import java.io.DataInput;
import java.util.ArrayList;

public class Searcher173 {
class BSTIterator {
    ArrayList<Integer> list;
    int index = -1;
    public BSTIterator(TreeNode root) {
        list = new ArrayList<>();
        diGui(root);

    }

    public int next() {
        return list.get(++index);
    }

    public boolean hasNext() {
        if(index < list.size() - 1)
        {
            return true;
        }else
        {
            return false;
        }

    }

    public  void diGui(TreeNode cur)
    {
        if(cur == null)
        {
            return;
        }

        diGui(cur.left);
        list.add(cur.val);
        diGui(cur.right);
    }

}
}
