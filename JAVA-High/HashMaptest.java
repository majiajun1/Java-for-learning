import java.util.HashMap;
public class HashMaptest {
    public static void main(String[] args) {
        HashMap<Integer,String> sites=new HashMap<>();
        sites.put(1,"A");
        sites.put(2,"B");
        System.out.println(sites);
        HashMap<String,String> sites2=new HashMap<>();
        sites2.put("A","C");
        sites2.put("B","D");
        System.out.println(sites2);
        System.out.println(sites.get(1));
        for(int i:sites.keySet()){
            System.out.println(sites.get(i));
        }
        for(String value:sites2.values()) {
          // 输出每一个value
          System.out.println(value );
        }
    }
}
