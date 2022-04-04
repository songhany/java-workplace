package CPE593;

import java.io.FileInputStream;
import java.io.IOException;

/*
	Implement methods add(), get() and hist() for both types of hashmap
	You must read the file dict.txt in the current directory.
	DO NOT put in a path, that will only work on your computer.
	https://drive.google.com/drive/folders/0Bwxfq4Y7f7vkTkZnVEFEcXVEWmc?resourcekey=0-mOXByawNd1BgAZIqFmdGzQ&usp=sharing
 */
class HashMapLinearProbing {
    private static class Node {
        String key;
        int val;
        Node(String k, int v) {
            key = k;
            val = v;
        }
    }

    private Node[] table;
    private int used;
    private int[] hist;

    public HashMapLinearProbing(int initialSize) {
        table = new Node[initialSize];
        used = 0;
        hist = new int[12];
    }

    public void add(String key, int value) {
        if (2 * used >= table.length) {
            grow();
        }
        int pos = hash(word);
        int count = 1;
        while (table[pos] != null) {
            if (table[pos].key.equals(word)) {
                table[pos].val = v;
                if (count > 11) {
                    count = 11;
                }
                hist[count]++;
                return;
            }
            count++;
            pos++;
            if (pos >= table.length) {
                pos = 0;
            }
        }
        used++;
        table[pos] = new Node(word, v);
        if (count > 11) {
            count = 11;
        }
        hist[count]++;
    }

    public int get(String word) {

    }

    public void hist() {

    }

    private final int hash(String word) {
        int sum = word.length();
        for (int i = 0; i < word.length(); i++) {
            sum = sum << 13 + sum << 3 + word.charAt(i) + sum >> 17;
        }
        return sum & (table.length - 1);
    }
}

class HashMapLinearChaining {
    public void add(int key, int value) {

    }

    public int get(int key) {

    }
}

public class HWHashMap {
    public static void main(String[] args) throws IOException {
        int n = 1000000;
        HashMapLinearProbing m1 = new HashMapLinearProbing(n);
        HashMapLinearChaining m2 = new HashMapLinearChaining(n);

        int count = 0;
        //read in the dictionary (213k words)
        FileInputStream fis = new FileInputStream("dict.txt");

        String word;
        while (( i = fis.read()) != -1) {
            m1.add(word, count); // each word has a unique id number
            m2.add(word, count);
            count++;
        }

        System.out.println("Linear probing\n");
        final String words[] = {"apple", "bear", "cat", "dog", "arggg", "juwqehtrkqwejhr"};

        for (int i = 0; i < words.length; i++) {
            Integer id = m1.get(words[i]); // return null if not found
            System.out.println("word " +  words[i] + " " + id + "id=" + id + '\n');
        }
        // print out the histogram showing count of inserts taking 1, 2, 3, ... 9+
        m1.hist();

        System.out.println("\n\nLinear chaining\n");
        for (int i = 0; i < words.length; i++) {
            Integer id = m2.get(words[i]); // return null if not found
            System.out.println("word " +  words[i] + " " + id + "id=" + id + '\n');
        }
        // print out the histogram showing bins of size 0, 1, 2, 3, ... 9+
        m2.hist();
    }
}


