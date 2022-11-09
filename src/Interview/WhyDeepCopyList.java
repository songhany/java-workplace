package Interview;

import java.util.ArrayList;
import java.util.List;

public class WhyDeepCopyList {
    public static void main(String[] args) {
        List<List<Integer>> result = new ArrayList<>();
        List<List<Integer>> resultForDeepCopy = new ArrayList<>();
        List<Integer> path = new ArrayList<>();

        path.add(1);
        path.add(2);
        path.add(3);

        result.add(path);
        result.add(path);

        resultForDeepCopy.add(new ArrayList<>(path));
        resultForDeepCopy.add(new ArrayList<>(path));

        System.out.println(result);
        System.out.println(resultForDeepCopy);
        System.out.println("===============================");
        path.remove(path.size() - 1);
        System.out.println(result);
        System.out.println(resultForDeepCopy);
    }
}
