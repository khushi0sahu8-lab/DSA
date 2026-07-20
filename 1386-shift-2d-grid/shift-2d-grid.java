import java.util.*;

class Solution {
    public List<List<Integer>> shiftGrid(int[][] grid, int k) {

        int m = grid.length;
        int n = grid[0].length;

        List<Integer> arr = new ArrayList<>();

        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                arr.add(grid[i][j]);
            }
        }

        int size = m * n;
        k = k % size;

        Collections.rotate(arr, k);

        List<List<Integer>> ans = new ArrayList<>();

        int index = 0;

        for(int i = 0; i < m; i++) {
            List<Integer> row = new ArrayList<>();

            for(int j = 0; j < n; j++) {
                row.add(arr.get(index++));
            }

            ans.add(row);
        }

        return ans;
    }
}