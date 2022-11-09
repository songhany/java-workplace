package Interview;

public class Generics {
    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Integer[] intArray = { 1, 2, 3 };
        String[] stringArray = {"Hello", "World"};
        Generics.printArray(intArray);
        Generics.printArray(stringArray);
    }

    private static <E> void printArray(E[] inputArray) {
        for (E e : inputArray) {
            System.out.println(e);
        }
    }
}
