package dfs;

/**
 * @author: Leeyoa
 * @description:
 * @date: 2023/7/17 10:47
 */
public class NumberOfClosedIslands_1254 {

    // 主函数，计算封闭岛屿的数量
    public int closedIsland(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        // 将左右岛屿淹没
        for (int i = 0; i < m; i++) {
            dfs(grid, i, 0);
            dfs(grid, i, n-1);

        }
        // 将上下岛屿淹没
        for (int j = 0; j < n; j++) {
            dfs(grid, 0, j);
            dfs(grid, m-1, j);
        }
        // 遍历 grid, 剩下的岛屿都是封闭岛屿
        int res = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                // 判断陆地
                if (grid[i][j] == 0){
                    res++;
                    dfs(grid,i,j);
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
        if (grid[i][j] == 1){
            return;
        }
        // 进入节点(i, j)
        grid[i][j] = 1;
        dfs(grid, i-1, j); // 上
        dfs(grid, i+1, j); // 下
        dfs(grid, i, j-1); // 左
        dfs(grid, i, j+1); // 右
    }

}
