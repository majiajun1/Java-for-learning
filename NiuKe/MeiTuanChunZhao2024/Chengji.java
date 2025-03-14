package MeiTuanChunZhao2024;

    import java.util.*;
public class Chengji {


// 注意类名必须为 Main, 不要有任何 package xxx 信息

    static int ans=0;
    static int n=0;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        n=in.nextInt();
        int k=in.nextInt();
        int Chushu=1;
        for(int i=0;i<k;i++)
        {
            Chushu=Chushu*10;
        }
        in.nextLine();
        ArrayList<Integer> list=new ArrayList<Integer>();

        int Chengji=1;
        for(int i=0;i<n;i++)
        {
            int temp=in.nextInt();
            Chengji=Chengji*temp;
            list.add(temp);
        }
        Collections.sort(list);
        for(int i=0;i<n;i++)
        {
            DiGui(Chengji,Chushu,list,i+1);
        }
        System.out.println(ans);

    }

public static void DiGui(int Chengji, int Chushu, ArrayList<Integer> list, int index) {
        if (index >= n) {
            return;
        }

        int now = list.get(index);
        Chengji = Chengji / now;

        // 判断条件：如果Chengji能被Chushu整除，则计数
        if (Chengji % Chushu == 0) {
            ans++;  // 满足条件，增加计数

            // 从当前index+1继续递归，避免重复计算
            for (int i = index + 1; i < n; i++) {
                DiGui(Chengji, Chushu, list, i);
            }
        }
    }
}

