package other.CS593;

public class Permutation {
    public static void permutation(int[] arr, int N, int n) {
        if (n == 0) {
            for (int i = 0; i < N; i++) {
                System.out.print(arr[i] + " ");
            }
            System.out.println();
            return;
        }

        for (int i = 0; i <= n; i++) {
            swap(arr, i, n);
            permutation(arr, N, n-1);
            swap(arr, i, n);
        }
    }

    private static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    public static void permutation2(int[] arr, int N, int n) {
        if (n == 0) {
            for (int i = 0; i < N; i++) {
                System.out.print(arr[i] + " ");
            }
            System.out.println();
            return;
        }

        for (int c = 0; c <= n; c++) {
            permutation2(arr, N, n-1);
            int which = c % 2 == 1 ? 0 : c;  // is c Odd ？
            System.out.println("swap(" + which + "," + n + ")");
            swap(arr, which, n);
        }
    }

    public static void main(String[] args) {
        final int N = 3;
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = i;
        }

//        permutation(arr, N, N-1);
        permutation2(arr, N, N-1);
    }
}
