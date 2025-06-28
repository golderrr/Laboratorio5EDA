import java.util.*;

public class HashST<K, V> {
    private static class Entry<K, V> {
        K key;
        V value;
        Entry(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

    private final int SIZE = 16;
    private List<Entry<K, V>>[] table;

    public HashST() {
        table = new ArrayList[SIZE];
        for(int i = 0; i < SIZE; i++){
            table[i] = new ArrayList<>();
        }
    }

    private int hash(K key) {
        return Math.abs(key.hashCode()) % SIZE;
    }

    public void put(K key, V value) {
        int hash = hash(key);
        List<Entry<K, V>> list = table[hash];

        for(int i = 0; i < list.size(); i++){
            if(list.get(i).key.equals(key)){
                list.get(i).value = value;
                return;
            }
        }
        list.add(new Entry<>(key, value));
    }

    public V get(K key) {
        int hash = hash(key);
        List<Entry<K, V>> list = table[hash];

        for(int i = 0; i < list.size(); i++){
            if(list.get(i).key.equals(key)){
                return list.get(i).value;
            }
        }
        return null;
    }

    public boolean containsKey(K key) {
        int hash = hash(key);
        List<Entry<K, V>> list = table[hash];

        for(int i = 0; i < list.size(); i++){
            if(list.get(i).key.equals(key)){
                return true;
            }
        }
        return false;
    }

    public Collection<V> values() {
        List<V> values = new ArrayList<>();

        for(int i = 0; i < SIZE; i++){
            List<Entry<K, V>> list = table[i];
            for(int j = 0; j < list.size(); j++){
                values.add(list.get(j).value);
            }
        }
        return values;
    }

}
