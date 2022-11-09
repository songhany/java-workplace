package laiCode.dp;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class DictionaryWord {
    public boolean canBreak(String input, Set<String> dict) {
        // M[i] represents the substring [0, i)
        // M[0] represents "", M[1] represents input[0], M[2] represents input[0-1]
        boolean[] M = new boolean[input.length() + 1];
        M[0] = true;
        for (int i = 1; i <= input.length(); i++) {     // i 个 letter

            for (int j = 0; j < i; j++) {   // first j letter as 左大段
                if (M[j] && dict.contains(input.substring(j, i))) {
                    M[i] = true;
                    break;
                }
            }
        }
        return M[input.length()];
    }


    public static void main(String[] args) {
        DictionaryWord sol = new DictionaryWord();
        System.out.println(sol.canBreak("bo", new HashSet<>(Arrays.asList("bob", "cat", "rob"))));
        System.out.println(sol.canBreak("catbob", new HashSet<>(Arrays.asList("bob", "cat", "rob"))));

        boolean canOrCannot = sol.canBreak1("bo", new String[]{"bob", "cat", "rob"});
        System.out.println(canOrCannot);

        canOrCannot = sol.canBreak1("catbob", new String[]{"bob", "cat", "rob"});
        System.out.println(canOrCannot);
    }

    public boolean canBreak1(String input, String[] dict) {
        Set<String> dictSet = toSet(dict);

        boolean[] canBreak = new boolean[input.length() + 1];
        canBreak[0] = true;

        for (int i = 1; i < canBreak.length; i++) {
            for (int j = 0; j < i; j++) {
                if (dictSet.contains((input.substring(j, i))) && canBreak[j]) {
                    canBreak[i] = true;
                    break;
                }
            }
        }
        return canBreak[canBreak.length - 1];
    }

    private Set<String> toSet(String[] dict) {
        Set<String> set = new HashSet<>();
        for (String s : dict) {
            set.add(s);
        }
        return set;
    }
}
