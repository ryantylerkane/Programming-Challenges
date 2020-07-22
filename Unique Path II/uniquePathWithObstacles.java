class Solution {
    
    int memo[][];
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        
        if(obstacleGrid.length==0)
            return 0;
        
        memo = new int[obstacleGrid.length][obstacleGrid[0].length];
        
        return countPaths(obstacleGrid, 0,0);
    }
    
    private int countPaths(int[][] grid, int row, int col)
    {
        if(row > grid.length-1 || col >grid[0].length-1 ||grid[row][col] == 1) //Obstacle reached, path is no longer valid.
        {
            return 0;
        }
        if(row==grid.length-1 && col==grid[row].length-1) //Base Case - Finish reached.
        {
            return 1;
        }
        if(memo[row][col]==0) //Have yet to analyze paths from this square.
        {
            memo[row][col] = countPaths(grid, row+1, col) + countPaths(grid, row, col+1);
        }
        
        //Otherwise, we have analyzed the paths from this square.
        return memo[row][col];
    }
}