import java.util.*;


public class TreeMaxRootSum124 {


    public static void main(String[] args) {
        TreeNode root = new TreeNode(-2);
        root.left = new TreeNode(-1);
//        root.right = new TreeNode(3);
        System.out.println(maxPathSum(root));
    }


        public static int maxPathSum(TreeNode root) {
        HashMap<TreeNode, TreeNode> father = new HashMap<>();//存父亲
        ArrayList<TreeNode> list = new ArrayList<>(); //遍历下树的节点 快速获取
        ArrayList<Integer> sum = new ArrayList<>();
        HashSet<TreeNode> visited = new HashSet<>();//防止重复
        if(root == null) return 0;


        father.put(root, null);
        SaveTree(root,father,list);

        if(list.size() == 1) return root.val;
        for(TreeNode node: list){
            visited = new HashSet<>();
            getValue(node,father,0,sum,visited);
        }

        int max = Integer.MIN_VALUE;
        for (Integer i : sum) {
            max = Math.max(max,i);
        }

        return max;
    }


    public static void SaveTree(TreeNode root, HashMap<TreeNode, TreeNode> father, ArrayList<TreeNode> list) {
        if (root == null) return;
        list.add(root);

        if (root.left != null) {
            father.put(root.left, root);
            SaveTree(root.left, father, list);
        }
        if (root.right != null) {
            father.put(root.right, root);
            SaveTree(root.right, father, list);
        }
}



    public static void  getValue(TreeNode root,HashMap<TreeNode, TreeNode> father,int cursum,ArrayList<Integer> sum, HashSet<TreeNode> visited)
    {
        if(root==null) return;

        int currsumtemp=root.val+cursum;
        sum.add(currsumtemp);
        visited.add(root);


        TreeNode fathernode=father.get(root);
        TreeNode left=root.left;
        TreeNode right=root.right;
        if(fathernode!=null&&!visited.contains(fathernode))
        {
            getValue(fathernode,father,currsumtemp,sum,visited);
        }

        if(left!=null&&!visited.contains(left))
        {
            getValue(left,father,currsumtemp,sum,visited);
        }

        if (right!=null&&!visited.contains(right))
        {
            getValue(right,father,currsumtemp,sum,visited);
        }

        if((left==null&&right==null)&&(visited.contains(fathernode)||fathernode==null))
        {


            visited.remove(root);
            return;
        }


    }



//        public static int maxPathSum(TreeNode root) {
//            ArrayList<Integer> list1 = new ArrayList<>();
//            ArrayList<TreeNode> list2 = new ArrayList<>();   //能不能这样  有连通性就添加上去
//            HashSet<TreeNode> set1 = new HashSet<>();
//            HashMap<TreeNode, TreeNode> map1 = new HashMap<>();
//            SaveTree(root,map1,list2,list1);
//
//            List<Integer> indices = new ArrayList<>();
//            for (int i = 0; i < list1.size(); i++) {
//                indices.add(i);
//            }
//
//        // 按照 list1 进行降序排序
//        indices.sort((i, j) -> list1.get(j) - list1.get(i));
//
//        // 重新排序 list1 和 list2
//        ArrayList<Integer> sortedList1 = new ArrayList<>();
//        ArrayList<TreeNode> sortedList2 = new ArrayList<>();
//        for (int index : indices) {
//            sortedList1.add(list1.get(index));
//            sortedList2.add(list2.get(index));
//        }
//        int sum=0;
//        int index=0;
//        int index2=1;
//        while (index < sortedList1.size()) {
//            sum=sum+sortedList1.get(index);
//            TreeNode node = new TreeNode();
//            node=sortedList2.get(index);
//            set1.add(node);
//            TreeNode node2 = sortedList2.get(index2);
//            while (((node.left != node2||node.right != node2||map1.get(node)!=node2) ||set1.contains(node2)  )&&index2<sortedList1.size()) {
//                node2 = sortedList2.get(index2);
//                index2++;
//
//            }
//
//
//            index=index2;
//        }
//        return sum;
//
//
//
//
//        }
//
//


}
