public class AdapterLearn {
    public static void main(String[] args) {
        Target target = new Adapter();
        target.request();
    }
}

interface Target{
    void request();
}


class Adaptee {
    public void A()
    {
        System.out.println("TestA");
    }
}

class Adapter extends Adaptee implements Target{
    @Override
    public void request()
    {
        A();
    }
}

