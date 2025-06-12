import java.util.*;

public class Deepnode1123 {
    public TreeNode lcaDeepestLeaves(TreeNode root) {
        ArrayList<ArrayList> level =new ArrayList<>();
        ArrayDeque<TreeNode> deque = new ArrayDeque<>();
        HashMap<TreeNode, TreeNode> FatherPoint = new HashMap<>();
        deque.add(root);
        while(!deque.isEmpty()){
            int size = deque.size();
            ArrayList<TreeNode> temp = new ArrayList<>();
            for(int i = 0; i < size; i++){
                TreeNode cur=deque.poll();
                temp.add(cur);
                if(cur.left != null){
                    deque.add(cur.left);
                    FatherPoint.put(cur.left, cur);
                }
                if(cur.right != null){
                    deque.add(cur.right);
                    FatherPoint.put(cur.right, cur);
                }
            }
            level.add(temp);
        }
        ArrayList<TreeNode> lastlevl=level.get(level.size()-1);
        if(lastlevl.size()==1){
            return lastlevl.get(0);
        }


         List<Set<TreeNode>> paths = new ArrayList<>();
    for (TreeNode leaf : lastlevl) {
        Set<TreeNode> path = new HashSet<>();
        TreeNode curr = leaf;
        while (curr != null) {
            path.add(curr);
            curr = FatherPoint.get(curr);
        }
        paths.add(path);
    }


    TreeNode lca = root;
    while (true) {
        boolean allContainLeft = false;
        boolean allContainRight = false;
        if (lca.left != null) {
            allContainLeft = true;
            for (Set<TreeNode> path : paths) {
                if (!path.contains(lca.left)) {
                    allContainLeft = false;
                    break;
                }
            }
        }
        if (allContainLeft) {
            lca = lca.left;
            continue;
        }
        if (lca.right != null) {
            allContainRight = true;
            for (Set<TreeNode> path : paths) {
                if (!path.contains(lca.right)) {
                    allContainRight = false;
                    break;
                }
            }
        }
        if (allContainRight) {
            lca = lca.right;
            continue;
        }
        break;
    }
    return lca;


    }
}
