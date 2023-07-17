package dfs;

import java.util.HashSet;

/**
 * @author: Leeyoa
 * @description:
 * @date: 2023/7/17 14:58
 */
public class NumberOfDistinctIslands_694 {
    int numDistinctIslands(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        HashSet<String> islands = new HashSet<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1){
                    StringBuilder sb = new StringBuilder();
                    // 初始的方向可以随便写，不影响正确性
                    dfs(grid,i,j,sb,666);
                    islands.add(sb.toString());
                }
            }
        }
        return islands.size();
    }

    void dfs(int[][] grid, int i, int j, StringBuilder sb, int dir) {
        int m = grid.length;
        int n = grid[0].length;

        if (i < 0 || j < 0 || i >= m || j >= n || grid[i][j] == 0) {
            return;
        }

        // 前序遍历位置，进入(i, j)
        grid[i][j] = 0;
        sb.append(dir).append(',');

        // 递归顺序：
        dfs(grid, i - 1, j, sb,1); // 上
        dfs(grid, i + 1, j, sb,2); // 下
        dfs(grid, i, j - 1, sb,3); // 左
        dfs(grid, i, j + 1, sb,4); // 右

        // 后序遍历位置，离开(i,j)
        sb.append(-dir).append(',');

    }

}
