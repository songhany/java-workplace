package lai.Graph;

import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.Queue;
import java.util.Set;

public class SevenPuzzle {
    class State {
        String board;   // 当前棋盘状态
        int zeroIndex;  // 0's index in board  当前棋盘 0 所在的位置

        State(String board, int zeroIndex) {
            this.board = board;
            this.zeroIndex = zeroIndex;
        }
    }

    public int numOfSteps(int[] values) {
        StringBuilder boardBuilder = new StringBuilder();
        for (int i = 0; i < values.length; i++) {
            boardBuilder.append(values[i]);
        }
        Queue<State> queue = new ArrayDeque<>();
        Set<String> visited = new HashSet<>();
        int[][] nextIndexZeroCanGoMap =
                new int[][] {{1, 4}, {0, 2, 5}, {1, 3, 6}, {2, 7}, {0, 5}, {1, 4, 6}, {2, 5, 7}, {3, 6}};  // the index which 0 in board can go next time 根据 0 在棋盘不同的位置，提前分析出来 0 可以往哪个index走

        String initialBoard = boardBuilder.toString();
        State initial = new State(initialBoard, initialBoard.indexOf('0'));
        queue.offer(initial);
        visited.add(initial.board);

        int steps = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                State curState = queue.poll();
                if (isSolved(curState.board)) {
                    return steps;
                }

                for (int nextIdx : nextIndexZeroCanGoMap[curState.zeroIndex]) {
                    String nextBoard = swap(curState.board, curState.zeroIndex, nextIdx);
                    boolean unvisited = visited.add(nextBoard);
                    if (!unvisited)
                        continue;
                    queue.offer(new State(nextBoard, nextIdx));
                }
            }
            steps++;
        }

        return -1;
    }

    private boolean isSolved(String state) {
        String finalState = "01234567";
        return state.equals(finalState);
    }

    private String swap(String s, int i, int j) {
        StringBuilder sb = new StringBuilder(s);
        sb.setCharAt(i, s.charAt(j));
        sb.setCharAt(j, s.charAt(i));
        return sb.toString();
    }

    public static void main(String[] args) {
        SevenPuzzle sol = new SevenPuzzle();
        int numOfSteps = sol.numOfSteps(new int[]{4,1,2,3,5,0,6,7});
        System.out.println(numOfSteps);
    }
}


/*
Example:

Input: [4,1,2,3,5,0,6,7]
Output: 2

Explanation:
Initial state is:
4 1 2 3
5 0 6 7

First swap 0 with 5, then the state is:
4 1 2 3
0 5 6 7

Then swap 0 with 4, then we get the final state:
0 1 2 3
4 5 6 7

* */
