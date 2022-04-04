package HW2;

public class Percolation{
    boolean[][] grid;
    private int size;
    private int numOfOpen;
    private WeightedQuickUnionUF uf;
    private int vTop;
    private int vBottom;

    public Percolation(int N){
        if(N < 0){
            throw new IndexOutOfBoundsException();
        }
       boolean[][] grid = new boolean[N][N];
       size = N;
       for(int i = 0; i < N; i ++){
           for(int j = 0; j < N; j++){
               grid[i][j] = false;
           }
       }
       vTop = N * N;
       vBottom = N * N + 1;
    }

    public void open(int row, int col){
        if(row < 0 || col < 0 || row >= size || col >= size){
            throw new IndexOutOfBoundsException();
        }
        numOfOpen+=1;
        grid[row][col] = true;

        if(row == 0){
            uf.union(xyTo1D(row,col), vTop);
        }

        if(row == grid.length - 1){
            uf.union(xyTo1D(row, col), vBottom);
        }

        if(row - 1>=0 && isOpen(row-1, col)){
            uf.union(xyTo1D(row-1,col),xyTo1D(row , col));
        }

        if(row + 1 <= grid.length-1 && isOpen(row + 1, col)){
            uf.union(xyTo1D(row + 1, col), xyTo1D(row , col));
        }

        if(col - 1 >= 0 && isOpen(row, col - 1)){
            uf.union(xyTo1D(row, col - 1), xyTo1D(row, col));
        }

        if(col + 1 <= grid.length-1 && isOpen(row, col + 1)){
            uf.union(xyTo1D(row, col + 1), xyTo1D(row, col));
        }
    }

    public boolean isOpen(int row, int col){
        if(row < 0 || col < 0 || row >= size || col >= size){
            throw new IndexOutOfBoundsException();
        }
        return grid[row][col];
    }

    public boolean isFull(int row, int col){
        if(row < 0 || col < 0 || row >= size || col >= size){
            throw new IndexOutOfBoundsException();
        }
        return uf.connected(xyTo1D(row,col),vTop);
    }

    public int numberOfOpenSites(){
        return numOfOpen;
    }

    public boolean percolates(){
        return uf.connected(vTop, vBottom);
    }

    public int xyTo1D(int r, int c){
        return r * grid.length + c;
    }

    public static void main(String[] args){

    }
}
