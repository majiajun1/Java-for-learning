import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;

public class LRUCache {
        int cap;
    LinkedHashMap<Integer, Integer> cache = new LinkedHashMap<>();

    public LRUCache(int capacity) {
        this.cap = capacity;
    }
    public int get(int key) {
        if (!cache.containsKey(key)) {
            return -1;
        }
        // 将 key 变为最近使用
        makeRecently(key);
        return cache.get(key);
    }

    public void put(int key, int value) {
        if (cache.containsKey(key)) {
            // 修改 key 的值
            cache.put(key, value);
            // 将 key 变为最近使用
            makeRecently(key);
            return;
        }
            if(cache.size() >= this.cap) {
                // 链表头部就是最久未使用的 key
                int delete = cache.keySet().iterator().next();
                cache.remove(delete);
            }

            // 将新的 key 添加链表尾部
            cache.put(key, value);

        }




     private void makeRecently(int key) {
        int val = cache.get(key);
        // 删除 key，重新插入到队尾
        cache.remove(key);
        cache.put(key, val);
    }


}
