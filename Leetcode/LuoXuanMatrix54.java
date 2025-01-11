import java.util.ArrayList;
import java.util.List;
public class LuoXuanMatrix54 {
    public static void main(String[] args) {
        int[][] a = {{1,2,3},{4,5,6},{7,8,9}};
        System.out.println(spiralOrder(a));
    }
public static List<Integer> spiralOrder(int[][] matrix) {
    List<Integer> list = new ArrayList<>();
    if (matrix == null || matrix.length == 0) {
        return list; // 边界条件：空矩阵
    }

    int top = 0;               // 上边界
    int bottom = matrix.length - 1; // 下边界
    int left = 0;              // 左边界
    int right = matrix[0].length - 1; // 右边界

    while (top <= bottom && left <= right) {
        // 从左到右
        for (int col = left; col <= right; col++) {
            list.add(matrix[top][col]);
        }
        top++; // 收缩上边界

        // 从上到下
        for (int row = top; row <= bottom; row++) {
            list.add(matrix[row][right]);
        }
        right--; // 收缩右边界

        // 从右到左（需要判断是否还有行）
        if (top <= bottom) {
            for (int col = right; col >= left; col--) {
                list.add(matrix[bottom][col]);
            }
            bottom--; // 收缩下边界
        }

        // 从下到上（需要判断是否还有列）
        if (left <= right) {
            for (int row = bottom; row >= top; row--) {
                list.add(matrix[row][left]);
            }
            left++; // 收缩左边界
        }
    }

    return list;
}
}
