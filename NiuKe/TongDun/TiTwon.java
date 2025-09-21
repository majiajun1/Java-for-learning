package TongDun;

import java.math.BigInteger;
import java.util.*;

public class TiTwon {
         public static void main(String[] args) {
            Scanner in = new Scanner(System.in);
            // 注意 hasNext 和 hasNextLine 的区别
            String input = in.nextLine();
            String[] strs=input.split(",");

            boolean[] visited=new boolean[strs.length];
            PriorityQueue<BigInteger> ans=new PriorityQueue<>();
            List<String> cur=new ArrayList<>();
            Deal(strs,visited,cur,ans);

             System.out.println(ans.peek());

         }

        public static void Deal(String[] inputNum, boolean[] visited,List<String> cur,PriorityQueue<BigInteger> ans)
        {
            if(cur.size()==inputNum.length)
            {
                StringBuilder temp=new StringBuilder();
                for(int i=0;i<inputNum.length;i++)
                {
                    temp.append(cur.get(i));
                }
                ans.add(new BigInteger(temp.toString()));
                return;
            }

            for(int i=0;i<inputNum.length;i++)
            {
                if(visited[i]==false) {
                    visited[i] = true;
                    cur.add(inputNum[i]);
                    Deal(inputNum, visited, cur, ans);
                    cur.remove(cur.size() - 1);
                    visited[i] = false;
                }
            }
        }
}
