package Zhujie;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

public class test03 {

    //@MyAnnotation2(name="MJJ")
    //注解可以显示赋值，没有默认值就必须赋值
    @MyAnnotation2(schools={"MJJ2","sdad"}) //也没有顺序
    public void test(){

    }
    @MyAnnotation3("MJJ") //只有一个
    public void test2()
    {}


}



@Target({ElementType.TYPE,ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@interface MyAnnotation2 {
    //注解的参数：参数类型+参数名（）；
    String name() default "MJJ";
    int age() default 18;
    int id() default -1;
    String[]  schools();
}

@Target({ElementType.TYPE,ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@interface MyAnnotation3
{
    String value()  ;
}