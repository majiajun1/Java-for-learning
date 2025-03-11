import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class MinRootTri120 {
    public int minimumTotal(List<List<Integer>> triangle) {
        if(triangle == null || triangle.size() == 0) return 0;
        if(triangle.size() == 1) return triangle.get(0).get(0);



        int[][] dp = new int[triangle.size()][triangle.size()];
        for (int i = 0; i < triangle.size(); i++) {
            for (int j = 0; j < triangle.size(); j++) {
                dp[i][j]=1000000;
            }
        }
        dp[0][0] = triangle.get(0).get(0);
        dp[1][0] = dp[0][0]+triangle.get(1).get(0);
        dp[1][1] = dp[0][0]+triangle.get(1).get(1);


        for(int i = 2; i < triangle.size(); i++) {
            for(int j = 0; j < triangle.get(i).size(); j++) {
                if(j==0)
                {
                    dp[i][j] = triangle.get(i).get(j)+dp[i-1][j];
                }
                else if(j>triangle.get(i).size()-1)
                {
                    dp[i][j] = triangle.get(i).get(j)+dp[i-1][j-1];
                }else {
                dp[i][j]=Math.min(dp[i-1][j],dp[i-1][j-1])+triangle.get(i).get(j);}
            }
        }

            int min=Integer.MAX_VALUE;


            for(int j = 0; j < triangle .size(); j++) {
                if(dp[triangle.size()-1][j]<min)
                {
                    min=dp[triangle.size()-1][j];
                }
            }



       return  min;
    }
}
