package HWOD;

/**
 * @author: Leeyoa
 * @description:
 * @date: 2023/7/26 11:42
 */

public class Monitor {

    // 二位矩阵遍历框架
    void dfs(int[][] grid, int i, int j, boolean[][] visited) {
        int m = grid.length, n = grid[0].length;
        if (i < 0 || j < 0 || i >= m || j >= n) {
            return;
        }
        if (visited[i][j]){
            return;
        }
        visited[i][j] = true;
        dfs(grid, i-1, j, visited);
        dfs(grid, i+1, j, visited);
        dfs(grid, i, j-1, visited);
        dfs(grid, i, j+1, visited);
    }
}
