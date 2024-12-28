import java.util.ArrayList;
import java.util.List;

public class MostCandy_1431 {
    public static void main(String[] args) {
        int[] candies={2,3,5,1,3};
        int extraCandies=3;
        List<Boolean> result=new ArrayList<>();
        result=kidsWithCandies(candies,extraCandies);
        System.out.println(result);

    }


    public static List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        int max=0;
        List<Boolean> result=new ArrayList<>();
        for(int i:candies)
        {
            if(i>max)
            {max=i;}
        }
        for(int i=0;i<candies.length;i++)
        {
            if(candies[i]+extraCandies>=max)
            {
                result.add(true);
            }
            else {result.add(false);}
        }
        return result;
    }
}
