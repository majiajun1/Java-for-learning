import java.io.*;
public class AgeClass {
    private int age;

    public AgeClass(int age) {
        this.age = age;
    }

    public void AgeConut() throws Ageerrorthrowtest{
        int temp=this.age;
        if(temp>100)
        {
        throw new Ageerrorthrowtest(temp);
        }
    }
}
