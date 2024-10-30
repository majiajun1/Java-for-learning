import java.util.ArrayList;
import java.util.List;
import java.util.*;
import java.util.Collections;
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
        List<String> e=new ArrayList();
        ArrayList<String> Array1=new ArrayList<String>();
        Array1.add("a");
        Array1.add("b");
        Array1.add("c");
        for(String str:Array1){
            System.out.println(str);
        }
        String[] strArray=new String[Array1.size()];
        Array1.toArray(strArray);
        for(String s:strArray){
            System.out.println(s);
        }
        Iterator<String> iterator=Array1.iterator();
        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }


    }
}
