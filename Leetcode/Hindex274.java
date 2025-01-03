import java.util.Arrays;

public class Hindex274 {
    public static void main(String[] args) {
        int[] citations={11,15};
        System.out.println(hIndex(citations));

    }

    public static int hIndex(int[] citations) {
        int h=1;
        Arrays.sort(citations);
        if (citations.length==1)
        {
            if (citations[0]!=0)
            {
                return h;
            }
            else return 0;
        }
        for (int i=citations.length-1;i>=0;i--)
        {
            if (citations[i]>=h)
            {
                h++;
            }

        }

        return h-1;

    }
}
