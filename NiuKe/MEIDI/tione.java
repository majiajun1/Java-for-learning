package MEIDI;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class tione {
    public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            String str = sc.nextLine();
            if(str.length()>100)
            {
                str=str.substring(0,100);
            }
            List<Integer> list=new ArrayList<>();
            String[] strs=str.split(" ");
            for(String s:strs)
            {
                try{
                    int num = Integer.parseInt(s);
                list.add(num);
                }catch (Exception e){
                    continue;
                }

            }
            list.sort(Collections.reverseOrder());
            String result=list.stream().map(String::valueOf).collect(Collectors.joining(","));
            System.out.println(result);
    }
}
