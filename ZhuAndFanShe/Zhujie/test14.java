package Zhujie;

import java.lang.annotation.*;
import java.lang.reflect.Field;

public class test14 {

    public static void main(String[] args) throws ClassNotFoundException, NoSuchFieldException {
        Class c1 = Class.forName("Zhujie.Student2");
        
        
        //通过反射获得注解
        Annotation[] annotations = c1.getAnnotations();
        for (Annotation annotation : annotations) {
            System.out.println(annotation);
        }

        //获得注解的value的值
        Tablekuang tablekuang =(Tablekuang) c1.getAnnotation(Tablekuang.class);
        String value = tablekuang.value();
        System.out.println(value);

        //获得类指定的注解
        Field f = c1.getDeclaredField("id");
        Fieldkuang annotation = f.getAnnotation(Fieldkuang.class);
        System.out.println(annotation.columnName());
        System.out.println(annotation.length());
        System.out.println(annotation.type());
    }


}

@Tablekuang("db_student")
class Student2{
    @Fieldkuang(columnName = "db_id",type="int",length=10)
    private int id;
    @Fieldkuang(columnName = "db_name",type="varchar",length=10)
    private String name;
    @Fieldkuang(columnName = "db_age",type="int",length=10)
    private int age;


    public Student2() {
    }

    public Student2(int id, String name, int age) {

    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }
@Override
     public String toString(){
        return "Student2 [id=" + id + ", name=" + name + ", age=" + age + "]";
     }


}

//类名的注解
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)

@interface Tablekuang
{
    String value();

}
//属性的注解
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@interface Fieldkuang
{
    String columnName();
    String type();
    int length() ;
}