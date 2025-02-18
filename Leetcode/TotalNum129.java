import java.util.ArrayList;

public class TotalNum129 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(4);
        root.right=new TreeNode(0);
        root.left=new TreeNode(9);
        root.left.left=new TreeNode(5);
        root.left.right=new TreeNode(1);
        System.out.println(sumNumbers(root));
    }
    public static int sumNumbers(TreeNode root) {
        StringBuilder sb=new StringBuilder();
        ArrayList<String> list=new ArrayList<>();
        DiGui(root,sb,list);
        int sum=0;
        for (String a:list)
        {
            sum+=Integer.parseInt(a);
        }
        return sum;
    }


    public static void DiGui(TreeNode root,StringBuilder sb, ArrayList<String> list)
    {
        if(root==null)return;

        StringBuilder sb1=new StringBuilder(sb);
        sb1.append(root.val);
        if(root.left==null && root.right==null)
        {
            list.add(sb1.toString());
        }else
        {
            DiGui(root.left,sb1,list);
            DiGui(root.right,sb1,list);
        }

    }

}
