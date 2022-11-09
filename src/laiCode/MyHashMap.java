package laiCode;

import java.util.Arrays;

public class MyHashMap<K, V> {
    public static class Node<K, V> {
        final K key;
        V value;
        Node<K, V> next;
        Node(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public K getKey() {
            return key;
        }

        public V getValue() {
            return value;
        }

        public void setValue(V value) {
            this.value = value;
        }
    }

    private static final int DEFAULT_CAPACITY = 16;
    private static final float DEFAULT_LOAD_FACTOR = 0.75f;

    private Node<K, V>[] array;
    private int size;
    private float loadFactor;

    public MyHashMap() {
        this(DEFAULT_CAPACITY, DEFAULT_LOAD_FACTOR);
    }

    public MyHashMap(int cap, float loadFactor) {
        if (cap <= 0) {
            throw new IllegalArgumentException("cap cannot be <= 0");
        }
        this.array = (Node<K, V>[]) (new Node[cap]);
        this.size = 0;
        this.loadFactor = loadFactor;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void clear() {
        Arrays.fill(this.array, null);
        size = 0;
    }

    public int hash(K key) {
        if (key == null) {
            return 0;
        }

        int code = key.hashCode();
        return code >= 0 ? code : -code;
    }

    private int getIndex(K key) {
        return hash(key) % array.length;
    }

    private boolean equalsValue(V v1, V v2) {
//        if (v1 == null && v2 == null) {
//            return true;
//        }
//        if (v1 == null || v2 == null) {
//            return false;
//        }
//        return v1.equals(v2);
        return v1 == v2 || v1 != null && v1.equals(v2);
    }

    public boolean containsValue(V value) {    // Time O(n)
        if (isEmpty()) {
            return false;
        }

        for (Node<K, V> node : array) {   // traverse LinkedList  Time O(n)
            while (node != null) {
                if (equalsValue(node.value, value)) {
                    return true;
                }
                node = node.next;
            }
        }
        return false;
    }

    private boolean equalsKey(K k1, K k2) {
//        if (k1 == null && k2 == null) {
//            return true;
//        }
//        if (k1 == null || k2 == null) {
//            return false;
//        }
//        return k1.equals(k2);
        return k1 == k2 || k1 != null && k1.equals(k2);
    }

    public boolean containsKey(K key) {    // Time O(1)
        int index = getIndex(key);
        Node<K, V> node = array[index];
        while (node != null) {
            if (equalsKey(node.key, key)) {
                return true;
            }
            node = node.next;
        }
        return false;
    }

    public V get(K key) {
        int index = getIndex(key);
        Node<K, V> cur = array[index];
        while (cur != null) {
            if (equalsKey(cur.key, key)) {
                return cur.value;
            }
            cur = cur.next;
        }
        return null;
    }

    public V put(K key, V value) {
        int index = getIndex(key);
        Node<K, V> head = array[index];
        Node<K, V> cur = head;
        while (cur != null) {
            if (equalsKey(cur.key, key)) {
                V result = cur.value;
                cur.value = value;
                return result;
            }
            cur = cur.next;
        }

        Node<K, V> newNode = new Node<>(key, value);
        newNode.next = head;
        array[index] = newNode;  // UPDATE LinkedList head to newhead
        size++;
        if (needRehashing()) {
            rehashing();
        }
        return null;
    }

    private boolean needRehashing() {
        float ratio = (size + 0.0f) / array.length;   // because size is int, +0.0f help convert int to float
        return ratio >= loadFactor;
    }

    int SCALE_FACTOR = 2;
    private void rehashing() {
        Node<K, V>[] oldArray = array;
        array = (Node<K, V>[]) (new Node[array.length * SCALE_FACTOR]);
        for (Node<K, V> node: oldArray) {
            while (node != null) {
                Node<K, V> next = node.next;
                int index = getIndex(node.key);
                node.next = array[index];  // array[index] is the head in new array LinkedList
                array[index] = node;
                node = next;
            }
        }
    }

    public V remove(K key) {
        int index = getIndex(key);
        Node<K, V> pre = null;
        Node<K, V> cur = array[index];
        while (cur != null) {
            if (equalsKey(cur.key, key)) {
                if (pre != null) {
                    pre.next = cur.next;
                } else {
                    array[index] = cur.next;
                }
                size--;
                return cur.value;
            }
            pre = cur;
            cur = cur.next;
        }
        return null;
    }
}
