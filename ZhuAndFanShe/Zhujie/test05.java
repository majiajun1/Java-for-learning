package Zhujie;
//测试类的创建方式有哪些
public class test05 {
    public static void main(String[] args) throws ClassNotFoundException {
        Person person = new Student();
        System.out.println(person.name);

        //方式一：通过对象获得
        Class c1=person.getClass();
        System.out.println(c1.hashCode());
        //方式二：forname
        Class c2=Class.forName("Zhujie.Student");
        System.out.println(c2.hashCode());


        //方式三：通过类名.class获得
        Class c3=Student.class;
        System.out.println(c3.hashCode());
        //方式四：基本内置类型的包装类 都有一个Tpye属性
        Class  type = Integer.TYPE;
        System.out.println(type);
        
        
        //获得父类类型
        Class c5 = c1.getSuperclass();
        System.out.println(c5);

    }
}


class Person
{
    public String name;

    public Person(){};

    public Person(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                '}';
    }
}

class Student extends Person
{
    public Student(){
        this.name="学生";
    };


}

class Teacher extends Person
{
    public Teacher(){
        this.name="老师";
    };


}