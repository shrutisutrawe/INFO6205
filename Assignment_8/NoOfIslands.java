package INFO6205.Assignment_8;

public class NoOfIslands {
    public static int numIslands(char[][] grid){
        if (grid.length == 0) {
            return 0;
        }
        int noOfIslands = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == '1') {
                    noOfIslands++;
                    checkNeighbors(grid, i, j, grid.length, grid[i].length);
                }
            }
        }
        return noOfIslands;
    }

    private static void checkNeighbors(char[][] grid, int i, int j, int row, int col) {
        if (i < 0 || j < 0 || i >= row || j >= col || grid[i][j] != '1') {
            return;
        }
        grid[i][j] = '2';
        checkNeighbors(grid, i, j + 1, row, col);
        checkNeighbors(grid, i + 1, j, row, col);
        checkNeighbors(grid, i, j - 1, row, col);
        checkNeighbors(grid, i - 1, j, row, col);
    }
    public static void main(String[] args){
        char[][] grid = {{'1','1','1','1','0'},{'1','1','0','1','0'},{'1','1','0','0','0'},{'0','0','0','0','0'}};
        System.out.println(numIslands(grid));
    }
}
