import java.util.Calendar;

public class CalendarTest {
    public static void main(String[] args) {

        Calendar c=Calendar.getInstance();
        c.set(2009,6,12);
        System.out.println(c.get(Calendar.YEAR));
        c.set(Calendar.YEAR,2008);
        System.out.println(c.get(Calendar.YEAR));

        System.out.println(c.get(Calendar.MONTH));
        c.add(Calendar.MONTH,-1);
        System.out.println(c.get(Calendar.MONTH));


    }
}
