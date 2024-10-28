import java.util.ArrayList;
import java.util.List;
import java.util.*;

public class Basicdatastruture {
    public static void main(String[] args) {
        int[] array=new int[10];
        System.out.println(array.length);
        List<String> arrayList=new ArrayList<String>();
        arrayList.add("sifhasifjasfjas");
        String test=arrayList.get(0);
        System.out.println(test);
        System.out.println(arrayList.size());
        Set<String> set=new HashSet<>();
        set.add("sifhasifjasfjas");
        set.remove("sifhasifjasfjas");
        System.out.println(set.contains("sifhasifjasfjas"));
    }
}
