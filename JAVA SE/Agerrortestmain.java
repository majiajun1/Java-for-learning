import java.io.*;
public class Agerrortestmain
{
    public static void main(String [] args)
    {
        AgeClass man=new AgeClass(200);
        try{
            man.AgeConut();
        }catch (Ageerrorthrowtest e){

            System.out.println("年龄大过100");
            e.printStackTrace();
        }

    }
}
