/*
 * -----------------------------------------------------------------------------
 * © Swisslog AG
 * Swisslog is not liable for any usage of this source code that is not agreed on between Swisslog and the other party.
 * The mandatory legal liability remains unaffected.
 * -----------------------------------------------------------------------------
 */
package al;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class RoundImage48 {

        public static   void rotate(int[][] matrix) {
            int left=0;
            int right=matrix.length-1;
            int top=0;
            int bottom=matrix[0].length-1;
            List<Integer> topnum = new ArrayList<>();
            List<Integer> bottomnum = new ArrayList<>();
            List<Integer> leftnum = new ArrayList<>();
            List<Integer> rightnum = new ArrayList<>();
            while (top < bottom && left < right)
            {

                for (int i = left; i <= right; i++) {
                    int temp=matrix[top][i];
                    topnum.add(temp);
                }
                for (int j = top; j <= bottom; j++) {
                    rightnum.add(matrix[j][right]);
                }
                for (int j = right; j >= left; j--) {
                    bottomnum.add(matrix[bottom][j]);
                }
                for (int j = bottom; j >= top; j--) {
                    leftnum.add(matrix[j][left]);
                }
                int index=0;

                for (int i = right; i >=left; i--) {
                    matrix[bottom][i] = rightnum.get(index);
                    index++;  //底边
                }
                index=0;
                for (int i =top; i < bottom; i++) {
                    matrix[i][right]=topnum.get(index);
                    index++;
                }
                index=0;
                for (int i =left; i<=right; i++) {
                    matrix[top][i] = leftnum.get(index);
                    index++;
                }
                index=0;
                for (int i =bottom; i >= top; i--) {
                    matrix[i][left]=bottomnum.get(index);
                    index++;
                }
                topnum=new ArrayList<>();
                bottomnum=new ArrayList<>();
                leftnum=new ArrayList<>();
                rightnum=new ArrayList<>();

                top++;
                bottom--;
                right--;
                left++;

            }
        }

}