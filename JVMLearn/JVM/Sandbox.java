package JVM;

public class Sandbox {

    public static void main(String[] args) {
        Sandbox sandbox = new Sandbox();
        sandbox.a();
    }


    public void a()
    {
        b();
    }

    public void b()
    {
        a();
    }  //死循环。


}
