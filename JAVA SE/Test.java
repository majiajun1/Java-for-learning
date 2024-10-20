

public class Test{
   public void pupAge(){
      int age = 0;
      age = age + 7;
      System.out.println("小狗的年龄是: " + age);
   }

   public static void main(String[] args){
      Test test = new Test();
      test.pupAge();

      int [] nums = {1,2,3,4,5,6,7,8,9};
      for (int x :nums)
      {
         System.out.println(x);

      }
   }
}