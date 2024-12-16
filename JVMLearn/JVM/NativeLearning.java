package JVM;

public class NativeLearning {
    public static void main(String[] args) {
        new Thread(()->{

        },"T1").start();



    }
    //native:凡是带了native关键字的方法，说明java的作用范围达不到了
    //会去调用底层C语言的库！
    //会进入本地方法栈
    //调用本地方法接口， JNI
    //JNI作用：扩展JAVA的使用，融合不同的编程语言为Java所用！
    //最初：C、C++
    //Java诞生的时候 C和C++横行   想要立足、必须要用C和C++的程序
    //它在内存区域中专门开辟了一条标记区域：Native Method Stack,登记natvie方法
    //在最终执行的时候 加载本地方法库中的方法  通过JNI

    //JAVA程序驱动打印机，管理系统
    //掌握即可，在企业级应用中较为少见！
    private native void hello();


    //调用其他接口：   Socket  werservice  http


}
