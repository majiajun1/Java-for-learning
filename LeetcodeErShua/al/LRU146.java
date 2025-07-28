/*
 * -----------------------------------------------------------------------------
 * © Swisslog AG
 * Swisslog is not liable for any usage of this source code that is not agreed on between Swisslog and the other party.
 * The mandatory legal liability remains unaffected.
 * -----------------------------------------------------------------------------
 */
package al;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

public class LRU146 {
    class LRUCache {
        LinkedHashMap<Integer, Integer> map;

        public LRUCache(int capacity) {
            map= new LinkedHashMap<>(capacity,0.75f,true){
                @Override
                protected boolean removeEldestEntry(Map.Entry<Integer,Integer>eldest){
                    return map.size() > capacity;//先插入再判断是否要删除lru的
                }
            };

        }
        public int get(int key) {
            if(!map.containsKey(key))
                return -1;
            else
            return map.get(key);
        }

        public void put(int key, int value) {
             map.put(key, value);
        }
    }
}
