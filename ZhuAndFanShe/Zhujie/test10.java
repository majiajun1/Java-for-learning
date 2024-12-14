package Zhujie;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

//获得类的信息
public class test10 {

    public static void main(String[] args) throws ClassNotFoundException, NoSuchFieldException, NoSuchMethodException {

         Class  c1 = Class.forName("Zhujie.user");

//        user a=new user();
//        Class c1= user.class;
    //获得类的名字
        System.out.println(c1.getName());
        System.out.println(c1.getSimpleName());
        
        //获得类的属性
        System.out.println("===============");
//        Field[] fields = c1.getFields(); //只能找到public属性
//        for (Field f : fields) {
//            System.out.println(f);
//        }


        Field[] declaredFields = c1.getDeclaredFields();
        //能找到全部的属性
        for (Field f : declaredFields) {
            System.out.println(f);
        }


        //Field name = c1.getField("name"); //private属性找不到
        Field name=c1.getDeclaredField("name");
        System.out.println(name);

        //获得类的方法
        Method[] methods = c1.getMethods();//获得本类及其父类的全部public方法 包括object类
        Method[] declaredMethods = c1.getDeclaredMethods();//获得本类的所有方法
        for (Method m : declaredMethods) {
            System.out.println(m);
        }
        System.out.println("=================");

        for (Method m : methods) {
            System.out.println("正常"+m);
        }
        System.out.println("=============");
        //获得指定方法
        Method getName = c1.getMethod("getName", null);
        Method setName=c1.getMethod("setName", String.class);
        System.out.println(getName);
        System.out.println(setName);
        System.out.println("==============");
        //获得构造器
        Constructor[] constructors = c1.getConstructors(); //获得本类及其父类的public方法
        Constructor[] declaredConstructors = c1.getDeclaredConstructors(); //获得本类方法

        for (Constructor c : constructors) {
            System.out.println(c);
        }
        System.out.println("==============");
        for (Constructor c : declaredConstructors) {
            System.out.println(c);
        }


        //获得指定构造器
        Constructor declaredConstructor = c1.getDeclaredConstructor(String.class, int.class, int.class);
        System.out.println("指定"+declaredConstructor);
    }
}



