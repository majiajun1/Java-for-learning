import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class ReflectionExample {

    public static void main(String[] args) throws Exception {
        // 获取 Class 对象
        Class<?> clazz = Person.class;
        
        // 创建对象
        Constructor<?> constructor = clazz.getConstructor(String.class, int.class);
        Object person = constructor.newInstance("John", 30);
        
        // 访问字段
        Field nameField = clazz.getDeclaredField("name");
        nameField.setAccessible(true);
        System.out.println("Name: " + nameField.get(person));
        Field nameField2 = clazz.getDeclaredField("age");
        nameField2.setAccessible(true);
        System.out.println("Age: " + nameField2.get(person));
        
        // 修改字段
        nameField.set(person, "Doe");
        System.out.println("Updated Name: " + nameField.get(person));
        
        // 调用方法
        Method greetMethod = clazz.getMethod("greet", String.class);
        greetMethod.invoke(person, "World");
    }
}

class Person {
    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public void greet(String message) {
        System.out.println(name + " says: " + message);
    }
}