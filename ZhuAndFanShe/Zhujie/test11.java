package Zhujie;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

//通过反射 动态的创建对象
public class test11 {
    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, InvocationTargetException, NoSuchFieldException {
        Class c1 = Class.forName("Zhujie.user");

        //构造一个对象
//        user user1 = (user) c1.newInstance(); //本质上是调用了无参构造器
//        //必须需要无参构造器
//        System.out.println(user1);
//
//        //通过构造器创建对象
//        Constructor constructor = c1.getDeclaredConstructor(String.class, int.class, int.class);
//
//        user user2 = (user) constructor.newInstance("MJJ", 001, 18);
//        System.out.println(user2.age+user2.name);

        //通过反射调用普通方法
        user user3 = (user) c1.newInstance();
        //通过反射获取一个方法
        Method setName = c1.getDeclaredMethod("setName", String.class);
        setName.invoke(user3,"MJJ2");
        //invoke 激活的意思
        //(对象，“方法的值”)
        System.out.println(user3.getName());


        //通过反射操作属性
        user user4=(user) c1.newInstance();
        Field name = c1.getDeclaredField("name");
        name.setAccessible(true);//这个就可以操作私有属性了 需要关闭程序安全检测


        name.set(user4,"MJJ3"); //报错是因为私有属性不能直接操作

        System.out.println(user4.getName());



    }
}
