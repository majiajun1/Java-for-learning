public class FaTang135 {
    public static void main(String[] args) {
        int[] ratings={1,2,87,87,87,2,1};
        System.out.println(candy(ratings));
    }


     public static int candy(int[] ratings) {
         int[] candies = new int[ratings.length];
         for (int i = 0; i < ratings.length; i++) {
             candies[i] = 1;
         }

         int index1 = 0;
         while (index1 < ratings.length - 1) {
             int qian = ratings[index1];
             int hou = ratings[index1 + 1];
             if (qian > hou && candies[index1] <= candies[index1 + 1]) {
                 candies[index1] = candies[index1 + 1] + 1;
             } else if (hou > qian && candies[index1] >= candies[index1 + 1]) {
                 candies[index1 + 1] = candies[index1] + 1;
             }

             index1++;
         }



         int index2 = ratings.length - 1;
         while (index2 > 0) {
            int hou = ratings[index2];
            int qian = ratings[index2 - 1];
            if (qian > hou && candies[index2 - 1] <= candies[index2]) {
                candies[index2 - 1] = candies[index2] + 1;
            }
            index2--;
        }




        /*
        左到右遍历：

确保每个学生的糖果数比左边评分低的学生多（单向约束）。
但是，这无法保证右侧评分更低的学生糖果数也少。
右到左遍历：

确保每个学生的糖果数比右边评分低的学生多（补充双向约束）。

         */


         int answer = 0;
         for (int i : candies) {
             answer += i;
         }
         return answer;

     }
}
