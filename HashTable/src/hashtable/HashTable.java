package hashtable;

import java.util.TreeMap;

/**
 * @description: 哈希表（数组中存放红黑树）
 * @author: Kevin
 * @createDate: 2020/3/4
 * @version: 1.0
 */
public class HashTable<K,V> {

    private TreeMap<K,V>[] hashtable; // 存储红黑树
    private int M; // 数组容量（选择合适的素数）
    private int size; // 存储元素大小

    public HashTable(int M){
        this.M = M;
        size = 0;
        hashtable = new TreeMap[M];
        for(int i =0;i<M;i++){
            hashtable[i] = new TreeMap<>();
        }
    }
    public HashTable(){
        this(97);
    }

    // 将key值转为哈希表中索引
    private int hash(K key){
        // hashCode & 0x7fffffff 作用是将第一位bit位为0，消除符号（负数变正，正数仍正）
        return (key.hashCode() & 0x7fffffff) % M;
    }

    public int getSize(){
        return size;
    }

    public void add(K key,V value){
        TreeMap<K,V> map = hashtable[hash(key)];
        if(map.containsKey(key))
            map.put(key, value);
        else{
            map.put(key, value);
            size++;
        }
    }

    public V remove(K key){
        TreeMap<K, V> map = hashtable[hash(key)];
        V ret = null;
        if (map.containsKey(key)){
            ret = map.remove(key);
            size --;
        }
        return ret;
    }

    public V get(K key){
        return hashtable[hash(key)].get(key);
    }

    public void set(K key,V value){
        TreeMap<K, V> map = hashtable[hash(key)];
        if (!map.containsKey(key)){
            throw new IllegalArgumentException(key + "doesn't exist");
        }
        map.put(key, value);
    }

    public boolean contains(K key){
        return hashtable[hash(key)].containsKey(key);
    }

}
