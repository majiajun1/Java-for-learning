import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.*;
import java.util.*;
 import java.io.*;
public class NioTest {

    public static void main(String[] args) throws IOException {
        //新接连池
        List<SocketChannel> socketChannelList = new ArrayList<>(8);
        //开启服务端Socket
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        serverSocketChannel.bind(new InetSocketAddress(5555));
        //设置为非阻塞
        serverSocketChannel.configureBlocking(false);
        while (true) {
            //探测新连接，由于设置了非阻塞，这里即使没有新连接也不会阻塞，而是直接返回null
            SocketChannel socketChannel = serverSocketChannel.accept();
            //当返回值不为null的时候，证明存在新连接
            if (socketChannel != null) {
                System.out.println("新连接接入");
                //将客户端设置为非阻塞  这样read/write不会阻塞
                socketChannel.configureBlocking(false);
                //将新连接加入到线程池
                socketChannelList.add(socketChannel);
            }
            //迭代器遍历连接池
            Iterator<SocketChannel> iterator = socketChannelList.iterator();
            while (iterator.hasNext()) {
                ByteBuffer byteBuffer = ByteBuffer.allocate(128);
                SocketChannel channel = iterator.next();
                //读取客户端数据 当客户端数据没有写入完成的时候也不会阻塞，长度为0
                int read = channel.read(byteBuffer);

                if (read > 0) {
                    //当存在数据的时候打印数据
                    System.out.println(new String(byteBuffer.array()));
                } else if (read == -1) {
                    //客户端退出的时候删除该连接
                    iterator.remove();
                    System.out.println("断开连接");
                }
            }
        }
    }
}