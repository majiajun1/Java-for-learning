import java.util.ArrayList;
import java.util.Iterator;
public class Iteratortest {
    public static void main(String[] args) {
        ArrayList<String> sites= new ArrayList<String>();
        sites.add("Alaska");
        sites.add("Berlin");
        sites.add("China");
        System.out.println(sites.size());
        Iterator<String> iter = sites.iterator();
        System.out.println(iter.next());
        while(iter.hasNext())
        {
            System.out.println(iter.next());
        }


        ArrayList<Integer> numbers=new ArrayList<Integer>();
        numbers.add(12);
        numbers.add(8);
        numbers.add(23);
        numbers.add(5);
        Iterator<Integer> iter2 = numbers.iterator();
        while (iter2.hasNext())
        {
            int i=iter2.next();
            if(i<10)
            {
                iter2.remove();
            }
        }
        System.out.println(numbers);
    }
}
