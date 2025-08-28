package JD;

import java.util.Scanner;

public class JD2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int numofTest = sc.nextInt();
        sc.nextLine();
        for (int i = 0; i < numofTest; i++) {
            int length = sc.nextInt();
            int nums = sc.nextInt();
            sc.nextLine();
            StringBuilder temp = new StringBuilder();
            temp=new StringBuilder(sc.nextLine());

            String[] arr = new String[nums];
            for(int j=0;j<nums;j++)
            {
                int current = sc.nextInt();
                arr[j] = Integer.toBinaryString(current);
            }
            boolean[] visited = new boolean[length];
            if(deal(visited,temp,arr,0))
            {
                System.out.println("YES");
            }else
            {
                System.out.println("NO");
            }


            sc.nextLine();








        }
    }
    public static boolean deal(boolean[] visited,StringBuilder temp,String[] arr,int index)
    {
          if(temp.indexOf(arr[index])==-1||visited[temp.indexOf(arr[index])])
          {
              return false;
          }

          if(index==arr.length-1)
          {
              return true;
          }




            int start=temp.indexOf(arr[index]);
            int len=arr[index].length();
            for(int i=start;i<start+len;i++)
            {
                visited[temp.indexOf(arr[index])]=true;
            }


        boolean flag= false;
        for(int i=index;i<arr.length;i++)

        {
          flag=flag||  deal(visited,temp,arr,i);
        }

            for(int i=start;i<start+len;i++)
            {
                visited[temp.indexOf(arr[index])]=false;
            }


        return flag;
    }

}
