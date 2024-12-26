public class MinFan1318 {
    public static void main(String[] args) {
        int a=2;
        int b=6;
        int c=5;
        System.out.println(minFlips(a,b,c));
    }


    public static int minFlips(int a, int b, int c) {
        if ((a | b) == c) {
            return 0;
        }

        int res = 0;
        for (int i = 0; i < 32; i++) {
            int mask = 1 << i; //底数
//            System.out.println(mask);
            boolean bitA = (a & mask) != 0;
            boolean bitB = (b & mask) != 0;
            boolean bitC = (c & mask) != 0;

            if (!bitA && !bitB && bitC) {
                res++;
            } else if (bitA && bitB && !bitC) {
                res += 2;
            } else if ((bitA || bitB) && !bitC) {
                res++;
            }
        }

        return res;
    }

}
