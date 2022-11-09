package laiBasic;

public class RemoveDuplicate {
    public static int[] removeDuplicate(int[] arr, int duplicate) {
        // 1. count the occurrance of duplicate
        int count = 0;
        for (int num: arr) {
            if (num == duplicate) {
                count++;
            }
        }

        // 2. create a array: size = Len(input) - Count(duplicate)
        int[] result = new int[arr.length - count];

        // 3. copy elements accordingly
        //    i) if duplicate: continue
        //   ii) non-duplicate: copy element in original array to Result[]
        int index = 0;
        for (int num: arr) {
            if (num == duplicate) {
                continue;
            } else {
                result[index] = num;
                index++;
            }
        }

        return result;
    }

    public static void main(String[] args) {
    }
}
