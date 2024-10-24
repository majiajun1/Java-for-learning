import java.io.*;

public class FileTest {
    public static void main(String[] args) throws IOException {   //throws
        InputStream f=new FileInputStream("D:/Document/JAVA/test.txt");  //文件输入流
        FileInputStream fortest=new FileInputStream("D:/Document/JAVA/test.txt");   //区别在哪？ InputStream f 是更通用的父类，灵活性较大，但功能有限。 FileInputStream f2 是更具体的子类，可以访问更多文件流相关的功能。
        //或者
        File f2=new File("D:/Document/JAVA/test.txt");
        InputStream in=new FileInputStream(f2);
        //String data = in.read();
        //System.out.println(data);
        StringBuilder sb = new StringBuilder();
        try {


            // 读取文件中的所有数据
            int data;
            while ((data = in.read()) != -1) { // 每次只读取一个字节 try才能读取
                sb.append((char) data); // 将字节转换为字符并添加到字符串构建器中
            }

            String content = sb.toString(); // 获取完整的文件内容
            System.out.println(content); // 打印文件内容

        } catch (FileNotFoundException e) {
            System.err.println("文件未找到: " + f2.getAbsolutePath());
        } catch (IOException e) {
            System.err.println("读取文件时发生错误");
            e.printStackTrace();
        } finally {
            if (in != null) {
                try {
                    in.close(); // 关闭输入流
                } catch (IOException e) {
                    System.err.println("关闭文件时发生错误");
                }
            }
        }
    }
}
