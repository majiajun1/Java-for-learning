import java.util.Arrays;
public class TestArray {
   public static void main(String[] args) {
      // 数组大小
      int size = 10;
      // 定义数组
      double[] myList = new double[size];
      myList[0] = 5.6;
      myList[1] = 4.5;
      myList[2] = 3.3;
      myList[3] = 13.2;
      myList[4] = 4.0;
      myList[5] = 34.33;
      myList[6] = 34.0;
      myList[7] = 45.45;
      myList[8] = 99.993;
      myList[9] = 11123;
      // 计算所有元素的总和
      double total = 0;
      for (int i = 0; i < size; i++) {
         total += myList[i];
      }
      System.out.println("总和为： " + total);
       double[] myList2 = {1.9, 20.9, 3.4, 3.5};


      // 打印所有数组元素
      for (double element: myList2) {
         System.out.println(element);

      }
      System.out.println("xxxxxxxxxxxxxxxxxxxxxx");
      Arrays.sort(myList2);
      for(double x:myList2)
      {
         System.out.println(x);
      }

   }
}