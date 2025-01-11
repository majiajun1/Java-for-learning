import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class MatrixToZero73 {
    public static void main(String[] args) {
        int[][] matrix={{1,1,1}, {1,0,1},{1,1,1}};

    }
    public static void setZeroes(int[][] matrix) {
        HashSet<Integer> zeroRow =  new HashSet<>();
        HashSet<Integer> zeroCol = new HashSet<>();
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == 0) {
                    zeroRow.add(i);
                    zeroCol.add(j);
                }
            }
        }
        for (int i :zeroRow)
        {
            for (int j=0;j<matrix[0].length;j++)
            {
                matrix[i][j]=0;
            }
        }
        for (int i:zeroCol)
        {
            for (int j=0;j<matrix.length;j++)
            {
                matrix[j][i]=0;
            }
        }
    }
}
