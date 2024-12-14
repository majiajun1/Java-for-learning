package Zhujie;

//分析性能问题

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class test12 {

    //普通方式调用
    public  static void test01()
    {
        user user1=new user();
        long startTime=System.currentTimeMillis();

        for (int i = 0; i < 1000000000; i++) {
            user1.getName();
        }

        long endTime=System.currentTimeMillis();

        System.out.println("普通方式"+(endTime-startTime)+"ms");
    }

    //反射方式调用
    public static void test02() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        user user2=new user();
        Class c1=user2.getClass();
        Method getName = c1.getDeclaredMethod("getName", null);


        long startTime=System.currentTimeMillis();

        for (int i = 0; i < 1000000000; i++) {
            getName.invoke(user2,null);
        }

        long endTime=System.currentTimeMillis();

        System.out.println("反射方式"+(endTime-startTime)+"ms");
    }

    //关闭检测
    public static void test03() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        user user2=new user();
        Class c1=user2.getClass();
        Method getName = c1.getDeclaredMethod("getName", null);

        getName.setAccessible(true);

        long startTime=System.currentTimeMillis();

        for (int i = 0; i < 1000000000; i++) {
            getName.invoke(user2,null);
        }

        long endTime=System.currentTimeMillis();

        System.out.println("关闭检测"+(endTime-startTime)+"ms");
    }


    public static void main(String[] args) throws InvocationTargetException, NoSuchMethodException, IllegalAccessException {
        test01();
        test02();
        test03();
    }


}
