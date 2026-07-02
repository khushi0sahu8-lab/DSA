import java.util.*;

class Solution {

    int n, m;
    int[][] dirs = {{1,0},{-1,0},{0,1},{0,-1}};

    public boolean findSafeWalk(List<List<Integer>> grid, int health) {

        n = grid.size();
        m = grid.get(0).size();

        int[][] best = new int[n][m];
        for (int[] row : best)
            Arrays.fill(row, -1);

        Queue<int[]> q = new LinkedList<>();

        int start = grid.get(0).get(0);
        int startHealth = health - start;

        if (startHealth <= 0) return false;

        q.offer(new int[]{0, 0, startHealth});
        best[0][0] = startHealth;

        while (!q.isEmpty()) {

            int[] cur = q.poll();
            int r = cur[0], c = cur[1], h = cur[2];

            if (r == n - 1 && c == m - 1)
                return true;

            for (int[] d : dirs) {

                int nr = r + d[0];
                int nc = c + d[1];

                if (nr >= 0 && nc >= 0 && nr < n && nc < m) {

                    int newHealth = h - grid.get(nr).get(nc);

                    if (newHealth > 0 && newHealth > best[nr][nc]) {
                        best[nr][nc] = newHealth;
                        q.offer(new int[]{nr, nc, newHealth});
                    }
                }
            }
        }

        return false;
    }
}