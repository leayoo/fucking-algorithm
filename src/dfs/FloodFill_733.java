package dfs;

/**
 * @author: Leeyoa
 * @description:
 * @date: 2023/7/17 15:27
 */
public class FloodFill_733 {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        int origColor = image[sr][sc];
        fill(image, sr, sc, origColor, newColor);
        return image;
    }

    void fill(int[][] image, int x, int y, int origColor, int newColor) {
        int m = image.length;
        int n = image[0].length;
        // 出界：超出数组边界
        if (x < 0 || y < 0 || x >= m || y >= n) return;
        // 碰壁：遇到其他颜色，超出 origColor 区域
        if (image[x][y] != origColor) return;
        // 已经探索过的 origColor 区域
        if (image[x][y] == -1) return;

        // 用回溯算法打标记
        // 前序位置 choose: 打标记，以免重复
        image[x][y] = -1;
        fill(image,x,y+1,origColor,newColor);
        fill(image,x,y-1,origColor,newColor);
        fill(image,x+1,y,origColor,newColor);
        fill(image,x-1,y,origColor,newColor);
        // 后序位置 unchoose: 将标记替换为 newColor
        image[x][y] = newColor;
    }
}
