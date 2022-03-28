package cs61b;

public class BubbleGrid {
    private int[][] grid;
    private int rowNum;
    private int colNum;
    private int ceiling = 0;
    private int[][] dirs = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}}; //偏移量数组

    public BubbleGrid(int[][] Grid) {
        this.grid = grid;
        rowNum = grid.length;
        colNum = grid[0].length;
    }

    public int[] popBubbles(int[][] darts) {
        UnionFind uf = new UnionFind(rowNum * colNum+1);
        for(int[] dart : darts){
            if(grid[dart[0]][dart[1]] == 1){
                grid[dart[0]][dart[1]] = 2;
            }
        }

        for(int row = 0; row < rowNum; row++){
            for(int col = 0; col < colNum; col++){
                if(grid[row][col] == 1){
                    unionNeighbor(row, col, uf, grid);
                }
            }
        }

        int[] res = new int[darts.length];
        int count = uf.sizeOf(ceiling);
        for(int i = darts.length - 1; i >= 0; i--){
            int row = darts[i][0];
            int col = darts[i][1];
            if(grid[row][col] == 2){
                unionNeighbor(i, 0, uf, grid);
                grid[row][col] = 1;
            }

            int newcount = uf.sizeOf(ceiling);
            res[i] = newcount > count ? newcount - count - 1 : 0;
            count = newcount;
        }
        return res;

    }

    public void unionNeighbor(int row, int col, UnionFind uf, int[][] grid){
        if (row == 0) {
            uf.union(xyTo1D(row, col), ceiling);
        }
        for(int[] dir : dirs){
            int newr = row + dir[0];
            int newc = col + dir[1];
            if(newr < 0 || newr == rowNum || newc < 0 || newc == colNum || grid[newr][newc] != 1){
                continue;
            }
            uf.union(xyTo1D(row, col) , xyTo1D(newr, newc));
        }
    // Turn (row, col) to uf index
    }
    private int xyTo1D(int row, int col) {
        return row * rowNum + col + 1;
    }

}
