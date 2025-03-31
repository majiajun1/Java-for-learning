public class ThreadLocalExample {
    // 创建一个ThreadLocal变量，初始值为0
    private static ThreadLocal<Integer> threadLocal = ThreadLocal.withInitial(() -> 0);

    public static void main(String[] args) {
        // 创建线程并修改ThreadLocal的值
        Thread thread1 = new Thread(() -> {
            System.out.println("Thread 1 initial value: " + threadLocal.get());  // 获取当前值
            threadLocal.set(100);  // 修改ThreadLocal的值
            System.out.println("Thread 1 new value: " + threadLocal.get());  // 获取新的值
            threadLocal.remove();
        });

        Thread thread2 = new Thread(() -> {
            System.out.println("Thread 2 initial value: " + threadLocal.get());  // 获取当前值
            threadLocal.set(200);  // 修改ThreadLocal的值
            System.out.println("Thread 2 new value: " + threadLocal.get());  // 获取新的值
            threadLocal.remove();
        });

        thread1.start();
        thread2.start();
    }
}
