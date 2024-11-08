public class Seventh_ZhengShuFanZhuan {
    public static void main(String[] args) {
        int x=123;
        int ans=reverse(x);
        System.out.println(ans);

    }
    public static  int reverse(int x) {
        int ans = 0;
       while (x != 0) {
           if (ans > 214748364 || ans < -214748364) return 0;
           int a = x % 10;
           ans = 10 * ans + a;
           x /= 10;
       }
       return ans;
    }
}
