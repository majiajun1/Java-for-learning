import java.util.Collections;
import java.util.HashSet;
public class HashSetTest {
    public static void main(String[] args) {
        HashSet<String> sites=new HashSet<>();
        sites.add("a");
        sites.add("c");
        sites.add("b");
        System.out.println(sites);
        System.out.println(sites.contains("a"));

        //感觉作用不大

    }
}
