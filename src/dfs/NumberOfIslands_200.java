package dfs;

/**
 * @author: Leeyoa
 * @description:
 * @date: 2023/7/17 10:36
 */
public class NumberOfIslands_200 {
    // 主函数，计算岛屿数量
    public int numIslands(char[][] grid) {
        int res = 0;
        int m = grid.length;
        int n = grid[0].length;

        // 遍历 grid
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1'){
                    // 每发现一个岛屿，岛屿数量加 1
                    res++;
                    // 使用 DFS 将岛屿淹没
                    dfs(grid, i, j);
                }
            }
        }
        return res;
    }

    // 二维矩阵遍历框架
    void dfs(char[][] grid, int i, int j){
        int m = grid.length, n = grid[0].length;
        if (i < 0 || j < 0 || i >=m || j >= n){
            //超出索引边界
            return;
        }
        if (grid[i][j] == '0'){
            // 已经是海水了
            return;
        }
        // 进入节点(i, j)，将其淹没
        grid[i][j] = '0';
        dfs(grid, i-1, j); // 上
        dfs(grid, i+1, j); // 下
        dfs(grid, i, j-1); // 左
        dfs(grid, i, j+1); // 右
    }
}
