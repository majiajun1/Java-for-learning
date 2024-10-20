

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
      Character ch ='a';
      char c=ch;
      System.out.println(c);
      String str="Runoob";
      String str3="Runoob";
      String str2=new String("Runoob");  //是指针
      System.out.println(str3==str);
       StringBuilder sb = new StringBuilder(10);
        sb.append("Runoob..");
        System.out.println(sb);
        sb.append("!");
        System.out.println(sb);
        sb.insert(8, "Java");
        System.out.println(sb);
        sb.delete(5,8);
        System.out.println(sb);

   }
}