import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class RandomizedSet {
    public static HashMap<Integer,Integer> map;
    private static ArrayList<Integer> list;
    private static Random random;
    public RandomizedSet() {
        map=new HashMap<>();
        list=new ArrayList<>();
        random=new Random();
    }



    public boolean insert(int val) {
        if (!map.containsKey(val)) {
            list.add(val);
            map.put(val,map.getOrDefault(val,0)+1);
            return true;// 添加到列表
        }
        else return false;


    }

    public boolean remove(int val) {
        if(map.containsKey(val)) {

                map.remove(val);
                list.remove((Integer) val);
                return true;


        }
        else {
            return false;}
    }

    public int getRandom() {

        int randomIndex = random.nextInt(list.size()); // 随机获取索引
        return list.get(randomIndex);
    }


}
