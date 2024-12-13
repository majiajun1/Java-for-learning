package Zhujie;

import java.lang.annotation.*;

//测试元注解
@MyAnnotation
public class TestYuanZhuJie {

    @MyAnnotation
  public void test()
  {

  }
}
//Target 表示我们的注解可以用在哪些地方
@Target(value = {ElementType.METHOD,ElementType.TYPE})
//Retention 表示我们的注解在什么地方还有效
//runtime >class >sources
@Documented    //说明该注解将被包含在javadoc中

//Inherited 子类可以继承父类的注解
@Retention(value = RetentionPolicy.RUNTIME)
 @interface MyAnnotation
 {

 }