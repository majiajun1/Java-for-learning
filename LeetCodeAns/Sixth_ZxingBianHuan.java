public class Sixth_ZxingBianHuan {
    public static void main(String[] args) {
        String a="AB";
        int nunRows=2;
        String ans=convert(a,nunRows);
        System.out.println(ans);

    }

    public static String convert(String s, int numRows) { //暴力解

        Character[][] matrix = new Character[numRows][s.length()];
        if (numRows == 1){return s;}
        int indexHang=0;
        int indexLie=0;
        int count=0;
        while(count<s.length()){
            matrix[indexHang][indexLie]=s.charAt(count);
            indexHang=indexHang+1;

            count++;
            if(indexHang==numRows&&numRows>1)
            {

                indexHang=indexHang-1;
                while(indexHang!=0){
                    if(count==s.length()){break;}
                    indexHang=indexHang-1;
                    indexLie=indexLie+1;
                    matrix[indexHang][indexLie]=s.charAt(count);
                    count=count+1;

                }
                indexHang=indexHang+1;
         }

        }
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                // 检查当前位置是否为空，不为空则加入到字符串中
                if (matrix[i][j] != null) {
                    result.append(matrix[i][j]);
                }
            }
        }



        String result1 = result.toString();
        return result1;
    }
}
