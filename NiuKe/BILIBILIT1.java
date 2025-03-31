import java.util.Arrays;
import java.util.Scanner;

public class BILIBILIT1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int[] arr=new int[a];
        sc.nextLine();
        for(int i=0;i<a;i++){
            arr[i]=sc.nextInt();
        }
        Arrays.sort(arr);
        int left=0,right=arr.length-1;
        int ans=0;
        for(int i=0;i<b;i++)
        {
            if(left<=right){
            ans+=arr[right--]-arr[left++];} else
            {
                break;
            }
        }
        System.out.println(ans);

    }
}
