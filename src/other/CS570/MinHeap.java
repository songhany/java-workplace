package other.CS570;

import java.util.*;

public class MinHeap {

    private ArrayList<Integer> data;

    public MinHeap() {
        data = new ArrayList<Integer>();
    }

    public boolean add(Integer item) {
        data.add(item);

        int child = data.size() - 1;
        int parent = (child - 1) / 2;
        while (parent >= 0 && data.get(parent) > data.get(child)) {
            Integer tmp = data.get(parent);
            data.set(parent,data.get(child));
            data.set(child, tmp);

            child = parent;
            parent = (child - 1) / 2;
        }
        return true;
    }

    public Integer remove() {
        if (data.size() == 0) {
            return null;
        }
        Integer result = data.get(0);

        if (data.size() == 1) {
            data.remove(0);
            return result;
        }
        data.set(0, data.remove(data.size() - 1));
        int parent = 0;

        while (true) {
            int leftChild = 2 * parent + 1;
            if (leftChild >= data.size()) {
                break;
            }

            int rightChild = leftChild + 1;
            int minChild = leftChild;

            if (rightChild < data.size() && data.get(leftChild) > data.get(rightChild)) {
                minChild = rightChild;
            }

            if (data.get(parent) > data.get(minChild)) {
                Integer tmp = data.get(parent);
                data.set(parent, data.get(minChild));
                data.set(minChild, tmp);

                parent = minChild;
            } else {
                break;
            }
        }
        return result;
    }

    public void printHeap() {
        int k = 1;
        int j = 0;

        for (int i = 0; i < data.size(); ++i) {
            System.out.print(data.get(i) + " ");
            ++j;
            if (j == k) {
                j = 0;
                k = k*2;
                System.out.println();
            }
        }
    }

    public static void main(String[] args) {
        MinHeap H = new MinHeap();
        H.add(12);
        H.add(5);
        H.add(4);
        H.add(35);
        H.add(44);
        H.add(7);
        H.add(24);
        H.printHeap();
        System.out.println();
        System.out.println(H.remove());
        System.out.println();
        H.printHeap();
    }
}
