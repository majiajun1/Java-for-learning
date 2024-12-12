package ZhuAndFanShe;


import java.util.ArrayList;
import java.util.List;

public class LessonOne extends Object {
     @Override
    public String toString() {
         return super.toString();
     }
     @Deprecated
     public static void test(){
            System.out.println("Deprecated");
     }

    @SuppressWarnings("all")
     public void test2(){
         List list = new ArrayList();
     }

     public static void main(String[] args) {
        test();
    }
}
