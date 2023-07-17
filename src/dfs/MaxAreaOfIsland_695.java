package dfs;

/**
 * @author: Leeyoa
 * @description:
 * @date: 2023/7/17 11:11
 */
public class MaxAreaOfIsland_695 {
    public int maxAreaOfIsland(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int res = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    res = Math.max(res, dfs(grid, i, j));
                }
            }
        }
        return res;
    }

    // 二维矩阵遍历框架
    int dfs(int[][] grid, int i, int j) {

        // 超出边界
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length) {
            return 0;
        }
        // 访问跳过
        if (grid[i][j] == 0) {
            return 0;
        }
        grid[i][j] = 0;
        return dfs(grid, i - 1, j) + dfs(grid, i + 1, j)
                + dfs(grid, i, j - 1) + dfs(grid, i, j + 1)+1;
    }
}
