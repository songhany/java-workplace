package lai.Graph;

import java.util.*;

public class WordLadderI {
    public static void main(String[] args) {
        System.out.println(ladderLength("git", "hot", new ArrayList<>(Arrays.asList("git","hit","hog","hot"))));
    }

    public static int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> wordSet = new HashSet<>(wordList);
        if (!wordSet.contains(endWord)) {
            return 0;
        }
        wordSet.remove(beginWord);
        wordSet.remove(endWord);

        Queue<String> queue = new ArrayDeque<>();
        queue.offer(beginWord);
        int step = 1;
        while (!queue.isEmpty()) {
            step++;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                char[] word = queue.poll().toCharArray();
                for (int j = 0; j < word.length; j++) {
                    char backup = word[j];
                    for (char c = 'a'; c <= 'z'; c++) {
                        if (c == backup) continue;
                        word[j] = c;

                        String mutation = new String(word);
                        if (mutation.equals(endWord)) {
                            return step;
                        }
                        if (wordSet.contains(mutation)) {
                            queue.offer(mutation);
                            wordSet.remove(mutation);
                        }
                        word[j] = backup;
                    }
                }
            }
        }
        return 0;
    }
}
