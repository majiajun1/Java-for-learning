import java.text.SimpleDateFormat;
import java.util.Date;
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
    }
}
