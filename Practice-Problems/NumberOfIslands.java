class NumberOfIslands {
    public int numIslands(char[][] grid) {
        int islandCount = 0;
        int rows = grid.length, cols = grid[0].length;

        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (grid[r][c] == '1') {
                    floodFill(grid, r, c, rows, cols);
                    islandCount++;
                }
            }
        }

        return islandCount;
    }

    private void floodFill(char[][] grid, int r, int c, int rows, int cols) {
        if (r < 0 || c < 0 || r >= rows || c >= cols || grid[r][c] != '1') return;

        grid[r][c] = '0';

        floodFill(grid, r + 1, c, rows, cols);
        floodFill(grid, r - 1, c, rows, cols);
        floodFill(grid, r, c + 1, rows, cols);
        floodFill(grid, r, c - 1, rows, cols);
    }
}
