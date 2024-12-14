package JVM;

public class Car {




    public static void main(String[] args) {
        Car car1=new Car();
        Car car2=new Car();
        Car car3=new Car();


        Class<? extends Car> aClass=car1.getClass();


        System.out.println(car1.hashCode());
        System.out.println(car2.hashCode());
        System.out.println(car3.hashCode());

        ClassLoader classLoader=aClass.getClassLoader();
        System.out.println(classLoader); //输出应用程序加载器

        System.out.println(classLoader.getParent());//输出扩展加载器  jre\lib\ext
        System.out.println(classLoader.getParent().getParent());//输出Null 无法获取 rt.jar
        //甚至可以自己改包

            /*
            1、类加载器得到类加载的请求
            2、将这个请求向上委托给父类加载器去完成，一直向上委托，直到启动类加载器
            3、启动加载器检查是否能够加载当前这个类，能加载就结束，使用当前的加载器，否则，抛出异常，
            通知子加载器进行加载
            4、重复步骤3
            Class Not Found

            Java=C++ --
             */
        new Thread().start();

    }
}
