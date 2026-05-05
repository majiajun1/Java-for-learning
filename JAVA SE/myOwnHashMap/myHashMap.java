package myOwnHashMap;


import java.util.Objects;

public class myHashMap<K,V> {
     static class Entry<K,V>{
         Entry<K,V> prev;
         K key;
         V value;
         Entry<K,V> next;
     }

     private int  size=16;
     private Entry<K,V> list[];
     public myHashMap() {
         list=  (Entry<K,V>[]) new Entry[size];
     }
     private int actualSize=0;



     int getHash(K key){
         if (key == null) {
             return 0;  // null 键固定放在第一个位置
         }
         int hash=key.hashCode();
         hash^=(hash>>>16);  //二次扰动
         //八股：为什么二次扰动？
         return (size-1)&hash ;
     }

     Entry<K,V> getEntry(K key){
         int realPos=getHash(key);
         if(list[realPos]==null){
             return null;
         }else {
             Entry<K,V> entry=list[realPos];
             while(entry!=null){
                 if(Objects.equals(entry.key, key)){
                     return entry;
                 }
                 entry=entry.next;
             }
             return null;
         }
     }

     V get(K key){
          Entry<K,V> entry=getEntry(key);
          if(entry==null){
              return null;
          }else {
              return entry.value;
          }
     }

     public void put(K key,V value){
         int realPos=getHash(key);
         if(list[realPos]==null){
             Entry<K,V> root = new Entry<>();
             root.key=key;
             root.value=value;
             list[realPos]=root;
             actualSize++;
         }else {
             Entry<K,V> entry=list[realPos];
             Entry<K,V> prev=entry;
             while(entry!=null){
                 if(Objects.equals(entry.key, key)){
                     entry.value=value;
                     return;
                 }
                 prev=entry;
                 entry=entry.next;
             }
             entry=new Entry<>();
             entry.prev=prev;
             entry.key=key;
             entry.value=value;
             prev.next=entry;
             actualSize++;

         }


     }


     public int size(){
         return actualSize;
     }

     public boolean isEmpty(){
         return actualSize==0;
     }

     public boolean containsKey(K key){
         return getEntry(key) != null;
     }

     public K remove(K key){
         Entry<K,V> entry=getEntry(key);
         if(entry==null){
             return null;
         }else {
             if(entry.prev==null){
                 int realPos=getHash(key);
                 list[realPos]=entry.next;
             }else {
                 Entry<K,V> prev=entry.prev;
                 prev.next=entry.next;
                 if(entry.next!=null){
                     entry.next.prev=prev;
                 }
             }
         }
         actualSize--;
         return entry.key;
     }



}


