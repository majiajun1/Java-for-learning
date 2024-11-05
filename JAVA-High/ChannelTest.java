import java.io.IOException;
import java.io.*;
import java.nio.ByteBuffer;
import java.nio.channels.*;

public class ChannelTest {
    public static void main(String[] args) {
        try {
            RandomAccessFile reader = new RandomAccessFile("a.txt", "r");
            FileChannel channel = reader.getChannel();
            ByteBuffer buffer = ByteBuffer.allocate(1024);

            // 读取数据到缓冲区
            while (channel.read(buffer) > 0) {  //channel.read(buffer) 尝试将数据从通道读取到缓冲区，最多填满缓冲区的剩余空间。如果通道中的数据比缓冲区容量大，
                                                 // 那么一次 read 操作只会读取一部分数据，剩余的数据需要通过多次调用 read(buffer) 读取。
                                                //read(buffer) 返回 -1，表示通道末尾已到达，读取完成。
                buffer.flip();  // 切换为读模式
                while (buffer.hasRemaining()) {
                    System.out.print((char) buffer.get());  // 打印缓冲区的每个字节
                }
                buffer.clear();  // 清除缓冲区，准备下次读取
            }

            // 关闭资源
            channel.close();
            reader.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
