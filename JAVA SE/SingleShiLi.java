import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;

public class SingleShiLi {
    public static void main(String[] args) throws  Exception {
        SingleClassInstance obj=SingleClassInstance.getInstance();
        SingleClassInstance obj2=SingleClassInstance.getInstance();
        Constructor<SingleClassInstance> constructor=SingleClassInstance.class.getDeclaredConstructor();
        constructor.setAccessible(true);
        SingleClassInstance obj3=constructor.newInstance();

        System.out.println(obj2.equals(obj3));

        SingletionInside obj4=SingletionInside.getInstance();
        SingletionInside obj5=SingletionInside.getInstance();
        System.out.println(obj4.equals(obj5));


       Testenum obj6=Singletonenum.INSTANCE.getInstance();
       Testenum obj7=Singletonenum.INSTANCE.getInstance();
        System.out.println(obj6==obj7);
    }
}

 class SingleClassInstance
{
    int id;


    private static volatile SingleClassInstance instance;

    private SingleClassInstance()
    {

    }

    public static SingleClassInstance getInstance() {
        if (instance == null) {
            synchronized (SingleClassInstance.class) {
                if (instance == null) {
                    instance = new SingleClassInstance();
                }
            }
        }
        return instance;
    }
}

class SingletionInside
{
    private SingletionInside()
    {}

    private static class Holder{
        private static final SingletionInside INSTANCE = new SingletionInside();
    }

    public static SingletionInside getInstance()
    {
        return Holder.INSTANCE;
    }


}

enum  Singletonenum
{
    INSTANCE;
    private final Testenum instance;
    Singletonenum()
    {
        this.instance=new Testenum();
    }

    public Testenum getInstance()
    {
        return instance;
    }

}
class Testenum
{
    int id=1;
    public void doSomething()
    {
        System.out.println("单例测试");
    }
}
