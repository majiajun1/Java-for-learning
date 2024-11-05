import java.io.*;
public class WriterTest {
    public static void main(String[] args) {
        try (Writer output = new FileWriter("a.txt")) {
    output.write("你好，我是Guide。");
     char[] charArray = {'B', 'C', 'D'};
            output.write(charArray, 0, charArray.length);
} catch (IOException e) {
    e.printStackTrace();
}
    }
}
