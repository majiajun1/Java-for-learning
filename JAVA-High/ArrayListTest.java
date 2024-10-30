import java.util.ArrayList;
import java.util.Collections;

public class ArrayListTest {
    public static void main(String[] args) {
        ArrayList<Number> intarray=new ArrayList<>();
        intarray.add(1);
        intarray.add(100);
        for(Number i:intarray)
        {
            System.out.println(i);
        }
        System.out.println(intarray.get(0));
        intarray.set(1,200);
        System.out.println(intarray.get(1));
        intarray.remove(1);
        System.out.println(intarray.size());
        intarray.add(1,200);
        intarray.add(2,150);
        ArrayList<Integer> intarray2=new ArrayList<>();
        for (Number num : intarray) {
        intarray2.add(num.intValue());  // 将 `Number` 转换为 `Integer` 类型
            }

        Collections.sort(intarray2);
        System.out.println(intarray2);
    }
}
