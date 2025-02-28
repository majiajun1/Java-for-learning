public class SearchMatrix74 {
    public boolean searchMatrix(int[][] matrix, int target) {
        //先找行嘛
        int n = matrix.length;
        int m = matrix[0].length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (matrix[i][j] == target) {
                    return true;
                }else if(matrix[i][j] > target)
                {
                    return false;
                }
            }
        }
        return false;
    }
}
