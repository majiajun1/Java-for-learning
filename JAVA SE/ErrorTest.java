public class ErrorTest {
    public static void main(String[] args) {
      try{
         int a[] = new int[2];
         System.out.println("Access element three :" + a[3]);
      }catch(ArrayIndexOutOfBoundsException e){
         System.out.println("Exception thrown  :" + e);
      }
      System.out.println("Out of the block");
    }
    //int a[] = new int[2];
    //try{   //不能两个trycatch  这里只是展示  运行不了
     //  System.out.println("Access element three :" + a[3]);
    //}catch(ArrayIndexOutOfBoundsException e){
   //   System.out.println("Exception thrown  :" + e);
   //}
    //finally{
    //   a[0] = 6;
    //   System.out.println("First element value: " +a[0]);
    //   System.out.println("The finally statement is executed");
    //}

}
