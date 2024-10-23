import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.*;
import java.text.*;
public class DateDemo {
    public static void main(String[] args) {
        Date date = new Date();
        System.out.println(date);
        String a=date.toString();
        StringBuffer b=new StringBuffer(a);
        System.out.println(b);
        b.insert(10,"sdjfhsdjkifh");
        System.out.println(b);
        System.out.println(date.before(new Date()));

        Date newdate=new Date();
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println(sdf.format(newdate));

        System.out.printf("%tR", date);
        System.out.println();
        System.out.printf("%1$s %2$tB %2$td, %2$tY",
                         "Due date:", date);  // 格式化字符串

        System.out.println();
        SimpleDateFormat ft = new SimpleDateFormat ("yyyy-MM-dd");

      String input = args.length == 0 ? "1818-11-11" : args[0];

      System.out.print(input + " Parses as ");
      long start=System.currentTimeMillis();
      try{
      Thread.sleep(3000);
    }catch(InterruptedException e){}
      long end=System.currentTimeMillis();
      System.out.println(end-start);
    }

}
