import java.util.*;
public class LinkedListtest {
    public static void main(String[] args) {
        LinkedList<String> list = new LinkedList();
        list.add("MJJ");
        list.add("MJJ2");
        list.add("MJJ3");
        System.out.println(list.getFirst());
        System.out.println(list.getLast());
        System.out.println(list.size());
        list.removeFirst();
        System.out.println(list);
        list.removeLast();
        System.out.println(list);


    }

}
