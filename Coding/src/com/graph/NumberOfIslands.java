package com.graph;

public class NumberOfIslands {

    public void DFS(int i, int j, char[][] mat) {
        int n = mat.length;
        int m = mat[0].length;

        if (i < 0 || j < 0 || i >= n || j >= m || mat[i][j] == '0') return;

        mat[i][j] = '0';

        DFS(i - 1, j, mat);
        DFS(i + 1, j, mat);
        DFS(i, j - 1, mat);
        DFS(i, j + 1, mat);
    }

    public int numIslands(char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int count = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == '1') {
                    DFS(i, j, grid);
                    count++;
                }
            }
        }

        return count;
    }

    public static void main(String[] args) {

        char[][] grid = {
                {'1','1','0','0','0'},
                {'1','1','0','0','0'},
                {'0','0','1','0','0'},
                {'0','0','0','1','1'}
        };

        NumberOfIslands obj = new NumberOfIslands();

        int result = obj.numIslands(grid);

        System.out.println("Number of Islands: " + result);
    }
}
