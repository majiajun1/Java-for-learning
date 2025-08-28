package JD;

import java.util.Deque;
import java.util.Scanner;
import java.util.*;

public class JDone {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n=sc.nextInt();
        int k=sc.nextInt();
        sc.nextLine();

        int[] arr=new int[n];

        Deque<Integer> stack=new ArrayDeque<>();
        Map<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<n;i++){
            int curr=sc.nextInt();
            arr[i]=curr;
            map.put(curr,map.getOrDefault(curr,0)+1);
        }
        HashSet<Integer> set=new HashSet<>();


        for(int num:arr) {

            if (set.contains(num)) {
                if (map.containsKey(num)) {
                    map.put(num, map.get(num) - 1);
                    continue;
                }
            }


            while (!stack.isEmpty())
            {
                if(stack.peek()>num && map.get(stack.peek())>0) {
                    int temp=stack.pop();
                    set.remove(temp);
                }else
                {
                    break;
                }
            }

            stack.push(num);
            set.add(num);
            map.put(num,map.getOrDefault(num,0)-1);


        }

        int size=stack.size();
        for (int i=0;i<size;i++)
        {
            System.out.print(stack.removeLast()+" ");
        }

    }
}
