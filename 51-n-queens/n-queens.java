import java.util.*;

class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> result = new ArrayList<>();

        char[][] board = new char[n][n];

        for (int i = 0; i < n; i++) {
            Arrays.fill(board[i], '.');
        }

        boolean[] cols = new boolean[n];
        boolean[] diag1 = new boolean[2 * n - 1]; 
        boolean[] diag2 = new boolean[2 * n - 1]; 
        backtrack(0, n, board, result, cols, diag1, diag2);

        return result;
    }

    private void backtrack(int row, int n, char[][] board,
                           List<List<String>> result,
                           boolean[] cols,
                           boolean[] diag1,
                           boolean[] diag2) {

        if (row == n) {
            List<String> temp = new ArrayList<>();

            for (char[] r : board) {
                temp.add(new String(r));
            }

            result.add(temp);
            return;
        }

        for (int col = 0; col < n; col++) {

            if (cols[col] || 
                diag1[row - col + n - 1] || 
                diag2[row + col]) {
                continue;
            }

            board[row][col] = 'Q';
            cols[col] = true;
            diag1[row - col + n - 1] = true;
            diag2[row + col] = true;

            backtrack(row + 1, n, board, result, cols, diag1, diag2);

            board[row][col] = '.';
            cols[col] = false;
            diag1[row - col + n - 1] = false;
            diag2[row + col] = false;
        }
    }
}