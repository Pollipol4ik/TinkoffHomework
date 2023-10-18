package edu.hw1;

public class Task8 {
    private static final int SIZE = 8;
    private static final int POSITION = -2;

    public boolean isSafe(int[][] board) {
        int[] dx = {POSITION, POSITION, -1, -1, 1, 1, 2, 2};
        int[] dy = {-1, 1, POSITION, 2, POSITION, 2, -1, 1};
        int n = board.length;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 1) {
                    for (int k = 0; k < SIZE; k++) {
                        int x = i + dx[k];
                        int y = j + dy[k];
                        if (x >= 0 && x < n && y >= 0 && y < n && board[x][y] == 1) {
                            return false;
                        }
                    }
                }
            }
        }

        return true;
    }

}
