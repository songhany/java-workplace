package CPE593;

import java.io.FileInputStream;
import java.io.IOException;

/*
	Implement methods add(), get() and hist() for both types of hashmap
	You must read the file dict.txt in the current directory.
	DO NOT put in a path, that will only work on your computer.
	https://drive.google.com/drive/folders/0Bwxfq4Y7f7vkTkZnVEFEcXVEWmc?resourcekey=0-mOXByawNd1BgAZIqFmdGzQ&usp=sharing
 */
//class HashMapLinearProbing {
//    private static class Node {
//        String key;
//        int val;
//        Node(String k, int v) {
//            key = k;
//            val = v;
//        }
//    }
//
//    private Node[] table;
//    private int used;
//    private int[] hist;
//
//    public HashMapLinearProbing(int initialCapacity) {
//        table = new Node[initialCapacity];
//        used = 0;
//        hist = new int[12];
//    }
//
//    public void add(String word, int value) {
//        if (2 * used >= table.length) {
//            grow();
//        }
//        int pos = hash(word);
//        int count = 1;
//        while (table[pos] != null) {
//            if (table[pos].key.equals(word)) {
//                table[pos].val = v;
//                if (count > 11) {
//                    count = 11;
//                }
//                hist[count]++;
//                return;
//            }
//            count++;
//            pos++;
//            if (pos >= table.length) {
//                pos = 0;
//            }
//        }
//        used++;
//        table[pos] = new Node(word, value);
//        if (count > 11) {
//            count = 11;
//        }
//        hist[count]++;
//    }
//
//    public int get(String word) {
//
//    }
//
//    public void hist() {
//
//    }
//
//    private int hash(String word) {
//        return word.hashCode() % size;
//    }
//}


class HashMapLinearChaining {

    public HashMapLinearChaining(int size) {

    }

    public void add(String word) {

    }

    public boolean get(String word) {

    }

    public void hist() {

    }

    private int hash(String word) {
        return word.hashCode() % size;
    }
}

class MyBufferedReader {
    private FileInputStream input;
    private StringBuilder buffer;
    public MyBufferedReader(FileInputStream in) {
        input = in;
        buffer = new StringBuilder();
    }
    public String nextLine() throws IOException {
        while (true) {
            int c = input.read();
            if (c == -1) {
                break;
            }
            buffer.append((char)c);
        }
        String output = buffer.toString();
        buffer = new StringBuilder();
        return output;
    }
}

public class HWHashMap {
    public static void main(String[] args) throws IOException {
        int n = 1000000;
//        HashMapLinearProbing m1 = new HashMapLinearProbing(n);
        HashMapLinearChaining m2 = new HashMapLinearChaining(n);

        int count = 0;
        //read in the dictionary (213k words)
        FileInputStream fis = null;
        try {
            fis = new FileInputStream("dict.txt");
            MyBufferedReader myReader = new MyBufferedReader(fis);
            String line1 = myReader.nextLine();
//            m1.add(line1, count); // each word has a unique id number
            m2.add(line1);
//            count++;
            System.out.println(line1);
        } finally {
            fis.close();
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


