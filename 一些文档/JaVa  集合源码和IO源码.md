# JaVa  集合源码和IO源码

### [InputStream（字节输入流）](https://javaguide.cn/java/io/io-basis.html#inputstream-字节输入流)

`InputStream`用于从源头（通常是文件）读取数据（字节信息）到内存中，`java.io.InputStream`抽象类是所有字节输入流的父类。

`InputStream` 常用方法：

- `read()`：返回输入流中下一个字节的数据。返回的值介于 0 到 255 之间。如果未读取任何字节，则代码返回 `-1` ，表示文件结束。
- `read(byte b[ ])` : 从输入流中读取一些字节存储到数组 `b` 中。如果数组 `b` 的长度为零，则不读取。如果没有可用字节读取，返回 `-1`。如果有可用字节读取，则最多读取的字节数最多等于 `b.length` ， 返回读取的字节数。这个方法等价于 `read(b, 0, b.length)`。
- `read(byte b[], int off, int len)`：在`read(byte b[ ])` 方法的基础上增加了 `off` 参数（偏移量）和 `len` 参数（要读取的最大字节数）。
- `skip(long n)`：忽略输入流中的 n 个字节 ,返回实际忽略的字节数。
- `available()`：返回输入流中可以读取的字节数。
- `close()`：关闭输入流释放相关的系统资源。

从 Java 9 开始，`InputStream` 新增加了多个实用的方法：

- `readAllBytes()`：读取输入流中的所有字节，返回字节数组。
- `readNBytes(byte[] b, int off, int len)`：阻塞直到读取 `len` 个字节。
- `transferTo(OutputStream out)`：将所有字节从一个输入流传递到一个输出流。

`FileInputStream` 是一个比较常用的字节输入流对象，可直接指定文件路径，可以直接读取单字节数据，也可以读取至字节数组中。



不过，一般我们是不会直接单独使用 `FileInputStream` ，通常会配合 `BufferedInputStream`（字节缓冲输入流，后文会讲到）来使用。

`DataInputStream` 用于读取指定类型数据，不能单独使用，必须结合其它流，比如 `FileInputStream` 。

`ObjectInputStream` 用于从输入流中读取 Java 对象（反序列化），`ObjectOutputStream` 用于将对象写入到输出流(序列化)。另外，用于序列化和反序列化的类必须实现 `Serializable` 接口，对象中如果有属性不想被序列化，使用 `transient` 修饰。`OutputStream`用于将数据（字节信息）写入到目的地（通常是文件），`java.io.OutputStream`抽象类是所有字节输出流的父类。

FileOutputStream` 通常也会配合 `BufferedOutputStream

~~~java	
FileOutputStream fileOutputStream = new FileOutputStream("output.txt");
BufferedOutputStream bos = new BufferedOutputStream(fileOutputStream)
~~~

**`DataOutputStream`** 用于写入指定类型数据，不能单独使用，必须结合其它流，比如 `FileOutputStream` 。`ObjectInputStream` 用于从输入流中读取 Java 对象（`ObjectInputStream`,反序列化），`ObjectOutputStream`将对象写入到输出流(`ObjectOutputStream`，序列化)。





# 字节流

- 不管是文件读写还是网络发送接收，信息的最小存储单元都是字节
- 字符流是由 Java 虚拟机将字节转换得到的，这个过程还算是比较耗时。
- 如果我们不知道编码类型就很容易出现乱码问题。



`Reader`用于从源头（通常是文件）读取数据（字符信息）到内存中，`java.io.Reader`抽象类是所有字符输入流的父类

`Reader` 用于读取文本， `InputStream` 用于读取原始字节。`InputStreamReader` 是字节流转换为字符流的桥梁，其子类 `FileReader` 是基于该基础上的封装，可以直接操作字符文件。

- ‌**InputStream**‌：这是一个字节输入流，主要用于处理字节数据。它读取的数据单位是一个字节，适用于处理二进制数据或文本数据（通过[InputStreamReader](https://www.baidu.com/s?sa=re_dqa_generate&wd=InputStreamReader&rsv_pq=eb63aa2a0000f25e&oq=inputstream和 reader的区别&rsv_t=caf3VaCfMUx/WtpEsmEqzlXaNNO2dxBRH3QpAZGnaxO6BHWqWWYwrz0L6NI&tn=baidu&ie=utf-8)转换）。例如，[FileInputStream](https://www.baidu.com/s?sa=re_dqa_generate&wd=FileInputStream&rsv_pq=eb63aa2a0000f25e&oq=inputstream和 reader的区别&rsv_t=caf3VaCfMUx/WtpEsmEqzlXaNNO2dxBRH3QpAZGnaxO6BHWqWWYwrz0L6NI&tn=baidu&ie=utf-8)是[InputStream](https://www.baidu.com/s?sa=re_dqa_generate&wd=InputStream&rsv_pq=eb63aa2a0000f25e&oq=inputstream和 reader的区别&rsv_t=caf3VaCfMUx/WtpEsmEqzlXaNNO2dxBRH3QpAZGnaxO6BHWqWWYwrz0L6NI&tn=baidu&ie=utf-8)的一个实现类，用于从文件中读取字节‌12。
- ‌**Reader**‌：这是一个字符输入流，主要用于处理字符数据。它读取的数据单位是一个字符，适用于处理文本数据。例如，[FileReader](https://www.baidu.com/s?sa=re_dqa_generate&wd=FileReader&rsv_pq=eb63aa2a0000f25e&oq=inputstream和 reader的区别&rsv_t=caf3VaCfMUx/WtpEsmEqzlXaNNO2dxBRH3QpAZGnaxO6BHWqWWYwrz0L6NI&tn=baidu&ie=utf-8)是[Reader](https://www.baidu.com/s?sa=re_dqa_generate&wd=Reader&rsv_pq=eb63aa2a0000f25e&oq=inputstream和 reader的区别&rsv_t=caf3VaCfMUx/WtpEsmEqzlXaNNO2dxBRH3QpAZGnaxO6BHWqWWYwrz0L6NI&tn=baidu&ie=utf-8)的一个实现类，用于从文件中读取字符‌12。



# 字节缓冲流

IO 操作是很消耗性能的，缓冲流将数据加载至缓冲区，一次性读取/写入多个字节，从而避免频繁的 IO 操作，提高流的传输效率

举个例子，我们可以通过 `BufferedInputStream`（字节缓冲输入流）来增强 `FileInputStream` 的功能。缓冲区的大小默认为 **8192** 字节，当然了，你也可以通过 `BufferedInputStream(InputStream in, int size)` 这个构造方法来指定缓冲区的大小。`System.out` 实际是用于获取一个 `PrintStream` 对象，`print`方法实际调用的是 `PrintStream` 对象的 `write` 方法。

`System.out` 实际是用于获取一个 `PrintStream` 对象，`print`方法实际调用的是 `PrintStream` 对象的 `write` 方法。

`PrintStream` 属于字节打印流，与之对应的是 `PrintWriter` （字符打印流）。`PrintStream` 是 `OutputStream` 的子类，`PrintWriter` 是 `Writer` 的子类。



# 随机访问流

这里要介绍的随机访问流指的是支持随意跳转到文件的任意位置进行读写的 `RandomAccessFile` 。

- `r` : 只读模式。
- `rw`: 读写模式
- `rws`: 相对于 `rw`，`rws` 同步更新对“文件的内容”或“元数据”的修改到外部存储设备。
- `rwd` : 相对于 `rw`，`rwd` 同步更新对“文件的内容”的修改到外部存储设备。

文件内容指的是文件中实际保存的数据，元数据则是用来描述文件属性比如文件的大小信息、创建和修改时间`RandomAccessFile` 中有一个文件指针用来表示下一个将要被写入或者读取的字节所处的位置。我们可以通过 `RandomAccessFile` 的 `seek(long pos)` 方法来设置文件指针的偏移量（距文件开头 `pos` 个字节处）。如果想要获取文件指针当前的位置的话，可以使用 `getFilePointer()` 方法。

`RandomAccessFile` 的 `write` 方法在写入对象的时候如果对应的位置已经有数据的话，会将其覆盖掉。`RandomAccessFile` 比较常见的一个应用就是实现大文件的 **断点续传** 。何谓断点续传？简单来说就是上传文件中途暂停或失败（比如遇到网络问题）之后，不需要重新上传，只需要上传那些未成功上传的文件分片即可。分片（先将文件切分成多个文件分片）上传是断点续传的基础。

`RandomAccessFile` 的实现依赖于 `FileDescriptor` (文件描述符) 和 `FileChannel` （内存映射文件）。