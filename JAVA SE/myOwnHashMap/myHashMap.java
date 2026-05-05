package myOwnHashMap;



public class myHashMap<K,V> {
     static class Entry<K,V>{
         K key;
         V value;
         Entry<K,V> next;
     }

     int size=16;
     Entry<K,V> list[];
     public myHashMap() {
         list=new Entry[size];
     }



     int getEntry(K key){
         int realPos=key.hashCode()&(size-1);
         return realPos;
     }
     V get(K key){
         int realPos=getEntry(key);
         if(list[realPos]==null){
             return null;
         }else {
             Entry<K,V> entry=list[realPos];
             while(entry!=null){
                 if(entry.key.equals(key)){
                     return entry.value;
                 }
                 entry=entry.next;
             }
             return null;
         }
     }

     void put(K key,V value){
         int realPos=getEntry(key);
         if(list[realPos]==null){
             Entry<K,V> root = new Entry<>();
             root.key=key;
             root.value=value;
             list[realPos]=root;
         }else {
             Entry<K,V> entry=list[realPos];
             Entry<K,V> prev=entry;
             while(entry!=null){
                 if(entry.key.equals(key)){
                     entry.value=value;
                     return;
                 }
                 prev=entry;
                 entry=entry.next;
             }
             entry=new Entry<>();
             entry.key=key;
             entry.value=value;
             prev.next=entry;

         }
     }



}
