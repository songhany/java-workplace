package Interview;

import java.util.Arrays;
import java.util.List;

public class LogicTest {
    public static void main(String[] args) {
        Boolean[] res = LogicTest.has(Arrays.asList(0, 1, 2));
        for (Boolean b : res) {
            System.out.println(b);
        }

        res = LogicTest.has(Arrays.asList(-1, -2, -3));
        for (Boolean b : res) {
            System.out.println(b);
        }

        res = LogicTest.has(Arrays.asList(0, -1, 2));
        for (Boolean b : res) {
            System.out.println(b);
        }
    }
    public static Boolean[] has(List<Integer> list) {
        boolean hasP = false;
        boolean hasN = false;
        for (int i = 0; i < list.size();i++) {
            if (hasP && hasN)
                break;
            if (!hasP) {
                hasP = list.get(i) > 0;
            }
            if (!hasN) {
                hasN = list.get(i) < 0;
            }
        }
        return new Boolean[] {hasP, hasN};
    }
}
