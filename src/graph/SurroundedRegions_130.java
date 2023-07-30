package graph;

/**
 * @author: Leeyoa
 * @description:
 * @date: 2023/7/29 16:20
 */
public class SurroundedRegions_130 {
    void solve(char[][] board) {
        if (board.length == 0) return;

        int m = board.length;
        int n = board[0].length;

        UFCommon ufCommon = new UFCommon(m * n + 1);
        int dummy = m * n;
        // 将首列和末列的 O 与 dummy 连通
        for (int i = 0; i < m; i++) {
            if (board[i][0] == 'O') {
                ufCommon.union(i * n, dummy);
            }
            if (board[i][n - 1] == 'O') {
                ufCommon.union(i * n + n - 1, dummy);
            }
        }
        // 将首行和末行的 O 与 dummy 连通
        for (int j = 0; j < n; j++) {
            if (board[0][j] == 'O') {
                ufCommon.union(j, dummy);
            }
            if (board[m - 1][j] == 'O') {
                ufCommon.union(n * (m - 1) + j, dummy);
            }
        }

        // 方向数组 d 是上下左右搜索的常用手法
        int[][] d = new int[][]{{1,0},{0,1},{0,-1},{-1,0}};
        for (int i = 1; i < m-1; i++) {
            for (int j = 1; j < n-1; j++) {
                if (board[i][j] == 'O'){
                    // 将此 O 与 上下左右的 O 连通
                    for (int k = 0; k < 4; k++) {
                        int x = i+d[k][0];
                        int y = j+d[k][1];
                        if (board[x][y] == 'O')
                            ufCommon.union(x*n+y, i*n+j);
                    }
                }
            }
        }
        for (int i = 1; i < m-1; i++) {
            for (int j = 1; j < n-1; j++) {
                if (!ufCommon.connected(dummy,i*n+j))
                    board[i][j]='X';
            }
        }
    }
}
