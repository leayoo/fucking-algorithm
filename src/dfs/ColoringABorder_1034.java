package dfs;

import java.util.Arrays;

/**
 * @author: Leeyoa
 * @description:
 * @date: 2023/7/17 15:47
 */
public class ColoringABorder_1034 {


    public int[][] colorBorder(int[][] grid, int row, int col, int color) {
        int m = grid.length;
        int n = grid[0].length;
        boolean[][] visited = new boolean[m][n];

        int origColor = grid[row][col];
        fill(grid, row, col, origColor, color, visited);
        return grid;
    }

    int fill(int[][] image, int x, int y, int origColor, int newColor, boolean[][] visited) {
        int m = image.length;
        int n = image[0].length;
        // 排除顺序不能乱
        // 出界：超出数组边界
        if (x < 0 || y < 0 || x >= m || y >= n) return 0;
        // 已经探索过的 origColor 区域
        if (visited[x][y]) return 1;
        // 碰壁：遇到其他颜色，超出 origColor 区域
        if (image[x][y] != origColor) return 0;

        visited[x][y] = true;
        int surround =
                fill(image, x, y + 1, origColor, newColor, visited) +
                        fill(image, x, y - 1, origColor, newColor, visited) +
                        fill(image, x + 1, y, origColor, newColor, visited) +
                        fill(image, x - 1, y, origColor, newColor, visited);

        if (surround < 4){
            image[x][y] = newColor;
        }
        return 1;
    }

    public static void main(String[] args) {
        ColoringABorder_1034 coloringABorder1034 = new ColoringABorder_1034();
        int[][] grid = {{1,1},{1,2}};
        int row = 0, col = 0, color = 3;
        System.out.println(Arrays.deepToString(coloringABorder1034.colorBorder(grid, row, col, color)));
    }
}
