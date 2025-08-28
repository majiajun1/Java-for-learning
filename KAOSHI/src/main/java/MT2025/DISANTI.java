package MT2025;

import javax.management.ConstructorParameters;
import java.util.*;

public class DISANTI {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        ArrayList<Integer[]> list=new ArrayList<>();
        for (int i=0;i<n;i++)
        {
            Integer[] temp= new Integer[2];
            temp[0]=sc.nextInt();
            temp[1]=i;
            list.add(temp);
        }

       Collections.sort(list,(b,a)->a[0]-b[0]);
        List<Integer> list2=new ArrayList<>();




    }
}
