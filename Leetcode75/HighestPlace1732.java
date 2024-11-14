public class HighestPlace1732 {
    public static void main(String[] args) {
        int[] input={-4,-3,-2,-1,4,3,2};
        int ans=largestAltitude(input);
        System.out.println(ans);

    }
    public static int largestAltitude(int[] gain) {
        int max=0;
        int temp=0;
        for (int i = 0; i < gain.length; i++) {
            temp=temp+gain[i];

            if(temp>max){
                max=temp;
            }
        }

        return max;
    }
}
