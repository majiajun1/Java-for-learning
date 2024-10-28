public class DuoTaitest {
    public static void main(String[] args) {

    show(new Cat());
    show(new Pig());
    Animal3 a=new Cat();
    a.eat();
    Cat c=(Cat)a;
    c.work();
    }

    public static void show(Animal3 a)
    {
        a.eat();
        if (a instanceof Cat)
        {
            Cat c = (Cat)a;
            c.work();
        }else if(a instanceof Pig)
        {
            Pig c=(Pig) a;
            c.work();
        }
    }
}


abstract class Animal3
{
    abstract void eat();
}

class Cat extends Animal3
{
    public void eat()
    {
        System.out.println("cat eat");
    }
    public void work()
    {
        System.out.println("cat work");
    }
}


class Pig extends Animal3
{
    public void eat()
    {
        System.out.println("pig eat");
    }
    public void work()
    {
        System.out.println("pig work");
    }


}