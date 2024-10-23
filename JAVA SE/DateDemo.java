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

    }
}
