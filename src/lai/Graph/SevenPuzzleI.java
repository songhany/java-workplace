package lai.Graph;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;

public class SevenPuzzleI {
    public static void main(String[] args) {
        SevenPuzzleI sol = new SevenPuzzleI();
        int numOfSteps = sol.numOfSteps(new int[]{4, 1, 2, 3, 5, 0, 6, 7});
        System.out.println(numOfSteps);
    }


    final static int[][] DIRS = { {-1,0}, {1,0}, {0,-1}, {0,1} };  // 使得坐标能够分别 i-1, i+1, j-1, j+1

    public int numOfSteps(int[] values) {
        Queue<Board> queue = new ArrayDeque<>();
        Map<Board, Integer> boardStepMap = new HashMap<>();

        Board startBoard = new Board(new int[] {0, 1, 2, 3, 4, 5, 6, 7 });
        queue.offer(startBoard);
        boardStepMap.put(startBoard, 0);

        while (!queue.isEmpty()) {
            Board board = queue.poll();
            int step = boardStepMap.get(board);

            int[] zeroPos = board.findZero();  // find if board[i][j] == 0, return new int[] { i, j }  找到 0 所在的坐标
            int zeroI = zeroPos[0];  // zeroI 是 0所在的row
            int zeroJ = zeroPos[1];  // zeroJ 是 0所在的col

            for (int[] dir : DIRS) {
                int i = zeroI + dir[0];
                int j = zeroJ + dir[1];

                if (!board.outOfBound(i, j)) {
                    board.swap(zeroI, zeroJ, i, j);   // DFS backtrack 吃
                    if (!boardStepMap.containsKey(board)) {  // 如果不包含这个新棋盘状态
                        Board newBoard = board.clone();
                        queue.offer(newBoard);
                        boardStepMap.put(newBoard, step + 1);
                    }
                    board.swap(zeroI, zeroJ, i, j);   // DFS backtrack 吐
                }
            }
        }
        return boardStepMap.getOrDefault(new Board(values), -1);
    }


    static class Board {
        public final static int R = 2;
        public final static int C = 4;
        private int[][] board = new int[R][C];

        public Board() {}

        public Board(int[] values) {
            for (int i = 0; i < R; i++) {
                for (int j = 0; j < C; j++) {
                    board[i][j] = values[i * C + j];  // 注意这里如何计算 values[i * C + j]
                }
            }
        }

        public void swap(int i1, int j1, int i2, int j2) {
            int temp = board[i1][j1];
            board[i1][j1] = board[i2][j2];
            board[i2][j2] = temp;
        }

        public int[] findZero() {
            for (int i = 0; i < R; i++) {
                for (int j = 0; j < C; j++) {
                    if (board[i][j] == 0) {
                        return new int[] { i, j };
                    }
                }
            }
            return null;
        }

        public boolean outOfBound(int i, int j) {
            return i < 0 || i >= R || j < 0 || j >= C;
        }

        @Override
        public int hashCode() {
            int code = 0;
            for (int i = 0; i < R; i++) {
                for (int j = 0; j < C; j++) {
                    code = code * 10 + board[i][j];
                }
            }
            return code;
        }

        @Override
        public boolean equals(Object o) {
            if (!(o instanceof Board)) {
                return false;
            }
            Board b = (Board) o;
            for (int i = 0; i < R; i++) {
                for (int j = 0; j < C; j++) {
                    if (board[i][j] != b.board[i][j]) {
                        return false;
                    }
                }
            }
            return true;
        }

        @Override
        public Board clone() {
            Board c = new Board();
            for (int i = 0; i < R; i++) {
                for (int j = 0; j < C; j++) {
                    c.board[i][j] = board[i][j];
                }
            }
            return c;
        }
    }


}

