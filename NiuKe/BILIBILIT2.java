import java.util.Arrays;
import java.util.Scanner;

public class BILIBILIT2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int childs=sc.nextInt();
        int apple=sc.nextInt();
        int k=sc.nextInt();
        int[] child=new int[childs];
        Arrays.fill(child,1);
        apple=apple-childs;
        while(apple>0){
            int leftindex=k-2;
            int rightindex=k;
            int index=k-1;
            child[index]++;
            while(leftindex>=0&& apple>0){
                child[leftindex]++;
                apple--;
                leftindex--;
            }


            while(rightindex<=childs-1&& apple>0){
                child[rightindex]++;
                apple--;
                rightindex++;
            }



        }
        System.out.println(child[k-1]);
    }
}
