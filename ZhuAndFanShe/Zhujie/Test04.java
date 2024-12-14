package Zhujie;

import javax.sound.midi.Soundbank;

public class Test04 {
    public static void main(String[] args) throws ClassNotFoundException {
        //通过反射获取类的class对象

        Class  aClass = Class.forName("Zhujie.user");
        System.out.println(aClass.hashCode());

        Class  bClass = Class.forName("Zhujie.user");
        System.out.println(bClass.hashCode());

        Class  cClass = Class.forName("Zhujie.user");
        System.out.println(cClass.hashCode());
        //一个类在内存中只有一个Class对象
        //一个类被加载后，类的整个结构都会被封装在class对象中

        user user1 = new user();
        System.out.println(user1.getClass().hashCode());


    }

}


//实体类
class user
{

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }



    public user(int age) {
        this.age = age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    int age;

    public void setName(String name) {
        this.name = name;
    }

    String name;

    public void setId(int id) {
        this.id = id;
    }

    int id;
    public user(String name, int id, int age) {
        this.name = name;
        this.id = id;
        this.age = age;
    }

    public user()
    {}


}