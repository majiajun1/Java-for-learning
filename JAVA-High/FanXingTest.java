public class FanXingTest {
    public static < E > void printArray( E[] inputArray )
   {
      // 输出数组元素
         for ( E element : inputArray ){
            System.out.printf( "%s ", element );
         }
         System.out.println();
    }
    public static <T extends Comparable<T>> T maximum(T x, T y, T z)    //Comparable<T> 接口是Java中的一个泛型接口
   {
      T max = x; // 假设x是初始最大值
      if ( y.compareTo( max ) > 0 ){
         max = y; //y 更大
      }
      if ( z.compareTo( max ) > 0 ){
         max = z; // 现在 z 更大
      }
      return max; // 返回最大对象
   }
    public static void main(String[] args) {
        Integer[] inputArray = {1,2,3,4,5,6,7,8,9};
        printArray( inputArray );
        Double[] doubleArray = {1.0,2.0,3.0,4.0,5.0,6.0,7.0,8.0};
        printArray( doubleArray );
        Character[] charArray = {'A','B','C','D','E','F'};
        printArray( charArray );
        System.out.printf( "%d, %d 和 %d 中最大的数为 %d\n\n",
                   3, 4, 5, maximum( 3, 4, 5 ) );
        int a=1;
        int b=2;
        //int resulttest=a.compareTo(b); //无法实现
        int result2=Integer.valueOf(a).compareTo(b); //自动装箱就好
        System.out.println(result2);
        Integer x=1;
        Integer y=2;
        int result=y.compareTo(x);
        System.out.println(result);

    }


}
