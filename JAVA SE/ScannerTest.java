import java.util.Scanner;

public class ScannerTest {
    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in);
        System.out.println("next方式接收：");
        // 判断是否还有输入
        if (scan.hasNext()) {
            String str1 = scan.nextLine();
            System.out.println("输入的数据为：" + str1);
        }
        scan.close();
    }

}
