package Zhujie;

public class test09 {

    public static void main(String[] args) throws ClassNotFoundException {

        //获得系统类的加载器
        ClassLoader systemClassLoader = ClassLoader.getSystemClassLoader();
        System.out.println(systemClassLoader);

        //获得系统类加载器的父类加载器 -->扩展类加载器

        ClassLoader parent = systemClassLoader.getParent();
        System.out.println(parent);

        //获得扩展类加载器的父类加载器-->根加载器
        ClassLoader parent1 = parent.getParent();
        System.out.println(parent1);  //无法得到  打印null


        //测试当前类是哪个加载器加载的
        ClassLoader classLoader = Class.forName("Zhujie.test09").
                getClassLoader();
        System.out.println(classLoader);

        //测试JDK内置的类是哪个加载器加载的
        classLoader=Class.forName("java.lang.Object")
                .getClassLoader();
        System.out.println(classLoader);  //无法得到 根加载器

        //如何获得系统类加载器可以加载的路径
        System.out.println(System.getProperty("java.class.path"));
        /*
        D:\jdk8\jre\lib\charsets.jar;
        D:\jdk8\jre\lib\deploy.jar;
        D:\jdk8\jre\lib\ext\access-bridge-64.jar;
        D:\jdk8\jre\lib\ext\cldrdata.jar;
        D:\jdk8\jre\lib\ext\dnsns.jar;
        D:\jdk8\jre\lib\ext\jaccess.jar;
        D:\jdk8\jre\lib\ext\jfxrt.jar;
        D:\jdk8\jre\lib\ext\localedata.jar;
        D:\jdk8\jre\lib\ext\nashorn.jar;
        D:\jdk8\jre\lib\ext\sunec.jar;
        D:\jdk8\jre\lib\ext\sunjce_provider.jar;
        D:\jdk8\jre\lib\ext\sunmscapi.jar;
        D:\jdk8\jre\lib\ext\sunpkcs11.jar;
        D:\jdk8\jre\lib\ext\zipfs.jar;
        D:\jdk8\jre\lib\javaws.jar;
        D:\jdk8\jre\lib\jce.jar;
        D:\jdk8\jre\lib\jfr.jar;
        D:\jdk8\jre\lib\jfxswt.jar;
        D:\jdk8\jre\lib\jsse.jar;
        D:\jdk8\jre\lib\management-agent.jar;
        D:\jdk8\jre\lib\plugin.jar;
        D:\jdk8\jre\lib\resources.jar;
        D:\jdk8\jre\lib\rt.jar;
        D:\Document\JAVA\out\production\Document;
        D:\IntelliJ IDEA 2024.1\lib\idea_rt.jar
         */


        //双亲委派机制

    }
}
