public class Animal {
    private String name;
    private int id;
    public Animal(String myname, int myid) {
        name=myname;
        id=myid;
    }
    public void eat()
    {
        System.out.println("Eating...");
    }
}
class Chenglianglun extends Animal{    //不能有public 否则报错
    public Chenglianglun(String myname,int myid){
        super(myname,myid);
    }
    public void getWage()
    {
        System.out.println("3000");
    }
}