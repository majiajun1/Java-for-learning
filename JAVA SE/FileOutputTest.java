import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class FileOutputTest {
    public static void main(String[] args)  throws IOException {
        FileOutputStream fos=new FileOutputStream("D:/Document/JAVA/test.txt");
        char bWrite[]={'a','b','c','d','e'};
        for(char i:bWrite)
        {
            fos.write(i);
        }
        fos.close();


        FileInputStream fis=new FileInputStream("D:/Document/JAVA/test.txt");
        System.out.println(fis.available());
        int count=fis.available();
        //for(int i=0;i<fis.available();i++) //错误示范
        for(int i=0;i<count;i++)
        {

            System.out.print((char)fis.read()+" ");
            //System.out.print(fis.available());  //BUG原因 available()会一直变的
        }
        fis.close();

    }
}
