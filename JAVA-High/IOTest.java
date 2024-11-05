
import java.io.*;
public class IOTest {
    public static void main(String[] args) {
        try (InputStream fis = new FileInputStream("a.txt")) {
    System.out.println("Number of remaining bytes:"
            + fis.available());
    int content;
    long skip = fis.skip(2);
    System.out.println("The actual number of bytes skipped:" + skip);
    System.out.print("The content read from file:");
    while ((content = fis.read()) != -1) {   //read()：返回输入流中下一个字节的数据。返回的值介于 0 到 255 之间。如果未读取任何字节，则代码返回 -1 ，表示文件结束。
        System.out.print((char) content);
    }
    System.out.println();
    BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream("a.txt"));

    String result= new String(bufferedInputStream.readAllBytes());
    System.out.println(result);
    fis.close();
} catch (IOException e) {
    e.printStackTrace();
}

    }
}
