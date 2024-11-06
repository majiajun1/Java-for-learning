import java.nio.ByteBuffer;


public class BufferDemo {
    public static void main(String[] args) {
        // 创建一个容量为10的ByteBuffer
        ByteBuffer buffer = ByteBuffer.allocate(10);

        // 向缓冲区中添加一些数据
        buffer.put((byte) 10);
        buffer.put((byte) 20);

        // 打印当前 position 和 limit
        System.out.println("Initial position: " + buffer.position());

        // 标记当前位置
        buffer.mark();
        System.out.println("Marked position: " + buffer.position());

        // 再写入一些数据
        buffer.put((byte) 30);
        buffer.put((byte) 40);

        // 打印 position 和 limit
        System.out.println("Position after adding more data: " + buffer.position());

        // 调用 reset() 返回到标记位置
        buffer.reset();
        System.out.println("Position after reset(): " + buffer.position());

        // 从标记位置继续写入
        buffer.put((byte) 50);
        System.out.println("Position after writing data after reset: " + buffer.position());
        System.out.println("limit: " + buffer.limit());
        // 打印缓冲区的内容
        buffer.flip(); // 切换到读取模式
        System.out.println("limit: " + buffer.limit());
        System.out.print("Buffer content: ");
        while (buffer.hasRemaining()) {
            System.out.print(buffer.get() + " ");
        }
    }
}
