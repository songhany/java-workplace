package other.CS570;

interface HashMap<K, V> {
    V get(Object key);
    V put(K key, V value);
    V remove(Object key);
    int size();
    boolean isEmpty();
}
