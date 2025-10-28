package YuXin;
import java.util.*;

public class TITWO {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        int n=in.nextInt();
        char[] arr=new char[n];
        in.nextLine();
        String input=in.nextLine();
        arr=input.toCharArray();
        for(int i=1;i<n-1;i++)
        {
            HashSet<Character> set=new HashSet<>();
            set.add('R');
            set.add('G');
            set.add('B');

            char cur = arr[i];
            char last=arr[i-1];
            char next=arr[i+1];
            if(cur==last)
            {
                if(last==next)
                {
                    set.remove(last);
                    Iterator<Character> it=set.iterator();
                    arr[i]=it.next();
                    continue;
                }else
                {
                    set.remove(last);
                    set.remove(next);
                    Iterator<Character> it=set.iterator();
                    arr[i]=it.next();
                    continue;
                }
            }

        }
         HashSet<Character> set=new HashSet<>();
            set.add('R');
            set.add('G');
            set.add('B');
        if(arr[n-1]==arr[n-2])
        {
            set.remove(arr[n-2]);
            Iterator<Character> it=set.iterator();
            arr[n-1]=it.next();
        }

        StringBuilder sb=new StringBuilder();
        for(char c:arr)
        {
            sb.append(c);
        }
        System.out.println(sb.toString());
    }
}
