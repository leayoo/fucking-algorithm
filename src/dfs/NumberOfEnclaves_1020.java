package dfs;

/**
 * @author: Leeyoa
 * @description:
 * @date: 2023/7/17 11:00
 */
public class NumberOfEnclaves_1020 {
    public int numEnclaves(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        // 淹没左右
        for (int i = 0; i < m; i++) {
            dfs(grid, i, 0);
            dfs(grid, i, n-1);

        }
        // 淹没上下
        for (int j = 0; j < n; j++) {
            dfs(grid, 0, j);
            dfs(grid, m-1, j);
        }
        // 开始计算飞岛，直接遍历淹没后的表即可
        int res = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1){
                    res += 1;
                }
            }
        }
        return res;
    }

    // 二维矩阵遍历框架
    void dfs(int[][] grid, int i, int j){
        int m = grid.length, n = grid[0].length;
        if (i < 0 || j < 0 || i >=m || j >= n){
            //超出索引边界
            return;
        }
        if (grid[i][j] == 0){
            // 一边遍历过(i, j)
            return;
        }
        // 进入节点(i, j)
        grid[i][j] = 0;
        dfs(grid, i-1, j); // 上
        dfs(grid, i+1, j); // 下
        dfs(grid, i, j-1); // 左
        dfs(grid, i, j+1); // 右
    }

}
