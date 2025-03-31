import java.util.ArrayList;
import java.util.Scanner;

public class JIBITET1 {
    public static void main(String[] args) {
        long mod = 10000009;
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int d=sc.nextInt();
        int m=sc.nextInt();
        sc.nextLine();
        ArrayList<Integer[]> list = new ArrayList<>();
        list.add(new Integer[n]);//占0位
        for(int i=0;i<n;i++){
            int p=sc.nextInt();
            Integer[] arr = new Integer[p+1];
            for(int j=0;j<p+1;j++){
                arr[j]=sc.nextInt();
            }
            list.add(arr);
            sc.nextLine();
        }

        for(int i=0;i<m;i++){
            int p=sc.nextInt();
            int l=sc.nextInt();
            int r=sc.nextInt();
            int flag=0;

            if((i+1)%2==0)
            {
                flag=1;
            }else
            {
                flag=-1;
            }
            ArrayList<Integer > list2 = new ArrayList<>();
           for(int k=0;k<p+1;k++)
           {
               list2.add(sc.nextInt());
           }

            for(int j=l;j<=r;j++){
                Integer[] temp=list.get(j);
                for(int k=0;k<Math.min(p+1,list2.size());k++)
                {
                    temp[k]=temp[k]+flag*list2.get(k);
                }

            }
            sc.nextLine();
        }

        for(int i=1;i<=n;i++){
            Integer[] arr = list.get(i);
            int output=0;
            output+=output+arr[0];
             for(int j=1;j<arr.length;j++){
                 output+=arr[j]*Math.pow(233,j);
             }
             System.out.print(output%mod);
             System.out.print(" ");
        }

    }
}
