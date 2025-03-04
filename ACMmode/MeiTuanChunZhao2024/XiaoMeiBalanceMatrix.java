package MeiTuanChunZhao2024;

import java.util.Scanner;

public class XiaoMeiBalanceMatrix {
    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int n = sc.nextInt();
//        sc.nextLine();
//        int[][] matrix = new int[n][n];
//        String[] lines = new String[n]; // 存储后续的 n 行数据
//        for (int i = 0; i < n; i++) {
//            lines[i] = sc.nextLine(); // 逐行读取
//        }
//        int row=0;
//        int col=0;
//        // 示例输出
//        for (String line : lines) {
//            for (int i = 0; i < line.length(); i++) {
//                matrix[row][col] = line.charAt(i) - '0';
//                col++;
//            }
//            row++;
//            col=0;
//        }
//        sc.close();


        //以上读取输入
        int n=4;
        int[] ans=new int[n];
        ans[0]=0;

        int[][] matrix2 = {
            {1, 0, 1, 0},
            {0, 1, 0, 1},
            {1, 1, 0, 0},
            {0, 0, 1, 1}
        };

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                Kuozhan(matrix2,ans,i,j);
            }
        }

        for(int i=0;i<n;i++){
            System.out.println(ans[i]);
        }
    }

    public static void Kuozhan(int[][] matrix,int[] ans,int x,int y)
    {
        int n = 1;
    int sum = 0;
    if(matrix[x][y]==1)
    {
        sum++;
    }else
    {
        sum--;
    }
    while (x + n < matrix.length && y + n < matrix[x].length) {
        // 计算当前正方形子矩阵的 sum
        for (int j = y; j <= y + n; j++) {
            sum += matrix[x + n][j] == 1 ? 1 : -1;
        }
        for (int i = x; i < x + n; i++) {
            sum += matrix[i][y + n] == 1 ? 1 : -1;
        }

        // 判断 sum 是否为 0
        if (sum == 0) {
            ans[n]++;
        }

        n++;
        }

    }


}
