package XiaoHongShu2024Chun;

import java.util.*;

public class T2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int CountOfItems= sc.nextInt();

        sc.nextLine();
        HashSet<String> set=new HashSet<>();
        String str=sc.nextLine();
        String[] strs=str.split(" ");
        for(String s:strs)
        {
            set.add(s);
        }

        HashMap<Integer,String> map=new HashMap<>();
        ArrayList<Integer> list=new ArrayList<>();

        for(int i = 0; i < CountOfItems; i++){
            String temp=sc.nextLine();
            String[] temps=temp.split(" ");

            HashSet<String> thisset=new HashSet<>();
            String temp2=sc.nextLine();
            String[] thisset2=temp2.split(" ");
            for(String s:thisset2)
            {
                thisset.add(s);
            }
            Set<String>  output=new HashSet<>(set);
            output.retainAll(thisset);
            if(!map.containsKey(output.size())){
                map.put(output.size(),temps[0]);
                list.add(output.size());
            }



        }
        Collections.sort(list);
        for(int i=list.size()-1;i>=0;i--)
        {
            int value=list.get(i);
            System.out.println(map.get(value));
        }


    }
}
