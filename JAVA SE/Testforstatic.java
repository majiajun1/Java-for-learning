import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodType;

public class Testforstatic {
    public static void main(String[] args) throws Throwable {
        StaticLearn sl = new StaticLearn();
        sl.test = 2;
        sl.Display();
        sl.Displau();
        StaticLearn.Displau();

        // 获取 Displau() 方法的句柄

    }
}

class StaticLearn {
    int test;

    static void Displau() {
        System.out.println("Test");

    }

    void Display() {
        System.out.println(test);
    }

}
