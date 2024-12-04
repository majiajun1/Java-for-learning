//静态内部类

public class HolderLearning {

     private HolderLearning() {


     }
     public static HolderLearning getInstance() {
          return InnerClass.INSTANCE;
     }
     public static class InnerClass{

          private static final HolderLearning INSTANCE = new HolderLearning();
     }



}
