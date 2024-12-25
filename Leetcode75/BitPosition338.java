public class BitPosition338 {
    public static void main(String[] args) {
        int n=2;
        int[] ans=countBits(n);
        for (int i:ans)
        {
            System.out.println(i);
        }
    }


    public static int[] countBits(int n) {
        int[] ans = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            ans[i] = Integer.bitCount(i);
        }

        return ans;
    }

}
