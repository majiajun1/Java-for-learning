import java.io.*;

public class StreamTest {
    public static void main(String[] args)
    throws IOException {
        char c;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter a string");
        do{
            c=(char) br.read();
            System.out.println(c);
        }while(c!='q');


        BufferedReader br2=new BufferedReader(new InputStreamReader(System.in));
        String str;
        System.out.println("Enter a string");
        System.out.println("Enter 'end' to quit");
        do {
            str=br2.readLine();
            System.out.println(str);
        }while(!str.equals("end"));

    }
}
