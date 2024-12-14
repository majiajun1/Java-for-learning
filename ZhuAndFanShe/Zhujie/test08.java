package Zhujie;

//测试类什么时候会初始化
public class test08 {
     static{
         System.out.println("main类被加载");
     }

    public static void main(String[] args) throws ClassNotFoundException {
        //1.主动引用
       // Son son=new Son();

        //2.反射也会产生主动引用
        //Class.forName("Zhujie.Son");

        //不会产生类的引用的方法   通过子类引用父类的静态变量，不会导致子类初始化

        //System.out.println(Son.b);

        //Son[] array = new Son[10];
        //常量在链接阶段就分配好了
        System.out.println(Son.M);

    }

}



class Father
{
    static
    {
        System.out.println("父类被加载");
    }
    static int b=2;
}

class Son extends Father
{
    static
    {
        System.out.println("子类被加载");
        m=300;
    }

    static int m=100;
    static final int M=1;
}