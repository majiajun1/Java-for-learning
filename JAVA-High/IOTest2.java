import java.io.*;
public class IOTest2 {
    public static void main(String[] args) {
       try (FileOutputStream output = new FileOutputStream("a.txt")) {
    byte[] array = "JavaGuide".getBytes(); //转换为字节数据

    output.write(array);
    output.close();
} catch (IOException e) {
    e.printStackTrace();
}
    }
}
