import java.io.*;
public class Readertest {
    public static void main(String[] args) {
        try (FileReader fileReader = new FileReader("a.txt");) {
    int content;
    long skip = fileReader.skip(0);
    System.out.println("The actual number of bytes skipped:" + skip);
    System.out.print("The content read from file:");
    while ((content = fileReader.read()) != -1) {
        System.out.print((char) content);
    }
} catch (IOException e) {
    e.printStackTrace();
}
    }
}
